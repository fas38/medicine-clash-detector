package com.example.mint.mcdone.model

import android.arch.persistence.room.*

@Dao
interface addMedicineDao{
    @Query("SELECT * FROM addmedicinetbl")
    fun allAddMedicine():List<AddMedicine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(addMedicine: AddMedicine)

    @Delete
    fun delete(addMedicine: AddMedicine)
}