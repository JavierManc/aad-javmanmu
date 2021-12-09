package com.example.aad_playground.ut03.ex03.data.local.db

import android.content.Context
import com.example.aad_playground.ut03.ex03.app.db.Ut03Ex03DataBase
import com.example.aad_playground.ut03.ex03.data.local.AlertLocalSource
import com.example.aad_playground.ut03.ex03.domain.AlertModel

class AlertDbLocalSource(aplicationContext: Context) : AlertLocalSource {

    private val db = Ut03Ex03DataBase.getInstance(aplicationContext)

    override fun findAll(): List<AlertModel> {
        val alerts = db.alertDao().getAlerts()
        return alerts.map { alert -> alert.toModel() }
    }

    override fun save(alerts: List<AlertModel>) {
        alerts.map { alert ->
            val alertWithFiles = AlertWithFiles(
                AlertEntity(
                    alert.id,
                    alert.title,
                    alert.type,
                    alert.summary,
                    alert.datePublished,
                    alert.body,
                    alert.source
                ),
                alert.files.map { element -> FileEntity( element.name, element.url, alert.id) }
            )
            save(alertWithFiles)
        }
    }

    override fun findById(alertId: String): AlertModel {
        return db.alertDao().getAlert(alertId).toModel()
    }


    override fun save(alert: AlertWithFiles) {
        db.alertDao().insert(alert.alertEntity, alert.fileEntity)
    }
}