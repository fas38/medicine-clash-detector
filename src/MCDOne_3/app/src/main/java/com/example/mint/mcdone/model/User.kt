package com.example.mint.mcdone.model

data class User(val name: String,
                val healthCondition: String,
                val profilePicturePath: String?){

    constructor():this("", "", null)
}