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

        view.btnCompanySend.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.company_email));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Info");
            intent.putExtra(Intent.EXTRA_TEXT, "My opinion is...");
            startActivity(intent)
        }

        view.btnCompanyOpen.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, )
            intent.data = Uri.parse(getString(R.string.company_web))
            startActivity(intent)
        }



    }
}