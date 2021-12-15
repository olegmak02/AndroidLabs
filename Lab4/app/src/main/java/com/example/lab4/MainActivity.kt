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
import android.util.Log
import java.net.URI
import java.io.File





class MainActivity : AppCompatActivity() {
    private lateinit var player : VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //player = findViewById(R.id.player)
        val photoPickerIntent = Intent(Intent.ACTION_GET_CONTENT)
        photoPickerIntent.setType("video/*")
        startActivityForResult(Intent.createChooser(photoPickerIntent, "select video"), 1)
        val path: Uri? = photoPickerIntent.getData()

        /*player.setVideoURI(path)

        val mediaController = MediaController(this)
        player.setMediaController(mediaController)
        mediaController.setMediaPlayer(player)*/
        //player.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val uploadfileuri = data.data
            val file = File(uploadfileuri!!.path)
            player = findViewById(R.id.player)
            player.setVideoURI(uploadfileuri)

            val mediaController = MediaController(this)
            player.setMediaController(mediaController)
            mediaController.setMediaPlayer(player)
            Log.d("Tag", uploadfileuri.toString())

            //player.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4")
        }
    }

    fun play(view: View?) {
        player.start()
    }

    fun pause(view: View?) {
        player.pause()
    }

    fun stop(view: View?) {
        player.stopPlayback()
        player.resume()
    }
}