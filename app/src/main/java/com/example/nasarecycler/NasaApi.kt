package com.example.nasarecycler

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NasaApi {

//    @Headers("api_key: $api_key")
    @GET("v1/rovers/curiosity/photos")
    suspend fun getMarsPhotos(
        @Query("sol") sol: Int = 1000,
        @Query("api_key") apiKey: String = api_key
    ): Photos

    companion object {
        private const val api_key = "k9vyHdbKGuEj5tGBzFVyco5WGjRf6kzbGfAYSKqp"
    }
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.nasa.gov/mars-photos/api/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(NasaApi::class.java)