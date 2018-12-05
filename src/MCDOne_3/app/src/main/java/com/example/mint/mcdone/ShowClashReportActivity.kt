package com.example.mint.mcdone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import com.example.mint.mcdone.model.AddMedicineSingleton
import com.example.mint.mcdone.model.MedicineDatabase
import com.example.mint.mcdone.model.addMedicineDao

import kotlinx.android.synthetic.main.activity_show_clash_report.*
import kotlinx.android.synthetic.main.content_show_clash_report.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ShowClashReportActivity : AppCompatActivity() {

    private lateinit var userMedDB: AddMedicineSingleton
    private lateinit var prePopulatedDB: MedicineDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_clash_report)
        setSupportActionBar(toolbar)

        userMedDB = AddMedicineSingleton.getInstance(applicationContext)
        prePopulatedDB = MedicineDatabase.getInstance(applicationContext)

        // Make the text view scrollable
        textView_show_clash_report.movementMethod = ScrollingMovementMethod()

        button_clash_report_show.setOnClickListener{
            doAsync {
                // Get the student list from database
                val userList = userMedDB.addMedicineDao().allAddMedicine()
                val prePopulatedList = prePopulatedDB.medicineDao().getMedicines()

                uiThread {
                    // Display the students in text view
                    textView_show_clash_report.text = ""
                    for (prePopMed in prePopulatedList){
                        for (userMed in userList){
                            if(userMed.bName in prePopMed.clashMed){
                                textView_show_clash_report.append("${userMed.bName} will clash with ${prePopMed.brandName}\n")
                            }
                            else {
                                continue
                            }
                        }
                    }

                }
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
