package com.enet.test.ui.api

import com.enet.test.ui.model.CryptoRespons
import com.enet.test.ui.model.ObjectRequest
import com.enet.test.ui.model.ObjectResponse
import org.mongodb.kbson.BsonSymbol
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface CryptoApi {
    // Queryبا
    @GET("exchange_rate")
    suspend fun getRate(@Query("symbol") symbol: String,
                        @Query("apikey") apiKey: String
    ): CryptoRespons


    // با QueryMap
//    @GET("exchange_rate")
//    suspend fun getRate(@QueryMap params: Map<String, String>
//    ): CryptoRespons
}