package com.nano.dailytask.repo

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nano.dailytask.api.ApiService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

/**
 * Created By Neeraj Android on 24/09/24
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@Config(application = HiltTestApplication::class)
class ProductRepositoryUnitTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp(){
        hiltRule.inject()
        //mockWebServer.start()
    }

    @Test
    fun `test for success response of product`() = runTest{
        //mock response body
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody("{\n" +
                    "  \"products\": [\n" +
                    "    {\n" +
                    "      \"id\": 2,\n" +
                    "      \"thumbnail\": \"https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png\",\n" +
                    "      \"title\": \"Essence Mascara Lash Princess\",\n" +
                    "      \"price\": 9.99,\n" +
                    "      \"rating\": 4.0,\n" +
                    "      \"category\": \"beauty\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 3,\n" +
                    "      \"thumbnail\": \"https://cdn.dummyjson.com/products/images/beauty/Eyeshadow%20Palette%20with%20Mirror/thumbnail.png\",\n" +
                    "      \"title\": \"Eyeshadow Palette with Mirror\",\n" +
                    "      \"price\": 19.99,\n" +
                    "      \"rating\": 4.4,\n" +
                    "      \"category\": \"beauty\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"total\": 194,\n" +
                    "  \"skip\": 0,\n" +
                    "  \"limit\": 30\n" +
                    "}")

        //Enqueue Mock Response
        mockWebServer.enqueue(mockResponse)

        val response = apiService.getCosmeticProducts()

        //Validate Success
        assertEquals(200,response.code())
        assertEquals(2,response.body()?.products?.size)
        assertEquals("https://cdn.dummyjson.com/products/images/beauty/Eyeshadow%20Palette%20with%20Mirror/thumbnail.png", response.body()?.products?.get(1)?.thumbnail)
    }

    @After
    fun teardown(){
        mockWebServer.shutdown()
    }

}