package com.example.aad_playground.ut03.ex03.data.local.xml

import com.example.aad_playground.ut03.ex03.app.storage.LocalStorage
import com.example.aad_playground.ut03.ex03.data.local.AlertLocalSource
import com.example.aad_playground.ut03.ex03.data.local.db.AlertWithFiles
import com.example.aad_playground.ut03.ex03.domain.AlertModel

class SharedPrefLocalSource(private val localStorage: LocalStorage<AlertsLocalModel>) :
    AlertLocalSource {
    override fun findAll(): List<AlertModel> {
        val alerts = localStorage.fetch(AlertsLocalModel.ID, AlertsLocalModel::class.java)
        return alerts?.alertList ?: mutableListOf()
    }

    override fun save(alerts: List<AlertModel>) {
        localStorage.save(
            AlertsLocalModel(
                AlertsLocalModel.ID, alerts
            )
        )
    }

    override fun save(alert: AlertWithFiles) {

    }

    override fun findById(alertId: String): AlertModel? {
        val alerts = localStorage.fetch(AlertsLocalModel.ID, AlertsLocalModel::class.java)
        var especificAlert: AlertModel? = null
        alerts?.alertList?.map { alert ->
            if(alert.id == alertId){
                especificAlert = alert
            }
        }
        return especificAlert
    }
}