package com.example.core.data.auth.repository

import com.example.core.domain.auth.repository.AuthRepository
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {

    override suspend fun signupWithEmail(email: String, password: String): FirebaseUser {
        val result = auth.createUserWithEmailAndPassword(email, password).await()
        return result.user ?: throw Exception("User creation failed")
    }

    override suspend fun saveUserToFirestore(
        uid: String,
        email: String,
        fullName: String,
        mobile: String,
        createdAt: Timestamp,
        lastLogin: Timestamp,
        deviceId: String,
        location: String
    ) {
        val userMap = mapOf(
            "uid" to uid,
            "email" to email,
            "fullName" to fullName,
            "mobile" to mobile,
            "createdAt" to createdAt,
            "lastLogin" to lastLogin,
            "deviceId" to deviceId,
            "location" to location
        )

        firestore.collection("users").document(uid).set(userMap).await()
    }
}
