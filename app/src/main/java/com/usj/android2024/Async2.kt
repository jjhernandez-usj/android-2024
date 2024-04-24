package com.usj.android2024

import android.os.AsyncTask
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.usj.android2024.databinding.ActivityAsync2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

data class Actor (val id: Int, val name: String)

class Async2 : AppCompatActivity() {

    private val view by lazy {
        ActivityAsync2Binding.inflate(layoutInflater)
    }

    private val scope = CoroutineScope(Dispatchers.IO)
    private lateinit var actors : Array<Actor>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        scope.launch {
            val url = URL("http://10.0.2.2:8080/actors")
            val urlConnection = url.openConnection() as HttpURLConnection
            try {
                var inputStream = BufferedInputStream(urlConnection.inputStream)
                val content = readStream(inputStream)
                actors = Gson().fromJson(content, Array<Actor>::class.java)
                runOnUiThread {
                    view.lvActors.adapter = ArrayAdapter(this@Async2, android.R.layout.simple_list_item_1, actors.map{ it.name })
                }
            } finally {
                urlConnection.disconnect()
            }
        }
        scope.launch {

        }
    }

    fun readStream(inputStream : InputStream) : String {
        val br = BufferedReader(InputStreamReader(inputStream))
        val total = StringBuilder()
        while (true) {
            val line = br.readLine() ?: break
            total.append(line).append('\n')
        }
        return total.toString()
    }
}
