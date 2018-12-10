package com.example.mint.mcdone.model

import android.arch.persistence.room.*

@Dao
interface HealthConditionDao{
    @Query("SELECT * FROM addHConditionTbl")
    fun allconditions():List<HealthCondition>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(healthCondition: HealthCondition)

    @Delete
    fun delete(healthCondition: HealthCondition)

    @Query("DELETE FROM addHConditionTbl")
    fun nukeTable()
}