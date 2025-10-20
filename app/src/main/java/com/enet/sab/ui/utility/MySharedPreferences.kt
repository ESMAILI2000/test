package com.enet.sab.ui.utility

import android.content.Context
import java.util.Date

object MySharedPreferences {
    private fun getSharedPreferences(context: Context) =
        context.getSharedPreferences("Sab", Context.MODE_PRIVATE)

    fun getAdminPassword(context: Context) =
        getSharedPreferences(context).getString("AdminPassword", "894681")

    fun getPassword(context: Context) =
        getSharedPreferences(context).getString("Password", "1111") ?: "1111"

    fun setPassword(context: Context, password: String) =
        getSharedPreferences(context).edit().putString("Password", password).apply()

    fun setActivationDate(context: Context, activationDate: Date) =
        getSharedPreferences(context).edit().putLong("ActivationDate", activationDate.time).apply()


    fun getStartTime(context: Context) =
        getSharedPreferences(context).getLong("StartTime", 0L)

    fun setStartTime(context: Context, start: Long) =
        getSharedPreferences(context).edit().putLong("StartTime", start).apply()

    fun isActive(context: Context) = getSharedPreferences(context).getBoolean("Active", false)

    fun setActive(context: Context, active: Boolean) =
        getSharedPreferences(context).edit().putBoolean("Active", active).apply()


    fun getUiOff(context: Context) = getSharedPreferences(context).getInt("UiOff", 0)

    fun setUiOff(context: Context, firstName: Int) =
        getSharedPreferences(context).edit().putInt("UiOff", firstName).apply()

}