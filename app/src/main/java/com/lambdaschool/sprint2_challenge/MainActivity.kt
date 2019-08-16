package com.lambdaschool.sprint2_challenge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapter


    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (photosList.size == 0) {
            requestPhoto()
        }


        override fun receivedNewPhoto(newPhoto: Photo) {
            runOnUiThread {
                photosList.add(newPhoto)
                adapter.notifyItemInserted(photosList.size-1)
            }
        }


        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


        adapter = RecyclerAdapter(photosList)
        recyclerView.adapter = adapter





    }
}
