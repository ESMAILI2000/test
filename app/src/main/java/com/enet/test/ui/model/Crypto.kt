package com.enet.test.ui.model

import org.mongodb.kbson.BsonSymbol
import org.mongodb.kbson.Decimal128

data class CryptoRespons (
        val symbol: String,
        val rate: Double,
        val timestamp: Long
)