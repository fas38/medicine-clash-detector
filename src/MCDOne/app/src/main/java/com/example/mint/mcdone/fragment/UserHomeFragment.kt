package com.example.mint.mcdone.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mint.mcdone.R
import com.example.mint.mcdone.util.FirestoreUtil
<<<<<<< HEAD
import kotlinx.android.synthetic.main.fragment_user_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
=======
import com.example.mint.mcdone.util.GlideApp
import com.example.mint.mcdone.util.StorageUtil
import kotlinx.android.synthetic.main.fragment_user_home.*
import kotlinx.android.synthetic.main.nav_header_main.*
>>>>>>> remotes/origin/scratch


class UserHomeFragment : Fragment() {

<<<<<<< HEAD
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_home, container, false)
=======
    private var pictureJustChanged = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user_home, container, false)



        return view
>>>>>>> remotes/origin/scratch
    }

    override fun onStart() {
        super.onStart()
        FirestoreUtil.getCurrentUser { user ->
            if (this@UserHomeFragment.isVisible) {
                user_name.setText(user?.name)
<<<<<<< HEAD
=======
                if (!pictureJustChanged && user?.profilePicturePath != null)
                    GlideApp.with(this)
                            .load(StorageUtil.pathToReference(user.profilePicturePath))
                            .placeholder(R.drawable.ic_mood_black_24dp)
                            .into(profile_picture)

>>>>>>> remotes/origin/scratch

            }
        }
    }

}
