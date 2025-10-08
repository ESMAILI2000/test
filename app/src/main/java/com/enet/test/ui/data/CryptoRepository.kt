package com.enet.test.ui.data

import com.enet.test.ui.api.ApiTest
import com.enet.test.ui.model.CryptoRespons
import com.enet.test.ui.model.ObjectRequest
import com.enet.test.ui.model.ObjectResponse
import org.mongodb.kbson.BsonSymbol

class CryptoRepository {
    suspend fun getRate(symbol: String , apiKey:String): CryptoRespons {
        val params = mapOf(
            "symbol" to symbol,
            "apikey" to apiKey
        )
        return ApiTest.apiCrypto.getRate(symbol,apiKey) // با Query
//        return ApiTest.apiCrypto.getRate(params) // با QueryMap
    }
}