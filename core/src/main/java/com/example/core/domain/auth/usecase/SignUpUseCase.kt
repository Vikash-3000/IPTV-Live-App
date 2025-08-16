package com.example.core.domain.auth.usecase

import android.os.Build
import com.example.core.domain.auth.repository.AuthRepository
import com.example.core.utils.state.AuthResultState
import com.google.firebase.Timestamp
import java.util.UUID
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val authRepo: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        fullName: String,
        mobile: String,
        location: String
    ): AuthResultState<Unit> {
        return try {

            // Create Firebase Auth user
            val user = authRepo.signupWithEmail(email, password)

            val deviceId = "${Build.MODEL}_${UUID.randomUUID()}"
            val now = Timestamp.now()

            authRepo.saveUserToFirestore(
                uid = user.uid,
                email = email,
                fullName = fullName,
                mobile = mobile,
                createdAt = now,
                lastLogin = now,
                deviceId = deviceId,
                location = location
            )

            AuthResultState.Success(Unit)
        } catch (e: Exception) {
            AuthResultState.Error(e.message ?: "Signup failed")
        }
    }
}