package com.usj.android2024

import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.usj.android2024.databinding.ActivityD4Binding

class ActivityD4 : AppCompatActivity() {

    private val view by lazy { ActivityD4Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        // Retrieve the client name from ActivityB4
        val clientName = intent.getStringExtra("CLIENT_NAME") ?: "Unknown"
        view.tvNameOfClient.text = clientName

        // Set listeners for all product checkboxes
        val checkBoxListener = CompoundButton.OnCheckedChangeListener { _, _ -> calculateWeight() }
        view.cbProductOne.setOnCheckedChangeListener(checkBoxListener)
        view.cbProductTwo.setOnCheckedChangeListener(checkBoxListener)
        view.cbProductThree.setOnCheckedChangeListener(checkBoxListener)

        // Initial weight calculation
        calculateWeight()
    }

    private fun calculateWeight() {
        var totalWeight = 0

        if (view.cbProductOne.isChecked) totalWeight += getWeightForProduct1()
        if (view.cbProductTwo.isChecked) totalWeight += getWeightForProduct2()
        if (view.cbProductThree.isChecked) totalWeight += getWeightForProduct3()

        view.tvWeightValue.text = totalWeight.toString()
    }

    private fun getWeightForProduct1(): Int {
        return 10 // Example weight for Product 1
    }

    private fun getWeightForProduct2(): Int {
        return 20 // Example weight for Product 2
    }

    private fun getWeightForProduct3(): Int {
        return 30 // Example weight for Product 3
    }
}