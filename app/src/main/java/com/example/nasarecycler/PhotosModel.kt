package com.example.nasarecycler;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;

@JsonClass(generateAdapter = true)
data class Photos(
        @Json(name = "photos") val photosList: List<Photo>
)

@JsonClass(generateAdapter = true)
data class Photo(
        @Json(name = "id") val id: Int,
        @Json(name = "sol") val marsDate: Int,
        @Json(name = "camera") val camera: RoverCamera,
        @Json(name = "img_src") val imageUrl: String,
        @Json(name = "earth_date") val earthDate: String,
        @Json(name = "rover") val rover: Rover
)

@JsonClass(generateAdapter = true)
data class RoverCamera(
        @Json(name = "id") val cameraId: Int,
        @Json(name = "name") val cameraName: String,
        @Json(name = "rover_id") val roverId: Int,
        @Json(name = "full_name") val fullCameraName: String
)

@JsonClass(generateAdapter = true)
data class Rover(
        @Json(name = "id") val roverId: Int,
        @Json(name = "name") val roverName: String,
        @Json(name = "landing_date") val landingDate: String,
        @Json(name = "launch_date") val launchDate: String,
        @Json(name = "status") val status: String,
        @Json(name = "max_sol") val maxSol: Int,
        @Json(name = "max_date") val maxDate: String,
        @Json(name = "total_photos") val totalPhotos: Int
)

