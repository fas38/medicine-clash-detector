package com.example.mint.mcdone.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mint.mcdone.AddHealthConditionActivity
import com.example.mint.mcdone.AddMedicineTextActivity
import com.example.mint.mcdone.ImageScannerActivity

import com.example.mint.mcdone.R
import kotlinx.android.synthetic.main.fragment_add_medicine.view.*

//Fragment for adding medicine

class AddMedicineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_medicine, container, false)

        view.apply{
            button_add_medicine_image.setOnClickListener {
                val intent = Intent(this@AddMedicineFragment.context, ImageScannerActivity::class.java)
                startActivity(intent)
            }

            button_add_medicine_text.setOnClickListener {
                val intent = Intent(this@AddMedicineFragment.context, AddMedicineTextActivity::class.java)
                startActivity(intent)
            }

            button_add_health_condition.setOnClickListener {
                val intent = Intent(this@AddMedicineFragment.context, AddHealthConditionActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }


}
