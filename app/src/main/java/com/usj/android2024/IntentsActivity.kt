package com.usj.android2024

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usj.android2024.databinding.ActivityIntentsBinding

class IntentsActivity : AppCompatActivity() {

    private val view by lazy { ActivityIntentsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        //create the objects and things after this
        view.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:636307924"))
            startActivity(intent)
        }
        view.btnLifecycle.setOnClickListener{
            val intent = Intent(this,LifecycleActivity::class.java)
            startActivity(intent)
        }
    }
}