package com.example.mint.mcdone.util

import com.example.mint.mcdone.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

object FirestoreUtil {
    private val firestoreInstance: FirebaseFirestore by lazy {FirebaseFirestore.getInstance()}

    private val currentUserDocRef: DocumentReference
        get() = firestoreInstance.document("user/${FirebaseAuth.getInstance().uid
                ?: throw NullPointerException("UID is null.")}")

    fun initCurrentUserIfFirstTime(onComplete: ()-> Unit){
        currentUserDocRef.get().addOnSuccessListener{documentSnapshot ->
            if (!documentSnapshot.exists()){
                val newUser = User(FirebaseAuth.getInstance().currentUser?.displayName?:"",
                        "",
                        null)
                currentUserDocRef.set(newUser).addOnSuccessListener{
                    onComplete()
                }
            }
            else
                onComplete()
        }
    }

    fun updateCurrentUser(name: String = "", healthCondition: String = "", profilePicturePath: String? = null){
        val userFieldMap = mutableMapOf<String,Any>()
        if (name.isNotBlank())
            userFieldMap["name"] = name
        if (healthCondition.isNotBlank())
            userFieldMap["healthCondition"] = healthCondition
        if (profilePicturePath != null)
            userFieldMap["profilePicturePath"] = profilePicturePath

        currentUserDocRef.update(userFieldMap)
    }


    //fix current user can be null problem
    fun getCurrentUser(onComplete: (User?) -> Unit){
        currentUserDocRef.get().addOnSuccessListener{
            onComplete(it.toObject(User::class.java))
        }

    }


}