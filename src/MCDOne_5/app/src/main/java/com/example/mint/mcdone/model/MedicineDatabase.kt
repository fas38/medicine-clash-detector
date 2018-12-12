package com.example.mint.mcdone.model

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

//Pre-populated medicine database

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
                Medicine(1, "Ace", "Paracetamol", "Paracetamol,Aspirin", "kidney,liver"),
                Medicine(2, "Napa", "Paracetamol", "Paracetamol,Aspirin", "kidney,liver"),
                Medicine(3, "Neotack", "Ranitidine", "Ranitidine,Ketoconazole", ""),
                Medicine(4, "MaXpro", "Esomeprazole", "Esomeprazole,Ketoconazole", "Lactation"),
                Medicine(5, "Konadel", "Ketoconazole", "Ketoconazole,Ranitidine", "liver")
                )

    }
}