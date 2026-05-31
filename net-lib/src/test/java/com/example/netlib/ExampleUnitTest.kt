package com.example.netlib

import com.example.netlib.data.dto.AuthRequest
import com.example.netlib.data.dto.RegisterRequest
import com.example.netlib.data.repositoryImpl.AuthenticationRepositoryImpl
import com.example.netlib.data.result.NetworkResult
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var authenticationRepository: AuthenticationRepositoryImpl

    @Before
    fun start() {
        hiltRule.inject()
    }

    @Test
    fun register() = runTest {

        val email = "email_${System.currentTimeMillis()}@gmail.com"
        val result = authenticationRepository.register(
            RegisterRequest(
                fullName = "Violetta Deryabina",
                email = email,
                password = "1234567890",
                role = "candidate"
            )
        )

        assertTrue(result is NetworkResult.Success)
        val data = (result as NetworkResult.Success).data
        assertEquals("Violetta Deryabina", data.data.user.fullName)

        val resultAuth = authenticationRepository.authorization(
            AuthRequest(
                email = email,
                password = "1234567890"
            )
        )
        assertTrue(result is NetworkResult.Success)
        val dataAuth = (result as NetworkResult.Success).data
        assertEquals(email, dataAuth.data.user.email)
    }
}