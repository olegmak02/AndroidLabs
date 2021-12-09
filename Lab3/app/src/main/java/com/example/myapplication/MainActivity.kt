package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val FILE_NAME = "data.txt"
    var fragment_input : InputFragment? = null
    var fragment_outp : OutputFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment_input = InputFragment()
        fragment_outp = OutputFragment()

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_input, fragment_input!!)
        ft.replace(R.id.fragment_output, fragment_outp!!)
        ft.hide(fragment_outp!!)
        ft.commit()
    }

    /*fun saveText(lang: String) {
        try {
            val file = openFileOutput(FILE_NAME, MODE_APPEND)
            file.write(lang.toByteArray())
            Toast.makeText(this, "Файл збережено", Toast.LENGTH_SHORT).show()
            file.close()
        } catch (e: IOException) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show();
        }
    }*/

    fun printLang(lang: String) {
        val f: FragmentTransaction = supportFragmentManager.beginTransaction()
        f.show(this.fragment_outp!!)
        f.commit()
        this.fragment_outp?.setText(lang)
    }
}