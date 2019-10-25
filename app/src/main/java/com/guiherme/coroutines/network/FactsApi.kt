package com.guiherme.coroutines.network

import retrofit2.http.GET

interface FactsApi {

    @GET("/only/facts")
    suspend fun getAFact(): FactResponse

    @GET("/android/fact")
    suspend fun getAndroidFact(): FactResponse

    @GET("/ios/fact")
    suspend fun getIosFact(): FactResponse

}