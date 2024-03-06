package com.usj.android2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usj.android2024.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private val view by lazy { ActivityBBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.btnBToA.setOnClickListener {
            val intent = Intent(this,ActivityA::class.java)
            startActivity(intent)
        }
        view.btnBToD.setOnClickListener {
            val intent = Intent(this,ActivityD::class.java)
            startActivityForResult(intent, CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val text = data?.getStringExtra(key)?: "No Text"
        view.tvResult.text = text

    }
}