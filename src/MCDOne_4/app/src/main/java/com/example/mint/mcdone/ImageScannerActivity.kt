package com.example.mint.mcdone

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer

import kotlinx.android.synthetic.main.activity_image_scanner.*


//This activity deals with adding medicine by image scanning


class ImageScannerActivity : AppCompatActivity() {

    //Initialize Variabbles
    private lateinit var svScanner: SurfaceView
    private  lateinit var tvText: TextView

    private lateinit var cameraSource: CameraSource
    private lateinit var textRecognizer: TextRecognizer

    private var mDelayHandler: Handler? = null
    private val delay: Long = 8000 //3 seconds
    var scannedText: String? = null

    //Set up the activity to end within the specified time in "delay"
    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext, ScannedTextActivity::class.java)
            intent.putExtra("scannedText", scannedText)
            startActivity(intent)
            finish()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_scanner)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Attach the variables with respective views
        svScanner = findViewById(R.id.sv_scanner)
        tvText = findViewById(R.id.tv_text)

        //Setting up textrecognizer
        textRecognizer = TextRecognizer.Builder(this).build()

        if(textRecognizer.isOperational){
            startScanner()

        }else{
            Log.w("Error","Text Recognizer is not working")
        }

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, delay)
    }

    private fun startScanner(){
        //Setting  up camera source
        cameraSource = CameraSource.Builder(this,textRecognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK).setRequestedFps(15.0f)
                .setRequestedPreviewSize(1024,768).setAutoFocusEnabled(true).build()

        //Setting up surface view
        svScanner.holder.addCallback(object: SurfaceHolder.Callback2 {
            override fun surfaceRedrawNeeded(holder: SurfaceHolder?) {}

            override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height:
            Int) {}

            override fun surfaceDestroyed(holder: SurfaceHolder?) {
                cameraSource.stop()
            }

            override fun surfaceCreated(holder: SurfaceHolder?) {
                if(ActivityCompat.checkSelfPermission(this@ImageScannerActivity, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED)
                    cameraSource.start(holder)
                else{
                    ActivityCompat.requestPermissions(this@ImageScannerActivity, arrayOf(Manifest
                            .permission.CAMERA), 123)
                }
            }

        })

        //Setting up detection process for textrecognizer
        textRecognizer.setProcessor(object: Detector.Processor<TextBlock> {
            override fun release() {}

            override fun receiveDetections(detections: Detector.Detections<TextBlock>?) {
                val textItems = detections?.detectedItems
                val builder = StringBuilder()

                for(i in 0..Math.min(textItems!!.size()-1,5)){
                    builder.append(textItems.valueAt(i).getValue())
                    builder.append("\n")
                }

                scannedText = builder.toString()


                tvText.post{
                    tvText.text = builder.toString()
                }

            }

        })
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==123 && grantResults.isNotEmpty()){
            cameraSource.start(svScanner.holder)
        }else{
            Toast.makeText(this, "Scanner won't work without permission",
                    Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        textRecognizer.release()
        cameraSource.stop()
        cameraSource.release()

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
    }

}
