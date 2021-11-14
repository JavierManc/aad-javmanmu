package com.example.aad_playground.ut03.ex03.data

import com.example.aad_playground.ut03.ex03.data.remote.AlertRemoteSource
import com.example.aad_playground.ut03.ex03.domain.AlertModel
import com.example.aad_playground.ut03.ex03.domain.AlertRepository

class AlertDataRepository(private val remoteSource: AlertRemoteSource) : AlertRepository {

    override fun fetchAll(): List<AlertModel> {
        val alerts = remoteSource.getAlerts()
        TODO("Not yet implemented")
    }

    override fun fetchById(alertId: String): AlertModel {
        val alerts = remoteSource.getAlert(alertId)
        TODO("Not yet implemented")
    }
}