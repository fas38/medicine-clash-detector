package com.example.mint.mcdone.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

//Data Access Object class for pre-populated medicine database

@Dao
interface MedicineDao{
    @Insert
    fun insertMedicine(medicine: List<Medicine>)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertMedicine2(medicine: Medicine)

    @Query("SELECT * FROM Medicine")
    fun getMedicines(): List<Medicine>
}