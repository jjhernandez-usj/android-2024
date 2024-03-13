package com.usj.android2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.usj.android2024.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private val view by lazy { ActivityBBinding.inflate(layoutInflater) }

    private val contract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val text = it.data?.getStringExtra(key)?: "No Text"
        view.tvResult.text = text
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnBToA.setOnClickListener {
            val intent = Intent(this,ActivityA::class.java)
            startActivity(intent)
        }
        view.btnBToD.setOnClickListener {
            val intent = Intent(this,ActivityD::class.java)
            //startActivityForResult(intent, CODE)
            contract.launch(intent)
        }

    }

    fun submit(view: View) {
        val intent = Intent(this,ActivityD::class.java)
        //startActivityForResult(intent, CODE)
        contract.launch(intent)
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val text = data?.getStringExtra(key)?: "No Text"
        view.tvResult.text = text

    }*/
}