package com.example.catsapi.data

import com.example.catsapi.data.ApiData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.thecatapi.com"

interface ApiRequest {

    @GET("/v1/images/search?limit=10&order=Desc?format=json?api_key=50f467ad-8a4d-4761-9fc6-dbeaceb9003c")
    suspend fun getListOfCat(): List<ApiData>
}

object CatsApiImpl {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.thecatapi.com")
        .build()

    private val newYorkTimesService = retrofit.create(ApiRequest::class.java)

    suspend fun getListOfCat(): List<Cat> {
        return withContext(Dispatchers.IO) {
            newYorkTimesService.getListOfCat().map {
                    apiData -> Cat(apiData.id,apiData.url)
            }

        }
    }
}