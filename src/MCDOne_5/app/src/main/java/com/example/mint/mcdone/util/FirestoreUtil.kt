package com.example.mint.mcdone.util

import android.util.Log
import android.widget.Toast
import com.example.mint.mcdone.model.User
import com.firebase.ui.auth.ui.email.CheckEmailFragment.TAG
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

//Singleton for getting user informations from firestore

object FirestoreUtil {
    //Initialize Variabbles
    private val firestoreInstance: FirebaseFirestore by lazy {FirebaseFirestore.getInstance()}

    var health: String? = ""
    var med: String? = ""

    //Get documenet reference for current user
    private val currentUserDocRef: DocumentReference
        get() = firestoreInstance.document("users/${FirebaseAuth.getInstance().currentUser?.uid
                ?: throw NullPointerException("UID is null.") as Throwable}")

    //Set up id for current user if new
    fun initCurrentUserIfFirstTime(onComplete: ()-> Unit){
        currentUserDocRef.get().addOnSuccessListener{documentSnapshot ->
            if (!documentSnapshot.exists()){
                val newUser = User(FirebaseAuth.getInstance().currentUser?.displayName?:"",
                        "",
                        "",
                        null)


//                FirebaseAuth.getInstance().currentUser?.sendEmailVerification()
//                        ?.addOnCompleteListener{
//                            if(it.isSuccessful){
//?
//
//                                currentUserDocRef.set(newUser).addOnSuccessListener{
//                                    onComplete()
//                                }
//                            }




//                if(emailVerified == true){
//                    currentUserDocRef.set(newUser).addOnSuccessListener{
//                        onComplete()
//                    }
//                }

                currentUserDocRef.set(newUser).addOnSuccessListener{
                    onComplete()
                }
            }
            else
                onComplete()
        }
    }

    //Update method for values in firestore
    fun updateCurrentUser(name: String = "", healthCondition: String = "", profilePicturePath: String? = null){
        val userFieldMap = mutableMapOf<String,Any>()
        if (name.isNotBlank())
            userFieldMap["name"] = name
        getCurrentUser {
            health = it?.healthCondition
        }
        if (healthCondition.isNotBlank())
            userFieldMap["healthCondition"] = health!!
        if (profilePicturePath != null)
            userFieldMap["profilePicturePath"] = profilePicturePath

        currentUserDocRef.update(userFieldMap)
    }

    //Update method for values in firestore
    fun updateCurrentUserCondition(healthCondition: String = ""){
        val userFieldMap = mutableMapOf<String,Any>()

        getCurrentUser {
            health = it?.healthCondition
        }
        if (healthCondition.isNotBlank())
            userFieldMap["healthCondition"] = healthCondition + " " + health

        currentUserDocRef.update(userFieldMap)
    }

    //Update method for values in firestore
    fun deleteCurrentUserCondition(healthCondition: String = ""){
        val userFieldMap = mutableMapOf<String,Any>()

        getCurrentUser {
            health = it?.healthCondition
        }

        health = health?.replace(healthCondition,"")

        if (healthCondition.isNotBlank())
            userFieldMap["healthCondition"] = health!!

        currentUserDocRef.update(userFieldMap)
    }

    //Update method for values in firestore
    fun addCurrentUserMedicine(medicine: String = ""){
        val userFieldMap = mutableMapOf<String,Any>()

        getCurrentUser {
            med = it?.medicine
        }
        if (medicine.isNotBlank())
            userFieldMap["medicine"] = medicine + " " + med

        currentUserDocRef.update(userFieldMap)
    }

    //Update method for values in firestore
    fun deleteCurrentUserMedicine(medicine: String = ""){
        val userFieldMap = mutableMapOf<String,Any>()

        getCurrentUser {
            med = it?.medicine
        }

        med = med?.replace(medicine, "")

        if (medicine.isNotBlank())
            userFieldMap["medicine"] = med!!

        currentUserDocRef.update(userFieldMap)
    }


    //fix current user can be null problem
    fun getCurrentUser(onComplete: (User?) -> Unit){
        currentUserDocRef.get().addOnSuccessListener{
            onComplete(it.toObject(User::class.java))
        }

    }


}