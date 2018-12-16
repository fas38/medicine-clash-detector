package com.example.mint.mcdone.fragment


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mint.mcdone.MainActivity

import com.example.mint.mcdone.R
import com.example.mint.mcdone.util.FirestoreUtil
import com.example.mint.mcdone.util.GlideApp
import com.example.mint.mcdone.util.StorageUtil
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_edit_profile.view.*
import kotlinx.android.synthetic.main.nav_header_main.*
import org.jetbrains.anko.support.v4.toast
import java.io.ByteArrayOutputStream

//Fragment for editing profile

class EditProfileFragment : Fragment() {

    //Initialize Variables
    private val RC_SELECT_IMAGE = 2
    private lateinit var selectedImageBytes: ByteArray
    private var pictureJustChanged = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)

        view.apply{
            //Setting up edit button for profile picture
            profile_picture_edit.setOnClickListener{

                val  intent = Intent().apply{
                    type = "image/*"
                    action = Intent.ACTION_GET_CONTENT
                    putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
                }
                startActivityForResult(Intent.createChooser(intent, "Select Image"), RC_SELECT_IMAGE)
            }

            //Setting up save button
            button_save_edit_profile.setOnClickListener {
                if (::selectedImageBytes.isInitialized)
                    StorageUtil.uploadProfilePhoto(selectedImageBytes) { imagePath ->
                        FirestoreUtil.updateCurrentUser(editText_name.text.toString(),
                                "",imagePath)
                    }
                else
                    FirestoreUtil.updateCurrentUser(editText_name.text.toString(),
                            "", null)
                toast("Saving")
                (activity as MainActivity).setNavbarUsername()
            }
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SELECT_IMAGE && resultCode == Activity.RESULT_OK &&
                data != null && data.data != null) {
            val selectedImagePath = data.data
            val selectedImageBmp = MediaStore.Images.Media
                    .getBitmap(activity?.contentResolver, selectedImagePath)

            val outputStream = ByteArrayOutputStream()
            selectedImageBmp.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            selectedImageBytes = outputStream.toByteArray()

            //Setting up glide app to hadnle profile picture
            GlideApp.with(this)
                    .load(selectedImageBytes)
                    .into(profile_picture_edit)

            pictureJustChanged = true
        }
    }

    override fun onStart() {
        super.onStart()
        FirestoreUtil.getCurrentUser { user -> //Set user information from firestore
            if (this@EditProfileFragment.isVisible) {
                editText_name.setText(user?.name)
                if (!pictureJustChanged && user?.profilePicturePath != null)
                    GlideApp.with(this)
                            .load(StorageUtil.pathToReference(user.profilePicturePath))
                            .placeholder(R.drawable.ic_mood_black_24dp)
                            .into(profile_picture_edit)


            }
        }
    }


}
