package com.usj.android2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usj.android2024.databinding.ActivityBBinding
import com.usj.android2024.databinding.ActivityDBinding
const val key = "KEY"
const val CODE = 134
class ActivityD : AppCompatActivity() {

    private val view by lazy { ActivityDBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.btnSendText.setOnClickListener {
             intent.putExtra(key,view.inputTextD.text.toString())
            setResult(CODE,intent)
            finish()
        }
    }
}