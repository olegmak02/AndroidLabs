package com.example.lab4

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {
    private lateinit var player : VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val photoPickerIntent = Intent(Intent.ACTION_GET_CONTENT)
        photoPickerIntent.setType("video/*")
        startActivityForResult(Intent.createChooser(photoPickerIntent, "select video"), 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val uploadfileuri = data.data
            /*val mp = MediaPlayer()
            mp.setDataSource(this, uploadfileuri!!)

            val mc = MediaController(this)
            mc.setMediaPlayer(mp)
            mp.prepare()
            mp.start()*/
            player = findViewById(R.id.player)
            player.setVideoURI(uploadfileuri)
            val mediaController = MediaController(this)
            player.setMediaController(mediaController)
            mediaController.setMediaPlayer(player)
            mediaController.hide()
            //player.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4")
        }
    }
}
