package com.example.mint.mcdone.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mint.mcdone.R
import com.example.mint.mcdone.ShowMedicineListActivity
import com.example.mint.mcdone.util.FirestoreUtil
import com.example.mint.mcdone.util.GlideApp
import com.example.mint.mcdone.util.StorageUtil
import kotlinx.android.synthetic.main.fragment_user_home.*
import kotlinx.android.synthetic.main.nav_header_main.*


class UserHomeFragment : Fragment() {

    private var pictureJustChanged = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user_home, container, false)

//        view.apply {
//            button_show_medicine.setOnClickListener {
//                val intent = Intent(this@UserHomeFragment.context, ShowMedicineListActivity::class.java)
//                startActivity(intent)
//            }
//        }

        return view
    }

    override fun onStart() {
        super.onStart()
        FirestoreUtil.getCurrentUser { user ->
            if (this@UserHomeFragment.isVisible) {
                user_name.setText(user?.name)
                if (!pictureJustChanged && user?.profilePicturePath != null)
                    GlideApp.with(this)
                            .load(StorageUtil.pathToReference(user.profilePicturePath))
                            .placeholder(R.drawable.ic_mood_black_24dp)
                            .into(profile_picture)


            }
        }
    }

}
