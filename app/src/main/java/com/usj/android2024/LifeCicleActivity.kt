package com.usj.android2024

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.usj.android2024.databinding.ActivityLifeCicleBinding
import com.usj.android2024.databinding.ActivityMainBinding

class LifeCicleActivity : AppCompatActivity() {

    private val view by lazy { ActivityLifeCicleBinding.inflate(layoutInflater) }
    private fun log(methodName: String){
        Toast.makeText(this, methodName, Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        //create the objects and things after this
        view.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:636307924"))


            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy");

    }

    override fun onStop() {
        super.onStop()
        log("onStop");
    }

    override fun onStart() {
        super.onStart()
        log("onStart");
    }

    override fun onRestart() {
        super.onRestart()
        log("onRestart");
    }

    override fun onResume() {
        super.onResume()
        log("onResume");
    }

    override fun onPause() {
        super.onPause()
        log("onPause");
    }
}