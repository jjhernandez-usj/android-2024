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


data class Person(val name: String, val gender: String)

object Persons {
    val people = mutableListOf<Person>()

    fun add(person: Person) {
        people.add(person);
    }

    init {
        people.add(Person("Juanjo", "Male"))
        people.add(Person("Juan", "Male"))
    }
}
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


        val listView = findViewById<ListView>(R.id.lvCountries)
        val customAdapter = CustomPersonAdapter(this)
        listView.adapter = customAdapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailActivity::class.java).apply {

                putExtra("index",position)
            }
            startActivity(intent)
        }

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

class CustomPersonAdapter(private val context: Context) : BaseAdapter() {
    override fun getCount(): Int = Persons.people.size

    override fun getItem(position: Int): Any = Persons.people[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = convertView ?: inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        val person = getItem(position) as Person
        (view.findViewById(android.R.id.text1) as TextView).text = person.name
        return view
    }
}

