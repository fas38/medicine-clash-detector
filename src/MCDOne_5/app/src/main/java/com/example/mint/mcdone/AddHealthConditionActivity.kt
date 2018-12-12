package com.example.mint.mcdone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.example.mint.mcdone.model.HealthCondition
import com.example.mint.mcdone.model.HealthConditionDatabase
import com.example.mint.mcdone.util.FirestoreUtil

import kotlinx.android.synthetic.main.activity_add_health_condition.*
import kotlinx.android.synthetic.main.content_add_health_condition.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class AddHealthConditionActivity : AppCompatActivity() {

    //Initialize Variables
    private lateinit var hDb: HealthConditionDatabase

    val conditions = listOf<String>("Cancer", "Kidney", "Heart", "Aids",
            "BP", "Diabetes", "Migrain", "Acidity", "Liver", "Lactation")

    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_health_condition)
        setSupportActionBar(toolbar)

        hDb = HealthConditionDatabase.getInstance(applicationContext)

        button_save_condition.setOnClickListener{

            // Initialize a new addMedicine
            val healthCondition = HealthCondition(id = null,
                    condition = editText_health_condition.text.toString()
            )

            doAsync {


                for (condition in conditions){
                    if(healthCondition.condition.toLowerCase() in condition.toLowerCase()){


                        hDb.healthConditionDao().insert(healthCondition)
                        FirestoreUtil.updateCurrentUserCondition(healthCondition.condition)
                        flag =true

                    }
                    if (flag){
                        break
                    }
                }



                uiThread {
                    if (flag){
                        flag = false
                        toast("Health Condition Inserted")
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
