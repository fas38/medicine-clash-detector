package com.example.mint.mcdone.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(HealthCondition::class), version = 1)
abstract class HealthConditionDatabase : RoomDatabase() {
    abstract fun healthConditionDao(): HealthConditionDao

    companion object {
        private var INSTANCE: HealthConditionDatabase? = null
        fun getInstance(context: Context): HealthConditionDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                        context,
                        HealthConditionDatabase::class.java,
                        "healthconditiondb")
                        .build()
            }
            return INSTANCE as HealthConditionDatabase
        }
    }
}