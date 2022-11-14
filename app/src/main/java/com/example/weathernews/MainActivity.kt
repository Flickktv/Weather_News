package com.example.weathernews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.weathernews.feature.weather_screen.WeatherInteractor
import com.example.weathernews.feature.weather_screen.data.WeatherApiClient
import com.example.weathernews.feature.weather_screen.data.WeatherRemoteSource
import com.example.weathernews.feature.weather_screen.data.WeatherRepo
import com.example.weathernews.feature.weather_screen.data.WeatherRepoImpl
import com.example.weathernews.feature.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: WeatherScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = WeatherScreenPresenter(
            WeatherInteractor(
                WeatherRepoImpl(
                    WeatherRemoteSource(WeatherApiClient.getApi())
                )
            )
        )

        GlobalScope.launch {
            presenter.interactor.getWeather()
        }



    }
}