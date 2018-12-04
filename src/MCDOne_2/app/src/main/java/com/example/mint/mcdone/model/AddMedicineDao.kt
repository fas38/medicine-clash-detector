package com.example.mint.mcdone.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface addMedicineDao{
    @Query("SELECT * FROM addmedicinetbl")
    fun allAddMedicine():List<AddMedicine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(addMedicine: AddMedicine)
}