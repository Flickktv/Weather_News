package com.example.weathernews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.weathernews.feature.weather_screen.ui.WeatherScreenViewmodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewmodel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textViewHello = findViewById<TextView>(R.id.tvHello)

        GlobalScope.launch {
            withContext(Dispatchers.Main){
                textViewHello.text = viewModel.getWeather()
            }
        }



    }
}