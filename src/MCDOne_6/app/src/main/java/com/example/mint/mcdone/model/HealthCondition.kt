package com.example.mint.mcdone.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "addHConditionTbl")
data class HealthCondition(
        @PrimaryKey(autoGenerate = true)
        var id:Int?,

        @ColumnInfo(name = "condition")
        var condition: String

)