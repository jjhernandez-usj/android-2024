package com.usj.android2024

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.usj.android2024.databinding.ActivityD4Binding


class ActivityD4 : AppCompatActivity() {
    private val view by lazy { ActivityD4Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        // Take cityzen and put it in et
        val citizen = intent.getStringExtra("cityzen")
        view.etNameClient.setText(citizen)

        var sum = 0

        fun updateWeight(productWeight: Int, isChecked: Boolean) {
            if(isChecked){
                sum += productWeight
            } else {
                sum -= productWeight
                if(sum <= 0){
                    sum = 0
                }
            }
            if (sum < 0) sum = 0
            view.etKg.setText(sum.toString())
        }

        view.cbProduct1.setOnCheckedChangeListener { _, isChecked ->
            updateWeight(32, isChecked) // 32 KG
        }

        view.cbProduct2.setOnCheckedChangeListener { _, isChecked ->
            updateWeight(24, isChecked) // 24 KG
        }

        view.cbProduct3.setOnCheckedChangeListener { _, isChecked ->
            updateWeight(47, isChecked) // 47 KG
        }

    }
}