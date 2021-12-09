package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction


class OutputFragment : Fragment() {

    private lateinit var button_cancel : Button
    private lateinit var text_place : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_output, container, false)

        button_cancel = view.findViewById(R.id.cancel)
        text_place = view.findViewById(R.id.output)

        button_cancel.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.hide(this)
            ft.commit()
        }

        return view
    }

    fun setText(text: String) {
        this.text_place.setText(text)
    }
}