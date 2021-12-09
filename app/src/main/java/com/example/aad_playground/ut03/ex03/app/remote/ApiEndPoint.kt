package com.example.aad_playground.ut03.ex03.app.remote

import com.example.aad_playground.ut03.ex03.data.remote.AlertApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiEndPoint {
    @GET("alerts")
    fun getAlerts(): Call<ApiResponse<List<AlertApiModel>>>

    @GET("alerts/{alert_id}")
    fun getAlert(@Path("alert_id") alertId: String): Call<ApiResponse<AlertApiModel>>
}