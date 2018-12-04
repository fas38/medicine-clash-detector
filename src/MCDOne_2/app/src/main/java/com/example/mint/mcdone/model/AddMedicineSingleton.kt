package com.example.mint.mcdone.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(AddMedicine::class), version = 1)
abstract class AddMedicineSingleton : RoomDatabase() {
    abstract fun addMedicineDao(): addMedicineDao

    companion object {
        private var INSTANCE: AddMedicineSingleton? = null
        fun getInstance(context: Context): AddMedicineSingleton {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                        context,
                        AddMedicineSingleton::class.java,
                        "addmedicinedb")
                        .build()
            }
            return INSTANCE as AddMedicineSingleton
        }
    }
}