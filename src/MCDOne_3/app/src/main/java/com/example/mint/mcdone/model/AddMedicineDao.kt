package com.example.mint.mcdone.model

import android.arch.persistence.room.*

// Data Access Object class for adding medicine activity

@Dao
interface addMedicineDao{
    @Query("SELECT * FROM addmedicinetbl")
    fun allAddMedicine():List<AddMedicine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(addMedicine: AddMedicine)

    @Delete
    fun delete(addMedicine: AddMedicine)

    @Query("DELETE FROM addmedicinetbl")
    fun nukeTable()
}