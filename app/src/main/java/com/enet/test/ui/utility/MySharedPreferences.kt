package com.enet.test.ui.utility

import android.content.Context

object MySharedPreferences {
    private fun getSharedPreferences(context: Context) =
        context.getSharedPreferences("Sinar", Context.MODE_PRIVATE)

    fun setIsEn(context: Context,isEn : Boolean)=
        getSharedPreferences(context).edit().putBoolean("is_en",isEn)

    fun getIsEn(context: Context)=
        getSharedPreferences(context).getBoolean("is_en",false)

}