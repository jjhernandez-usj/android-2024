package com.usj.android2024

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.usj.android2024.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    data class Person(val name: String, val gender: String)

    object Persons {
        val people = mutableListOf<Person>()

        fun add(person: Person) {
            people.add(person);
        }

        init {
            people.add(Person("Juanjo", "Male"))
            people.add(Person("Juanjo", "Male"))
        }
    }


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


        val listView = findViewById<ListView>(R.id.lvCountries)
        val customAdapter = CustomPersonAdapter(this, Persons.people)
        listView.adapter = customAdapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                // We give the name and the gender as an example
                putExtra("name", Persons.people[position].name)
                putExtra("gender", Persons.people[position].gender)
            }
            startActivity(intent)
        }

    }
}

class CustomPersonAdapter(private val context: Context, private val people: List<ListActivity.Person>) : BaseAdapter() {
    override fun getCount(): Int = people.size

    override fun getItem(position: Int): Any = people[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = convertView ?: inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        val person = getItem(position) as ListActivity.Person
        (view.findViewById(android.R.id.text1) as TextView).text = person.name
        return view
    }
}

