package com.pankaj.activitylifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Activity2-Lifecycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity2-Lifecycle", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity2-Lifecycle", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity2-Lifecycle", "onResume")
    }

    override fun onPause() {
        Log.d("Activity2-Lifecycle", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Activity2-Lifecycle", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("Activity2-Lifecycle", "onDestroy")
        super.onDestroy()
    }
}