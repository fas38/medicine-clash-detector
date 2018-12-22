package com.example.mint.mcdone

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.mint.mcdone.model.HealthConditionDatabase
import com.example.mint.mcdone.util.FirestoreUtil

import kotlinx.android.synthetic.main.activity_remove_condition.*
import kotlinx.android.synthetic.main.content_remove_condition.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class RemoveConditionActivity : AppCompatActivity() {

    //Initialize Variables
    private lateinit var hDb: HealthConditionDatabase

    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove_condition)
        setSupportActionBar(toolbar)

        // Initialize the room database
        hDb = HealthConditionDatabase.getInstance(applicationContext)


        button_remove_condition_text.setOnClickListener {

            doAsync {
                // Get the list from database
                val userConditionList = hDb.healthConditionDao().allconditions()
                val input = remove_condition_input.text.toString()

                for (condition in userConditionList){
                    if(input == condition.condition){

                        // Remove the user condition from database
                        hDb.healthConditionDao().delete(condition)

                        //Remove condition from firebase
                        FirestoreUtil.deleteCurrentUserCondition(condition.condition)

                        flag =true

                    }
                    if (flag){
                        break
                    }
                }



                uiThread {
                    if (flag){
                        flag = false
                        toast("Condition Removed")
                    }
                    else{
                        toast("Condition Not In The List")
                    }
                }
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
