package com.example.aad_playground.ut03.ex03.data.local.xml

import com.example.aad_playground.ut03.ex03.app.storage.LocalModel
import com.example.aad_playground.ut03.ex03.domain.AlertModel

class AlertsLocalModel(
    val alertId: String,
    val alertList: List<AlertModel>
) : LocalModel {
    override fun getId(): String = alertId

    companion object {
        val ID: String = AlertsLocalModel::class.java.simpleName
    }
}