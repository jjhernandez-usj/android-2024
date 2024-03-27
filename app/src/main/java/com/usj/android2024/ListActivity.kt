package com.usj.android2024

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.usj.android2024.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private val view by lazy {
        ActivityListBinding.inflate(layoutInflater)
    }
    private val countries = mutableListOf("Spain", "Turkey", "Portugal", "France")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        view.lvCountries.adapter = adapter

        view.lvCountries.setOnItemClickListener { _, _, position, _ ->
            val country = countries[position]
            Toast.makeText(this, country, LENGTH_SHORT).show()
            adapter.remove(country)
        }

        view.btnAddCountry.setOnClickListener {
            adapter.add(view.etNewCountry.text.toString())
        }

    }
}