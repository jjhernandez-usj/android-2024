package com.usj.android2024

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.usj.android2024.databinding.ActivityB4Binding

const val COMPANY_ID = "123" // Key

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

        view.btnInitCompany.setOnClickListener {
            if(checkCompanyID()){
                val intent = Intent(this, ActivityC4::class.java)
                intent.putExtra(COMPANY_ID, view.etCompanyId.text.toString())
                startActivity(intent)
            }
        }

        view.btnInitCitizen.setOnClickListener {
            val intent = Intent(this, ActivityD4::class.java)
            intent.putExtra("CITIZEN", view.etCitizenName.text.toString())
            startActivity(intent)
        }

    }

    fun checkCompanyID() : Boolean{
        return view.etCompanyId.text.isNotEmpty()
    }

}