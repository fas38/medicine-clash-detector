package com.example.mint.samplemedicinedb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mint.samplemedicinedb.model.Medicine
import com.example.mint.samplemedicinedb.model.MedicineDao
import com.example.mint.samplemedicinedb.model.MedicineDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var db: MedicineDatabase? = null
    private var medicineDao: MedicineDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        db = MedicineDatabase.getInstance(context = this)
//        medicineDao = db?.medicineDao()

//        val list = db?.medicineDao()?.getMedicines()
//        var finalString = ""
//        list?.map { finalString+= it.brandName+" - "+ it.genericName +" - " + it.conditions +" ....... " }
//        list?.map { finalString+= it.brandName+" - " }
//        tv_text.text = finalString

        button.setOnClickListener{

            val intent = Intent(this@MainActivity, MedicineListActivity::class.java)
            startActivity(intent)

        }

//        button_add_medicine_text.setOnClickListener {
//            val intent = Intent(this@MainActivity, AddMedicineActivity::class.java)
//            startActivity(intent)
//        }
    }
}


//class MainActivity : AppCompatActivity() {
//
//    private var db: MedicineDatabase? = null
//    private var medicineDao: MedicineDao? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        Observable.fromCallable({
//            db = MedicineDatabase.getInstance(context = this)
//            medicineDao = db?.medicineDao()
//            db?.medicineDao()?.getMedicines()
//        }).doOnNext({ list ->
//            var finalString = ""
//            list?.map { finalString+= it.brandName+" - " }
//            tv_text.text = finalString
//
//        }).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe()
//    }
//}

