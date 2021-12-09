package com.example.aad_playground.ut03.ex03.data.local.db

import androidx.room.*
import com.example.aad_playground.ut03.ex03.app.storage.LocalModel
import com.example.aad_playground.ut03.ex03.domain.AlertModel
import com.example.aad_playground.ut03.ex03.domain.FileModel

@Entity(tableName = "alert")
data class AlertEntity(
    @PrimaryKey @ColumnInfo(name = "id") val alertId: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "summary") val summary: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "body") val body: String,
    @ColumnInfo(name = "Source") val source: String
) {
    fun toDomainModel(): AlertModel {
        return AlertModel(
            alertId, title, type, summary, date, body, source, mutableListOf()
        )
    }

}

@Entity(tableName = "file")
data class FileEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "alert_id") val alertId: String
)

data class AlertWithFiles(
    @Embedded val alertEntity: AlertEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "alert_id"
    ) val fileEntity: List<FileEntity>
) {
    fun toModel() = AlertModel(
        alertEntity.alertId,
        alertEntity.title,
        alertEntity.type,
        alertEntity.summary,
        alertEntity.date,
        alertEntity.body,
        alertEntity.source,
        fileEntity.map { element ->
            FileModel(element.name, element.url)
        }
    )
}
