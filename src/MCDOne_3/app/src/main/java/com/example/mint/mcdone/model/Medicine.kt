package com.example.mint.mcdone.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Medicine(
        @PrimaryKey(autoGenerate = true)
        val id: Int? = null,
        val brandName: String,
        val genericName: String,
        val clashMed: String,
        val conditions: String)