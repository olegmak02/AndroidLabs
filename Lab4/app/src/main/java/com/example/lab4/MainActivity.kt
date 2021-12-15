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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button)

        button.setOnClickListener {
            this.startActivity(Intent(this, PlayerActivity::class.java))
        }
        //player = findViewById(R.id.player)

        /*player.setVideoURI(path)

        val mediaController = MediaController(this)
        player.setMediaController(mediaController)
        mediaController.setMediaPlayer(player)*/
        //player.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4")
    }


}