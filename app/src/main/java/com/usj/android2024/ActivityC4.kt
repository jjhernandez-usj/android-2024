package com.usj.android2024

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usj.android2024.databinding.ActivityC4Binding
import com.usj.android2024.databinding.ActivityCBinding

class ActivityC4 : AppCompatActivity() {

    private val view by lazy { ActivityC4Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.btnCompanyCall.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: ${getString(R.string._666666)}"))
            startActivity(intent)

        }




    }
}