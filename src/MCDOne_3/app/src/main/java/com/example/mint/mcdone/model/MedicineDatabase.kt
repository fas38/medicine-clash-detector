package com.example.mint.mcdone.model

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Medicine::class), version = 1)

abstract class MedicineDatabase : RoomDatabase(){
    abstract fun medicineDao(): MedicineDao

    companion object {

        @Volatile private var INSTANCE: MedicineDatabase? = null

        fun getInstance(context: Context): MedicineDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also{ INSTANCE = it}
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        MedicineDatabase::class.java, "medicine.db")
                        // prepopulate the database after onCreate was called
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                // insert the data on the IO Thread
                                ioThread {
                                    getInstance(context).medicineDao().insertMedicine(PREPOPULATE_DATA)
                                }
                            }
                        })
                        .build()

        val PREPOPULATE_DATA = listOf(
                Medicine(1, "Ace", "ParacitamolBP", "Losectil", "Heart Disease"),
                Medicine(2, "Napa", "ParacitamolBP", "Alben", "High Blood Pressure"),
                Medicine(3, "Neotack", "OmiprazolBP", "Tufnil", "Kidney")
                )

    }
}