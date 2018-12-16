package com.example.mint.mcdone.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 This is the medicine entity class for adding
 medicine.
 */

@Entity(tableName = "addMedicineTbl")
data class AddMedicine(
        @PrimaryKey(autoGenerate = true)
        var id:Int?,

        @ColumnInfo(name = "bName")
        var bName: String

)