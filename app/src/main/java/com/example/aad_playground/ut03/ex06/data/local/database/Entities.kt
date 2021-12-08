package com.example.aad_playground.ut03.ex06.data.local.database

import androidx.room.*
import com.example.aad_playground.ut03.ex06.domain.BarModel
import com.example.aad_playground.ut03.ex06.domain.TapaModel

@Entity(tableName = "tapas")
data class TapaEntity(
    @PrimaryKey @ColumnInfo(name = "tapaId") val tapaId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "urlPhoto") val urlPhoto: String,
    @ColumnInfo(name= "barId") val barId: String
)

@Entity(tableName = "bar")
data class BarEntity(
    @PrimaryKey @ColumnInfo(name = "barId") val barId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "adress") val adress: String,
) {
    fun toModel() =
        BarModel(
            barId,
            name,
            adress
        )
}

data class TapaAndBar(
    @Embedded val tapaEntity: TapaEntity,
    @Relation(
        parentColumn = "tapaId",
        entityColumn = "barId"
    ) val barEntity: BarEntity
) {
    fun toModel(): TapaModel =
        TapaModel(
            tapaEntity.tapaId,
            tapaEntity.name,
            tapaEntity.description,
            tapaEntity.price,
            tapaEntity.urlPhoto,
            barEntity.toModel()
        )
}