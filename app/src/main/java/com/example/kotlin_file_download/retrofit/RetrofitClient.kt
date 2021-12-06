package com.example.kotlin_file_download.retrofit


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient private constructor() {
    private val retrofit: Retrofit
    val aPI: API
        get() = retrofit.create(API::class.java)

//    var okHttpClient: OkHttpClient? = OkHttpClient.Builder()
//        .connectTimeout(120, TimeUnit.SECONDS)
//        .readTimeout(120, TimeUnit.SECONDS)
//        .writeTimeout(120, TimeUnit.SECONDS)
//
//        .addInterceptor { chain ->
//            val original = chain.request()
//            val requestBuilder = original.newBuilder()
//                .header("Authorization", TextContants.userPass)
//            val request = requestBuilder.build()
//            chain.proceed(request)
//        }
//        .build()

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    companion object {
        private const val BASE_URL = "http://10.11.201.180:8080/AgentBanking/"
        private var retrofitClient: RetrofitClient? = null

        @get:Synchronized
        val instance: RetrofitClient?
            get() {
                if (retrofitClient == null) {
                    retrofitClient = RetrofitClient()
                }
                return retrofitClient
            }
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}