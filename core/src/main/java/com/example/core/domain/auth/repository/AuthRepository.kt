package com.example.core.domain.auth.repository

import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun signupWithEmail(email: String, password: String): FirebaseUser
    suspend fun saveUserToFirestore(
        uid: String,
        email: String,
        fullName: String,
        mobile: String,
        createdAt: Timestamp,
        lastLogin: Timestamp,
        deviceId: String,
        location: String
    )
}