package com.usj.android2024

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usj.android2024.databinding.ActivityBBinding
import com.usj.android2024.databinding.ActivityCBinding

class ActivityC : AppCompatActivity() {

    private val view by lazy { ActivityCBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.btnCtoA.setOnClickListener {
            val intent = Intent(this,ActivityA::class.java)
            startActivity(intent)
        }
        view.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:112"))
            startActivity(intent)
        }
        view.btnSend.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:112"))
            startActivity(intent)
        }
    }
}