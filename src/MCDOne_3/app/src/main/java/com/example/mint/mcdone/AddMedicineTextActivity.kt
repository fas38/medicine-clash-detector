package com.example.mint.mcdone

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.mint.mcdone.model.AddMedicine
import com.example.mint.mcdone.model.AddMedicineSingleton

import kotlinx.android.synthetic.main.activity_add_medicine_text.*
import kotlinx.android.synthetic.main.content_add_medicine_text.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class AddMedicineTextActivity : AppCompatActivity() {

    private lateinit var mDb: AddMedicineSingleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medicine_text)
        setSupportActionBar(toolbar)

        // Initialize the room database
        mDb = AddMedicineSingleton.getInstance(applicationContext)

        button_add_medicine.setOnClickListener {
            // Initialize a new addMedicine
            val addMedicine = AddMedicine(id = null,
                    bName = add_medicine_input.text.toString()
            )

            doAsync {
                // Put the addMedicine in database
                mDb.addMedicineDao().insert(addMedicine)

                uiThread {
                    toast("One record inserted.")
                }
            }

        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
