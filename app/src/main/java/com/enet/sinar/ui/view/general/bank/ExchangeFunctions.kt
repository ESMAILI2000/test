package com.enet.sinar.ui.view.general.bank

import androidx.compose.ui.graphics.painter.Painter

data class OffersItem(
    val firstCount:Int,
    val firstText: String,
    val trxCount:Int,
    val smartContractCount: Int,
    val nftCount: Int
)