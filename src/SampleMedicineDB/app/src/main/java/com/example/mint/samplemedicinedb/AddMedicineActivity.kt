package com.example.mint.samplemedicinedb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mint.samplemedicinedb.model.UserMedicine
import com.example.mint.samplemedicinedb.model.UserMedicineDao
import com.example.mint.samplemedicinedb.model.UserMedicineDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_medicine.*

class AddMedicineActivity : AppCompatActivity() {

    private var db: UserMedicineDatabase? = null
    private var userMedicineDao: UserMedicineDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medicine)

        Observable.fromCallable({
            db = UserMedicineDatabase.getUserMedicineDatabase(context = this)
            userMedicineDao = db?.userMedicineDao()



            button_save.setOnClickListener{

                val medicine = editText_name.text.toString()
                val medicine1 = UserMedicine(brandName = medicine)
                with(userMedicineDao){
                    this?.insertMedicine(medicine1)
                }

            }
            db?.userMedicineDao()?.getMedicines()
        }).doOnNext({ list ->
            var finalString = ""
            list?.map { finalString+= it.brandName+" - " }
            tv_message.text = finalString

        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}
