package com.example.mint.mcdone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scanned_text.*


class ScannedTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanned_text)

        val scannedText  = intent.getStringExtra("scannedText")

        scannedTextView.setText(scannedText)


    }
}
