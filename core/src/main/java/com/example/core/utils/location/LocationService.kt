package com.example.core.utils.location

import android.location.Location

interface LocationService {
    suspend fun getCurrentLocation(): Location?
}
