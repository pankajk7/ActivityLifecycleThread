package com.pankaj.activitylifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Activity-Lifecycle", "onCreate")
        val manager = supportFragmentManager
        val fragment = manager.findFragmentByTag("fragment")
//        if (fragment == null) {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fl_container, FragmetThread.getInstance(), "fragment")
//        transaction.addToBackStack(null)
        transaction.commit()
//        }
    }

    public fun showSecondFragment() {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fl_container, Fragment2.getInstance(), "fragment2")
//        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity-Lifecycle", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity-Lifecycle", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity-Lifecycle", "onResume")
    }

    override fun onPause() {
        Log.d("Activity-Lifecycle", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Activity-Lifecycle", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("Activity-Lifecycle", "onDestroy")
        super.onDestroy()
    }
}
