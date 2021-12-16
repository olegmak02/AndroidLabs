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
    private lateinit var button_video : Button
    private lateinit var button_audio : Button
    private lateinit var button_internet : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_video = findViewById(R.id.button_video)
        button_audio = findViewById(R.id.button_audio)
        button_internet = findViewById(R.id.button_internet)

        button_video.setOnClickListener {
            this.startActivity(Intent(this, VideoActivity::class.java))
        }

        button_audio.setOnClickListener {
            this.startActivity(Intent(this, AudioActivity::class.java))
        }
    }
}