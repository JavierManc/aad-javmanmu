package com.example.aad_playground.ut03.ex03.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aad_playground.ut03.ex03.domain.AlertModel

@Entity(tableName = "alert")
data class AlertEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name ="type") val type: Int,
    @ColumnInfo(name = "summary") val summary: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "body") val body: String,
    @ColumnInfo(name = "Source") val source: String
) {
    fun toDomainModel(): AlertModel = AlertModel(
        id,
        title,
        type,
        summary,
        date,
        body,
        source,
        mutableListOf()
    )
}
