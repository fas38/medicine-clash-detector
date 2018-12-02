package com.example.mint.samplemedicinedb.model

import android.arch.persistence.room.*

@Dao
interface MedicineDao{
    @Insert
    fun insertMedicine(medicine: List<Medicine>)

    @Query("SELECT * FROM Medicine")
    fun getMedicines(): List<Medicine>
}