package com.usj.android2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val index = intent.getStringExtra("index")!!.toInt()
        val person = Persons.people[index]

        Toast.makeText(this, person.name, Toast.LENGTH_SHORT).show()
    }
}