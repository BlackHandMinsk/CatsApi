package com.example.catsapi.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiData(
    @Json(name = "id") val id: String,
    @Json(name = "url") val url: String
)

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "id") val id: String?,
    @Json(name = "url") val url: String?
)

@JsonClass(generateAdapter = true)
data class Multimedia(
    @Json(name = "src") val imageUrl: String?
)