package com.enet.test.ui.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiTest {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.twelvedata.com/")  //https://jsonplaceholder.typicode.com/
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiPost: PostApi by lazy {
        retrofit.create(PostApi::class.java)
    }

    val apiObject: ObjectApi by lazy {
        retrofit.create(ObjectApi::class.java)
    }

    val apiCrypto: CryptoApi by lazy {
        retrofit.create(CryptoApi::class.java)
    }
}
