package com.example.aad_playground.ut03.ex03.data.local

import android.content.Context
import com.example.aad_playground.ut03.ex03.app.local.Ut03Ex03DataBase
import com.example.aad_playground.ut03.ex03.domain.AlertModel

class AlertLocalSource(aplicationContext: Context) {
    private val db = Ut03Ex03DataBase.getInstance(aplicationContext)

    fun getAlerts(): List<AlertModel> {
        val entities = db.alertDao().getAlerts()
        return entities.map { alerts -> alerts.toDomainModel() }
    }

    fun getAlert(alert_id: String): AlertModel{
        return db.alertDao().getAlert(alert_id).toDomainModel()
    }

    fun save(alertModel: AlertModel) {
        db.alertDao().insert(
            AlertEntity(
                alertModel.id,
                alertModel.title,
                alertModel.type,
                alertModel.summary,
                alertModel.datePublished,
                alertModel.body,
                alertModel.source
            )
        )
    }
}