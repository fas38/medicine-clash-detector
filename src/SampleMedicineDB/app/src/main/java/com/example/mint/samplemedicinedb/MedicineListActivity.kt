package com.example.mint.samplemedicinedb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mint.samplemedicinedb.model.MedicineDao
import com.example.mint.samplemedicinedb.model.MedicineDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_medicine_list.*

class MedicineListActivity : AppCompatActivity() {

    private var db: MedicineDatabase? = null
    private var medicineDao: MedicineDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicine_list)

        Observable.fromCallable({
            db = MedicineDatabase.getInstance(context = this)
            medicineDao = db?.medicineDao()
            db?.medicineDao()?.getMedicines()
        }).doOnNext({ list ->
            var finalString = ""
            list?.map { finalString+= it.brandName+" - "+ it.genericName +" - " + it.conditions +" ....... " }
            medicine_display.text = finalString

        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}
