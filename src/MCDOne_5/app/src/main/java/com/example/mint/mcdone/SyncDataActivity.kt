package com.example.mint.mcdone

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
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
    var value = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sync_data)
        setSupportActionBar(toolbar)

        hDb = HealthConditionDatabase.getInstance(applicationContext)

        FirestoreUtil.getCurrentUser {
            value = it!!.healthCondition
        }


        button_sync_condition.setOnClickListener{



            doAsync {


                for (condition in value.split(" ")){

                    // Initialize a new addMedicine
                    val healthCondition = HealthCondition(id = null,
                            condition = condition
                    )

                    if(condition != "" || condition != " ")
                        hDb.healthConditionDao().insert(healthCondition)
                    else
                        continue

                    }

                uiThread{
                    toast(value)
                }

            }


        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
