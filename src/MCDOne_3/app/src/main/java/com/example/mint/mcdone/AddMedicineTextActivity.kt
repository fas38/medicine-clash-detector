package com.example.mint.mcdone

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.mint.mcdone.model.AddMedicine
import com.example.mint.mcdone.model.AddMedicineSingleton
import com.example.mint.mcdone.model.MedicineDatabase

import kotlinx.android.synthetic.main.activity_add_medicine_text.*
import kotlinx.android.synthetic.main.content_add_medicine_text.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/*
This Activity is responsible for adding medicine
to the local sqlite database. This activity deals
with adding medicine by typing or text.
*/

class AddMedicineTextActivity : AppCompatActivity() {

    private lateinit var prePopulatedDB: MedicineDatabase
    private lateinit var mDb: AddMedicineSingleton

    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medicine_text)
        setSupportActionBar(toolbar)

        // Initialize the room database
        prePopulatedDB = MedicineDatabase.getInstance(applicationContext)
        mDb = AddMedicineSingleton.getInstance(applicationContext)

        //Code for Add medicine button saving data
        button_add_medicine.setOnClickListener {
            // Initialize a new addMedicine
            val addMedicine = AddMedicine(id = null,
                    bName = add_medicine_input.text.toString()
            )

            doAsync {

                // Get the list from database
                val prePopulatedList = prePopulatedDB.medicineDao().getMedicines()

                for (medicine in prePopulatedList){
                    if(addMedicine.bName in medicine.brandName){

                        // Put the addMedicine in database
                        mDb.addMedicineDao().insert(addMedicine)
                        flag =true

                    }
                    if (flag){
                        break
                    }
                }



                uiThread {
                    if (flag){
                        flag = false
                        toast("Medicine Inserted in the List")
                    }
                    else{
                        toast("Invalid Input")
                    }
                }
            }

        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
