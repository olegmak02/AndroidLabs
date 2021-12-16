package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class InternetDataActivity : AppCompatActivity() {
    private lateinit var text : TextView
    private lateinit var address : EditText
    private lateinit var button_ok : Button
    private lateinit var player : VideoView
    private lateinit var mediaController : MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_data)
        mediaController = MediaController(this)
        button_ok = findViewById(R.id.button_ok)
        text = findViewById(R.id.title)
        address = findViewById(R.id.address_input)
        player = findViewById(R.id.video_player)

        button_ok.setOnClickListener {
            player.setVideoPath(address.text.toString())
            player.setMediaController(mediaController)
            mediaController.setMediaPlayer(player)
            player.start()
        }
    }
}