package com.curymorais.noadcast.videocast.videoplayer

import android.net.Uri
import android.net.Uri.*
import android.os.Bundle
import android.os.Environment
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.noadcast.R
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity: AppCompatActivity() {

    //TODO refactor dessa classe
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        val videoView = videoView
        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        //specify the location of media file
        val uri: Uri = parse(Environment.getExternalStorageDirectory().getPath() + "/Download/videoplayback.mp4")
        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}