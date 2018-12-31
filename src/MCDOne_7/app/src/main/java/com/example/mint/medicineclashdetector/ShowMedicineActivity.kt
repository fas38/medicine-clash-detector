package com.example.mint.medicineclashdetector

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.example.mint.medicineclashdetector.adapters.MedicineAdapter

import kotlinx.android.synthetic.main.activity_show_medicine.*
import com.google.firebase.firestore.FirebaseFirestore
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.mint.medicineclashdetector.model.MedicineFirebase
import com.firebase.ui.firestore.FirestoreRecyclerOptions





class ShowMedicineActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val medicineRef = db.collection("Medicine")

    private var adapter: MedicineAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_medicine)
        setSupportActionBar(toolbar)

        setUpRecyclerView()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setUpRecyclerView() {
        val query = medicineRef.orderBy("brandName")

        val options = FirestoreRecyclerOptions.Builder<MedicineFirebase>()
            .setQuery(query, MedicineFirebase::class.java)
            .build()

        adapter = MedicineAdapter(options)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setAdapter(adapter)
    }

    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter?.stopListening();
    }

}
