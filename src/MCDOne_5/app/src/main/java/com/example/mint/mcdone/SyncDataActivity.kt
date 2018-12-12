package com.example.mint.mcdone

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.mint.mcdone.model.AddMedicine
import com.example.mint.mcdone.model.AddMedicineSingleton
import com.example.mint.mcdone.model.HealthCondition
import com.example.mint.mcdone.model.HealthConditionDatabase
import com.example.mint.mcdone.util.FirestoreUtil

import kotlinx.android.synthetic.main.activity_sync_data.*
import kotlinx.android.synthetic.main.content_sync_data.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class SyncDataActivity : AppCompatActivity() {

    //Initialize Variables
    private lateinit var hDb: HealthConditionDatabase
    private lateinit var mDb: AddMedicineSingleton
    var health = ""
    var med= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sync_data)
        setSupportActionBar(toolbar)

        hDb = HealthConditionDatabase.getInstance(applicationContext)
        mDb = AddMedicineSingleton.getInstance(applicationContext)

        FirestoreUtil.getCurrentUser {
            health = it!!.healthCondition
        }

        FirestoreUtil.getCurrentUser {
            med = it!!.medicine
        }


        button_sync_condition.setOnClickListener{



            doAsync {


                for (condition in health.split(" ")){

                    // Initialize a new condition
                    val healthCondition = HealthCondition(id = null,
                            condition = condition
                    )

                    if(condition == "" || condition == " ")
                        continue
                    else
                        hDb.healthConditionDao().insert(healthCondition)


                    }

                uiThread{
                    toast(health)
                }

            }


        }

        button_sync_medicine.setOnClickListener {
            doAsync {


                for (medicine in med.split(" ")){

                    // Initialize a new addMedicine
                    val addMedicine = AddMedicine(id = null,
                            bName = medicine
                    )

                    if(medicine == "" || medicine == " ")
                        continue
                    else
                        mDb.addMedicineDao().insert(addMedicine)


                }

                uiThread{
                    toast(med)
                }

            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
