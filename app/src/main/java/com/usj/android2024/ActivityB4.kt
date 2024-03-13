package com.usj.android2024

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.usj.android2024.databinding.ActivityB4Binding

class ActivityB4 : AppCompatActivity() {
    private val view by lazy { ActivityB4Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.rgSelector.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.rbCitizen -> {
                    view.layoutCitizen.visibility = View.VISIBLE
                    view.layoutCompany.visibility = View.INVISIBLE
                }
                R.id.rbCompany -> {
                    view.layoutCitizen.visibility = View.INVISIBLE
                    view.layoutCompany.visibility = View.VISIBLE
                }
            }
        }

    }
}