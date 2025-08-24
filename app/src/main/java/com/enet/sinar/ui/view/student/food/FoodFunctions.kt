package com.enet.sinar.ui.view.student.food

import androidx.compose.ui.graphics.painter.Painter

data class FoodItem(
    val foodName:String,
    val resturanName: String,
    val isMen: Boolean,
    val image: Painter
)