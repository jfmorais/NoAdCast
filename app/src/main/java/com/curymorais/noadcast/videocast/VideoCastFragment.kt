package com.curymorais.noadcast.videocast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.curymorais.noadcast.Contract
import com.example.noadcast.R
import kotlinx.android.synthetic.main.fragment_videocast.*


class VideoCastFragment : Fragment(), Contract.View {

    val TAG = VideoCastFragment::class.java.simpleName

    private lateinit var adapter: VideoCastAdapter
    private lateinit var mPresenter : VideoCastPresenter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_videocast, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
//        setComponentListeners()
        updateVideoList()
    }

    override fun initComponents() {
        mPresenter = VideoCastPresenter(this)
        linearLayoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        adapter = VideoCastAdapter()
        video_list.layoutManager = linearLayoutManager
        video_list.adapter = adapter
    }

    override fun setComponentListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun updateVideoList(){
        adapter.updateDataSet(mPresenter.getVideoList())
    }

}

