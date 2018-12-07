package com.example.mint.mcdone.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mint.mcdone.R
import com.example.mint.mcdone.RemoveMedicineActivity
import kotlinx.android.synthetic.main.fragment_remove_medicine.view.*


class RemoveMedicineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_remove_medicine, container, false)

        view.apply{
            button_remove_medicine.setOnClickListener {
                val intent = Intent(this@RemoveMedicineFragment.context, RemoveMedicineActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }


}
