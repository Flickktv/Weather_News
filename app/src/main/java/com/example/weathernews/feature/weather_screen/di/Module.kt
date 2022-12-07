package com.example.weathernews.feature.weather_screen.di

import com.example.weathernews.BASE_URL
import com.example.weathernews.feature.weather_screen.WeatherInteractor
import com.example.weathernews.feature.weather_screen.data.*
import com.example.weathernews.feature.weather_screen.ui.WeatherScreenViewmodel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {

//    presenter = WeatherScreenPresenter(
//        WeatherInteractor(
//            WeatherRepoImpl(
//                WeatherRemoteSource(WeatherApiClient.getApi())
//            )
//        )
//    )

   single <OkHttpClient> {
       OkHttpClient
           .Builder()
           .build()
   }

    single <Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single <WeatherApi> { get<Retrofit>().create(WeatherApi::class.java) }

    single { WeatherRemoteSource(get()) }

    single<WeatherRepo> { WeatherRepoImpl(get()) }

    single { WeatherInteractor(get()) }

    viewModel { WeatherScreenViewmodel(get()) }
}