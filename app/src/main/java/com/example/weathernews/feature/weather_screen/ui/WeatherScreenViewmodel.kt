package com.example.weathernews.feature.weather_screen.ui

import androidx.lifecycle.ViewModel
import com.example.weathernews.feature.weather_screen.WeatherInteractor

class WeatherScreenViewmodel(val interactor: WeatherInteractor): ViewModel() {

    suspend fun getWeather(): String {
        return interactor.getWeather()
    }
}