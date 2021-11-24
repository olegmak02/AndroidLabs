package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class InputFragment : Fragment() {

    private lateinit var button_ok : Button
    private lateinit var spinner : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_input, container, false)

        button_ok = view.findViewById(R.id.ok)
        spinner = view.findViewById(R.id.spinner)


        button_ok.setOnClickListener {
            val pos: Int = spinner.getSelectedItemPosition()
            if (pos != 0) {
                var text : String = spinner.getSelectedItem() as String
                (this.activity as MainActivity).printLang(text)
            } else {
                Toast.makeText(getActivity(), "Будь ласка виберіть мову", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}