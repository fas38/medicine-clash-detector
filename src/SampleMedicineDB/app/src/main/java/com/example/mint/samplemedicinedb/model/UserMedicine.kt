package com.example.mint.samplemedicinedb.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class UserMedicine(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val brandName: String)