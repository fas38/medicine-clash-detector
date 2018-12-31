package com.example.mint.mcdone

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod
import com.example.mint.mcdone.model.AddMedicineSingleton

import kotlinx.android.synthetic.main.activity_show_medicine_list.*
import kotlinx.android.synthetic.main.content_show_medicine_list.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ShowMedicineListActivity : AppCompatActivity() {

    private lateinit var mDb: AddMedicineSingleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_medicine_list)
        setSupportActionBar(toolbar)

        // Initialize the room database
        mDb = AddMedicineSingleton.getInstance(applicationContext)

        // Make the text view scrollable
        textView.movementMethod = ScrollingMovementMethod()

        button_medicine_show.setOnClickListener{
            doAsync {
                // Get the student list from database
                val list = mDb.addMedicineDao().allAddMedicine()

                uiThread {
                    // Display the students in text view
                    textView.text = ""
                    for (medicine in list){
                            textView.append("${medicine.id} : ${medicine.bName}\n")

                    }

                }
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}