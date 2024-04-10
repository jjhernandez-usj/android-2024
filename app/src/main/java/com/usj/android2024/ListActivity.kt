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

        //val people = mutableListOf(Item("Juanjo", "Hernández"))
        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        //val customAdapter = CustomAdapter(this, people)
        //view.lvCountries.adapter = customAdapter

        /*view.lvCountries.setOnItemClickListener { _, _, position, _ ->
            val country = countries[position]
            Toast.makeText(this, country, LENGTH_SHORT).show()
            adapter.remove(country)
        }

        view.btnAddCountry.setOnClickListener {
            adapter.add(view.etNewCountry.text.toString())
        }*/

    }
}


class Item(val name: String, val surname: String) {

}

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

