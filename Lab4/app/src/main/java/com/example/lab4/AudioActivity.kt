package com.example.lab4

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController

class AudioActivity : AppCompatActivity() {
    private lateinit var button_start : Button
    private lateinit var button_pause : Button
    private lateinit var button_stop : Button
    private var mp: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)
        button_start = findViewById(R.id.button_start)
        button_start.setOnClickListener {
            if (mp == null) {
                val photoPickerIntent = Intent(Intent.ACTION_GET_CONTENT)
                photoPickerIntent.setType("audio/*")
                startActivityForResult(Intent.createChooser(photoPickerIntent, "select audio"), 1)
            } else {
                mp?.start()
            }
        }
        button_pause = findViewById(R.id.button_pause)
        button_pause.setOnClickListener {
            if (mp != null) {
                mp!!.pause()
            }
        }
        button_stop = findViewById(R.id.button_stop)
        button_stop.setOnClickListener {
            super.onStop()
            if (mp != null) {
                mp!!.release()
                mp = null
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val uploadfileuri = data.data
            val mp = MediaPlayer()
            mp.setDataSource(this, uploadfileuri!!)
            mp.prepare()
            mp.start()
        }
    }
}
