package com.example.mint.mcdone.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

//Medicine entity for pre-populate database

@Entity
data class Medicine(
        @PrimaryKey(autoGenerate = true)
        val id: Int? = null,
        val brandName: String,
        val genericName: String,
        val clashMed: String,
        val conditions: String)