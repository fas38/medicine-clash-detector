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

/**
This class is responsible for generating clash report
in a separate menu.
*/

class ShowClashReportActivity : AppCompatActivity() {

    //Initialize Variabbles
    private lateinit var userMedDB: AddMedicineSingleton
    private lateinit var prePopulatedDB: MedicineDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_clash_report)
        setSupportActionBar(toolbar)

        //Setting up database instances
        userMedDB = AddMedicineSingleton.getInstance(applicationContext)
        prePopulatedDB = MedicineDatabase.getInstance(applicationContext)

        // Make the text view scrollable
        textView_show_clash_report.movementMethod = ScrollingMovementMethod()

        button_clash_report_show.setOnClickListener{

            doAsync {
                // Get the list from database
                val userList = userMedDB.addMedicineDao().allAddMedicine()
                val prePopulatedList = prePopulatedDB.medicineDao().getMedicines()

                uiThread {
                    // Display in text view
                    textView_show_clash_report.text = ""
                    for (userMed in userList){
                        for (prePopMed in prePopulatedList){
                            if(userMed.bName in prePopMed.brandName){
                                for(userMed2 in userList){
                                    if(userMed.bName == userMed2.bName){
                                        continue
                                    }
                                    else{
                                        for(prePopMed2 in prePopulatedList){
                                            if(userMed2.bName in prePopMed2.brandName){
                                                var med = prePopMed2.genericName
                                                for(med in prePopMed.clashMed.split(",")){
                                                    var clashReport = textView_show_clash_report.text.toString().split("\n")
                                                    var flag = true
                                                    for(s in clashReport){
                                                        if(s.contains(userMed.bName,ignoreCase = true))
                                                            if(s.contains(userMed2.bName, ignoreCase = true))
                                                                flag = false
                                                    }
                                                    if(flag){
                                                        textView_show_clash_report.append(
                                                                "${userMed2.bName} will clash with ${userMed.bName}\n"
                                                        )
                                                    }

                                                }
                                            }
                                        }
                                    }

                                }
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
