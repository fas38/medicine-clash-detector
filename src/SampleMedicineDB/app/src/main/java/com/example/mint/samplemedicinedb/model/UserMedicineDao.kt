package com.example.mint.samplemedicinedb.model

import android.arch.persistence.room.*

@Dao
interface UserMedicineDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedicine(medicine: UserMedicine)

    @Update
    fun updateMedicine(medicine: UserMedicine)

    @Delete
    fun deleteMedicine(medicine: UserMedicine)

    @Query("SELECT * FROM UserMedicine")
    fun getMedicines(): List<UserMedicine>
}