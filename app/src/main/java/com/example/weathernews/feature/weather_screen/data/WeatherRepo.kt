package com.example.weathernews.feature.weather_screen.data

interface WeatherRepo {

    suspend fun getTemperature(): String
}