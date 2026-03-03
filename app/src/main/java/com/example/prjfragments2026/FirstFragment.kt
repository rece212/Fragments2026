package com.example.prjfragments2026

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import java.util.concurrent.Executors


class FirstFragment : Fragment() {
    val handler = Handler(Looper.getMainLooper())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout =inflater.inflate(R.layout.fragment_first, container, false)
        var image : Bitmap?=null
        val executor = Executors.newSingleThreadExecutor()
        val imageView: ImageView = layout.findViewById(R.id.imDuck)

        executor.execute {
            val imageUrl = "https://httpducks.com/405.jpg"
            try {
                val `in` = java.net.URL(imageUrl).openStream()
                image= BitmapFactory.decodeStream(`in`)
                Log.d("Added new duck","Image in text "+imageUrl.toString())
                handler.post{
                    Log.d("Added new duck","Image added ")
                    imageView.setImageBitmap(image)
                }
            }
            catch (e:java.lang.Exception)
            {
                Log.d("Added new duck","Error happened..."+e.toString())
            }
        }
        return layout
    }

}