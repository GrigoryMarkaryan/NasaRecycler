package com.example.nasarecycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasarecycler.databinding.PhotoItemBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsPhotoAdapter : RecyclerView.Adapter<PhotoHolder>() {

    var photos: Photos? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        return PhotoHolder(
            PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return photos?.photosList?.size ?: 0
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val url = photos?.photosList?.get(position)?.imageUrl

        Glide.with(holder.binding.foto.context)
            .load(url?.replace("http://", "https://", true))
            .into(holder.binding.foto)
    }

    suspend fun getPhotos() {
        photos = retrofit.getMarsPhotos()
//        Log.d("DDD", "")
//        notifyDataSetChanged()
    }

}

class PhotoHolder(val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root)