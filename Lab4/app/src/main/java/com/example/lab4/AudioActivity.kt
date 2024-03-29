package com.example.lab4

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast

class AudioActivity : AppCompatActivity() {
    private lateinit var buttonStart : Button
    private lateinit var buttonPause : Button
    private lateinit var buttonStop : Button
    private var mp: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)
        buttonStart = findViewById(R.id.button_start)
        buttonPause = findViewById(R.id.button_pause)
        buttonStop = findViewById(R.id.button_stop)
    }

    override fun onStop() {
        super.onStop()
        mp?.stop()
        mp?.release()
        mp = null
    }
    


    fun start(view: View) {
        if (mp == null) {
            val audioChooserIntent = Intent(Intent.ACTION_GET_CONTENT)
            audioChooserIntent.setType("audio/*")
            startActivityForResult(Intent.createChooser(audioChooserIntent, "select audio"), 1)
        } else {
            mp?.start()
        }
    }

    fun pause(view: View) {
        if (mp != null) {
            mp?.pause()
        }
    }

    fun stop(view: View) {
        if (mp != null) {
            mp?.stop()
            mp?.release()
            mp = null
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val uploadfileuri = data.data
            mp = MediaPlayer.create(this, uploadfileuri)
            mp?.start()
        }
    }
}
