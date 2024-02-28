package com.usj.android2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usj.android2024.databinding.ActivityABinding
import com.usj.android2024.databinding.ActivityIntentsBinding

class ActivityA : AppCompatActivity() {
    private val view by lazy { ActivityABinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.btnAtoB.setOnClickListener{}
        view.btnAtoC.setOnClickListener{}
    }
}