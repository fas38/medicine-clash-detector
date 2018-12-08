package com.example.mint.mcdone.model

//User entity for firebase database

data class User(val name: String,
                val healthCondition: String,
                val profilePicturePath: String?){

    constructor():this("", "", null)
}