package com.example.aad_playground.ut03.ex03.app

import com.example.aad_playground.ut03.ex03.data.remote.AlertApiModel

interface ApiClient {
    fun getAlerts(): List<AlertApiModel>
    fun getAlert(alertId: String): AlertApiModel?
}