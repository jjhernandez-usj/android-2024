package com.usj.android2024

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
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


class Item(val name: String, val surname: String){}
class CustomAdapter (val context: Context, val items: MutableList<Item>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Item {
       return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = getItem(position)
        val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.item_layout,null)
        view.findViewById<TextView>(R.id.tv1).text = item.name
        view.findViewById<TextView>(R.id.tv2).text = item.surname
        return view
    }

}


