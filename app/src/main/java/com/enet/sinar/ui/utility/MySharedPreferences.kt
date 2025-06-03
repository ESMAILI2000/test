package com.enet.sinar.ui.utility

import android.content.Context
import java.util.Date

object MySharedPreferences {
    private fun getSharedPreferences(context: Context) =
        context.getSharedPreferences("Sinar", Context.MODE_PRIVATE)

}