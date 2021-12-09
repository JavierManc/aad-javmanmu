package com.example.aad_playground.ut03.ex03.data.local

import com.example.aad_playground.ut03.ex03.data.local.db.AlertWithFiles
import com.example.aad_playground.ut03.ex03.domain.AlertModel

interface AlertLocalSource {
    fun findAll(): List<AlertModel>

    fun save(alerts: List<AlertModel>)

    fun save(alert: AlertWithFiles)

    fun findById(alertId: String): AlertModel?
}