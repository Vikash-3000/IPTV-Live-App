package com.example.core.utils.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.util.Log
import androidx.core.content.PermissionChecker
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class LocationServiceImpl @Inject constructor(
    private val context: Context
) : LocationService {

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): Location? {
        val hasPermission = PermissionChecker.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PermissionChecker.PERMISSION_GRANTED

        if (!hasPermission) {
            Log.e("LocationService", "Permission not granted")
            return null
        }

        val fusedClient = LocationServices.getFusedLocationProviderClient(context)
        return suspendCancellableCoroutine { cont ->
            fusedClient.lastLocation
                .addOnSuccessListener { location ->
                    cont.resume(location)
                }
                .addOnFailureListener { e ->
                    Log.e("LocationService", "Failed to get location", e)
                    cont.resume(null)
                }
        }
    }
}