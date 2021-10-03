package com.example.retrofittestapp

import com.example.catsapi.data.ApiData
import retrofit2.http.GET

const val BASE_URL = "https://api.thecatapi.com"

interface ApiRequest {

    @GET("/v1/images/search/?format=json?api_key=50f467ad-8a4d-4761-9fc6-dbeaceb9003c")
    suspend fun getRandomCat():List<ApiData>
}