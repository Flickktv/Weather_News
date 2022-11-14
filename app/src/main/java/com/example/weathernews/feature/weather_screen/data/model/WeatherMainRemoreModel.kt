package com.example.weathernews.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherMainRemoreModel(
    @SerializedName("temp")
    val temperature: String
)
