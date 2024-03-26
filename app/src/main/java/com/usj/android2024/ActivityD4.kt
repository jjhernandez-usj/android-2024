package com.usj.android2024

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.usj.android2024.databinding.ActivityD4Binding

class ActivityD4 : AppCompatActivity() {

    private val view by lazy { ActivityD4Binding.inflate(layoutInflater) }
    private val weightP1 = 15;
    private val weightP2 = 24;
    private val weightP3 = 30;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        //Retrieve the client name from B4
        val intent = intent
        view.tvName.text = intent.getStringExtra(NAME_ID)

        val checkBoxListener = CompoundButton.OnCheckedChangeListener { _, _ -> calculateWeight()}
        view.cbProduct1.setOnCheckedChangeListener(checkBoxListener)
        view.cbProduct2.setOnCheckedChangeListener(checkBoxListener)
        view.cbProduct3.setOnCheckedChangeListener(checkBoxListener)

        calculateWeight() //Init the process

    }

    private fun calculateWeight() {

        var total = 0;

        if(view.cbProduct1.isChecked) total += this.weightP1
        if(view.cbProduct2.isChecked) total += this.weightP2
        if(view.cbProduct3.isChecked) total += this.weightP3

        view.tvTotalValue.text = total.toString()

    }
}