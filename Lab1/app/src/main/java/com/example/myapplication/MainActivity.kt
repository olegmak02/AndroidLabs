package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var button_ok : Button
    private lateinit var button_cancel : Button
    private lateinit var spinner : Spinner
    private lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_ok = findViewById(R.id.ok)
        button_cancel = findViewById(R.id.cancel)
        spinner = findViewById(R.id.spinner)
        text = findViewById(R.id.output)

        button_cancel.setOnClickListener {view ->
            text.setText("")
        }

        button_ok.setOnClickListener { view ->
            var pos: Int = spinner.getSelectedItemPosition()
            if (pos != 0)
                text.setText(spinner.getSelectedItem() as String)
            else
                Toast.makeText(getApplicationContext(), "Будь ласка виберіть мову", Toast.LENGTH_SHORT).show()
        }
    }
}