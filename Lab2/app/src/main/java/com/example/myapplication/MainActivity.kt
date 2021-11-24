package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

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

    fun printLang(lang: String) {
        val f: FragmentTransaction = supportFragmentManager.beginTransaction()
        f.show(this.fragment_outp!!)
        f.commit()
        this.fragment_outp?.setText(lang)
    }
}