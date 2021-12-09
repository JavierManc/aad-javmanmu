package com.example.aad_playground.ut03.ex03.data

import com.example.aad_playground.ut03.ex03.data.local.db.AlertDbLocalSource
import com.example.aad_playground.ut03.ex03.data.remote.AlertRemoteSource
import com.example.aad_playground.ut03.ex03.domain.AlertModel
import com.example.aad_playground.ut03.ex03.domain.AlertRepository

class AlertDataRepository(
    private val remoteSource: AlertRemoteSource,
    private val localSource: AlertDbLocalSource
) : AlertRepository {

    override fun fetchAll(): List<AlertModel> {
        return if (localSource.getAlerts().isNullOrEmpty()) {
            val alerts = remoteSource.getAlerts()
            alerts.map { element -> localSource.save(element) }
            alerts
        } else {
            localSource.getAlerts()
        }
    }

    override fun fetchById(alertId: String): AlertModel? {
        return localSource.getAlert(alertId)
    }
}