package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.io.File
import java.io.FileInputStream

import java.io.IOException


class DataActivity : AppCompatActivity() {
    private val FILE_NAME = "data.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val fileWorker = FileWorker()

        val textView : TextView = findViewById(R.id.textView) as TextView

        textView.setText(fileWorker.getText(this))

    }
}
