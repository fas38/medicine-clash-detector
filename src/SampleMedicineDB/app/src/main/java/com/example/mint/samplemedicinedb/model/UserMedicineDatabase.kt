package com.example.mint.samplemedicinedb.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [UserMedicine::class], version = 1)

abstract  class  UserMedicineDatabase : RoomDatabase(){
    abstract fun userMedicineDao() : UserMedicineDao

    companion object {
        var INSTANCE: UserMedicineDatabase? = null

        fun getUserMedicineDatabase(context: Context): UserMedicineDatabase? {
            if (INSTANCE == null){
                synchronized(UserMedicineDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserMedicineDatabase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}