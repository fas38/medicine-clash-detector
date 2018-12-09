package com.example.mint.mcdone.util

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

object StorageUtil {

    //Initialize Variabbles
    private val storageInstance: FirebaseStorage by lazy { FirebaseStorage.getInstance() }

    //Get documenet reference for current user
    private val currentUserRef: StorageReference
        get() = storageInstance.reference
                .child(FirebaseAuth.getInstance().currentUser?.uid
                        ?: throw NullPointerException("UID is null."))

    //Method to  handle image upload to firestore
    fun uploadProfilePhoto(imageBytes: ByteArray,
                           onSuccess: (imagePath: String) -> Unit) {
        val ref = currentUserRef.child("profilePictures/${UUID.nameUUIDFromBytes(imageBytes)}")
        ref.putBytes(imageBytes)
                .addOnSuccessListener {
                    onSuccess(ref.path)
                }
    }

    //Method to return path to image upload in firestore
    fun pathToReference(path: String) = storageInstance.getReference(path)


}