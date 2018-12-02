package com.example.mint.samplemedicinedb.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.arch.persistence.db.SupportSQLiteDatabase

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
                MedicineDatabase::class.java, "Sample.db")
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

        val PREPOPULATE_DATA = listOf(Medicine(1, "Ace", "Fever", "kidney"),
            Medicine(2, "Napa", "Fever", "kidney"),
            Medicine(3, "Neotack", "Gas", "heart"))

    }
}