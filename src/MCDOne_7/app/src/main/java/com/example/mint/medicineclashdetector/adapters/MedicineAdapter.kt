package com.example.mint.medicineclashdetector.adapters

import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.example.mint.medicineclashdetector.R
import com.example.mint.medicineclashdetector.model.MedicineFirebase
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import kotlinx.android.synthetic.main.medicine_item.view.*


class MedicineAdapter(options: FirestoreRecyclerOptions<MedicineFirebase>) :
    FirestoreRecyclerAdapter<MedicineFirebase, MedicineAdapter.MedicineHolder>(options) {

    override fun onBindViewHolder(holder: MedicineHolder, position: Int, model: MedicineFirebase) {
        holder.textViewBrandName.setText(model.brandName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.medicine_item,
            parent, false
        )
        return MedicineHolder(v)
    }

    inner class MedicineHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewBrandName: TextView

        init {
            textViewBrandName = itemView.medicine_list_view

        }
    }
}


