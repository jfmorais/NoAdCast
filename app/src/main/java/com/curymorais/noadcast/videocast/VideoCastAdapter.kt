package com.curymorais.noadcast.videocast

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.curymorais.noadcast.videocast.Video
import com.curymorais.noadcast.videocast.videoplayer.VideoPlayerActivity
import com.example.noadcast.R
import kotlinx.android.synthetic.main.item_row_video_cast.view.*

class VideoCastAdapter : RecyclerView.Adapter<VideoCastAdapter.VideoHolder>() {
    private var videos: ArrayList<Video> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
//        val inflatedView = parent.inflate(R.layout.item_row_video_cast, false)
        val inflatedView2 = LayoutInflater.from(parent.context).inflate(R.layout.item_row_video_cast, parent, false)
        return VideoHolder(inflatedView2)
    }


    override fun getItemCount() = videos.size

    override fun onBindViewHolder(holder : VideoHolder, position: Int) {
        val itemVideo = videos[position]
        holder.bindVideo(itemVideo)
    }

    fun updateDataSet(newVideos : ArrayList<Video>){
        this.videos = newVideos
        this.notifyDataSetChanged()
    }


    class VideoHolder(private val v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        private var video: Video? = null

        //3
        init {
            v.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
            val intent = Intent(v.context, VideoPlayerActivity::class.java)
            // To pass any data to next activity
             intent.putExtra("video", "/storage/emulated/0/Download/videoplayback.mp4")
            // start your next activity
            v.context.startActivity(intent)
        }

        fun bindVideo(video: Video) {
            this.video = video
            v.itemName.text = video.videoName
            v.itemDescription.text = video.videoSize
        }

        companion object {
            //5
            private val PHOTO_KEY = "PHOTO"
        }
    }
}