package com.example.mint.mcdone

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.mint.mcdone.model.AddMedicine
import com.example.mint.mcdone.model.AddMedicineSingleton
import com.example.mint.mcdone.util.FirestoreUtil

import kotlinx.android.synthetic.main.activity_remove_medicine.*
import kotlinx.android.synthetic.main.content_remove_medicine.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

//This is the activity responsible for removing a medicine from the database

class RemoveMedicineActivity : AppCompatActivity() {

    //Initialize Variabbles
    private lateinit var mDb: AddMedicineSingleton

    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove_medicine)
        setSupportActionBar(toolbar)

        // Initialize the room database
        mDb = AddMedicineSingleton.getInstance(applicationContext)

        button_remove_medicine_text.setOnClickListener {


            doAsync {
                // Get the list from database
                val userMedicineList = mDb.addMedicineDao().allAddMedicine()
                val input = remove_medicine_input.text.toString()

                for (medicine in userMedicineList){
                    if(input in medicine.bName){

                        // Remove the user medicine from database
                        mDb.addMedicineDao().delete(medicine)

                        //Remove user medicine from firestore
                        FirestoreUtil.deleteCurrentUserMedicine(medicine.bName)

                        flag =true

                    }
                    if (flag){
                        break
                    }
                }



                uiThread {
                    if (flag){
                        flag = false
                        toast("Medicine Removed")
                    }
                    else{
                        toast("Medicine Not In The List")
                    }
                }
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
