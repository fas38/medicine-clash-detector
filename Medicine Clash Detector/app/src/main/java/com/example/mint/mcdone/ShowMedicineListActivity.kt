package com.example.mint.mcdone

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod
import com.example.mint.mcdone.model.AddMedicineSingleton
import com.example.mint.mcdone.model.HealthConditionDatabase

import kotlinx.android.synthetic.main.activity_show_medicine_list.*
import kotlinx.android.synthetic.main.content_show_medicine_list.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 This class is responsible for showing the list
 of medicines added by the user in a separate view.
 */

class ShowMedicineListActivity : AppCompatActivity() {

    //Initialize Variabbles
    private lateinit var mDb: AddMedicineSingleton
    private lateinit var hDb: HealthConditionDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_medicine_list)
        setSupportActionBar(toolbar)

        // Initialize the room database
        mDb = AddMedicineSingleton.getInstance(applicationContext)
        hDb = HealthConditionDatabase.getInstance(applicationContext)

        // Make the text view scrollable
        textView.movementMethod = ScrollingMovementMethod()

        button_medicine_show.setOnClickListener{
            doAsync {
                // Get the user medicine list from database
                val list = mDb.addMedicineDao().allAddMedicine()

                uiThread {
                    // Display the user medicines in text view
                    textView.text = ""
                    for (medicine in list){
//                            textView.append("${medicine.id} : ${medicine.bName}\n")
                        textView.append("${medicine.bName}\n")

                    }

                }
            }
        }

        button_condition_show.setOnClickListener{
            doAsync {

                val list = hDb.healthConditionDao().allconditions()

                uiThread {
                    // Display the user medicines in text view
                    textView.text = ""
                    for (hcondition in list){
//                        textView.append("${hcondition.id} : ${hcondition.condition}\n")
                        textView.append("${hcondition.condition}\n")

                    }

                }
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
