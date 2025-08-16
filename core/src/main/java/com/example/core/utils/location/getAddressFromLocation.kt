package com.example.core.utils.location

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import java.util.*

fun getAddressFromLocation(
    context: Context,
    latitude: Double,
    longitude: Double
): String? {
    return try {
        val geocoder = Geocoder(context, Locale.getDefault())
        val addresses: List<Address>? = geocoder.getFromLocation(latitude, longitude, 1)
        if (!addresses.isNullOrEmpty()) {
            val address = addresses[0]
            "${address.locality ?: ""}, ${address.adminArea ?: ""}, ${address.countryName ?: ""}"
        } else null
    } catch (e: Exception) {
        Log.e("LocationUtils", "Geocoder error: ${e.message}")
        null
    }
}
