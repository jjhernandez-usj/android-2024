package com.usj.android2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usj.android2024.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private val view by lazy { ActivityBBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        view.btnBToA.setOnClickListener {
            val intent = Intent(this,ActivityA::class.java)
            startActivity(intent)
        }
        view.btnBToD.setOnClickListener {  }

    }
}