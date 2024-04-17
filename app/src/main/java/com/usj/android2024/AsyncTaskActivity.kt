package com.usj.android2024

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usj.android2024.databinding.ActivityAsyncTaskBinding

class AsyncTaskActivity : AppCompatActivity() {
    private val view by lazy { ActivityAsyncTaskBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        val taskActivity = MyAsyncTask(view)
        taskActivity.execute()
     }
}

private class MyAsyncTask(val view : ActivityAsyncTaskBinding) : AsyncTask<Unit, Int, Unit>(){
    override fun doInBackground(vararg params: Unit?)  {
        for(i in 0..1000000000)
        {
            publishProgress(i)
            Thread.sleep(100)
        }

    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        view.numberLabel.text = values.toString()
    }
}