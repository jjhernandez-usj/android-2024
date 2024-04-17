package com.usj.android2024

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class Async2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async2)

        MyAsyncTask().execute()
    }
}

class MyAsyncTask :  AsyncTask<String, Unit, String>() {
    override fun doInBackground(vararg params: String?): String {
        val url = URL(params[0])
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            var inputStream = BufferedInputStream(urlConnection.getInputStream())
            readStream(inputStream)
            return inputStream.toString()
        } finally {
            urlConnection.disconnect()
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