package com.usj.android2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usj.android2024.databinding.ActivityA4Binding
import com.usj.android2024.databinding.ActivityABinding

class ActivityA4 : AppCompatActivity() {
    private val view by lazy { ActivityA4Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.login.setOnClickListener {
            if (!isEmpty() && login() ){
                val intent = Intent (this,ActivityB4::class.java)
                startActivity(intent)
            }
        }
    }
    fun isEmpty()  : Boolean{
        return view.User.text.isEmpty() ||
        view.Password.text.isEmpty()
    }
    fun login() : Boolean {
        return view.User.text.toString() == view.Password.text.toString()
    }
}