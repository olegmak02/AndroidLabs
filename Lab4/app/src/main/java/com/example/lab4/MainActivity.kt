package com.example.lab4

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import android.view.View
import android.widget.MediaController
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Button
import java.net.URI
import java.io.File


class MainActivity : AppCompatActivity() {
    private lateinit var buttonVideo : Button
    private lateinit var buttonAudio : Button
    private lateinit var buttonInternet : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonVideo = findViewById(R.id.button_video)
        buttonAudio = findViewById(R.id.button_audio)
        buttonInternet = findViewById(R.id.button_internet)

        buttonVideo.setOnClickListener {
            this.startActivity(Intent(this, VideoActivity::class.java))
        }

        buttonAudio.setOnClickListener {
            this.startActivity(Intent(this, AudioActivity::class.java))
        }

        buttonInternet.setOnClickListener {
            this.startActivity(Intent(this, InternetDataActivity::class.java))
        }
    }
}