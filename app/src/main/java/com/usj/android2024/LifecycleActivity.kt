package com.usj.android2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class LifecycleActivity : AppCompatActivity() {

    private fun log(methodName: String) {
        Toast.makeText(this, methodName, Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        log("onCreate")
    }

    override fun onStart() {
        super.onStart()
        log("onStart")
    }

    override fun onStop() {
        super.onStop()
        log("onStop")
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    override fun onRestart() {
        super.onRestart()
        log("onRestart")
    }

    override fun onPause() {
        super.onPause()
        log("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
    }
}