package com.example.aad_playground.ut03.ex06.data.local.database

import android.content.Context
import com.example.aad_playground.ut03.ex06.app.database.Ut03Ex06Database
import com.example.aad_playground.ut03.ex06.data.local.TapaLocalSource
import com.example.aad_playground.ut03.ex06.domain.TapaModel

class TapaDbLocalSource(applicationContext: Context) : TapaLocalSource {

    private val db = Ut03Ex06Database.getInstance(applicationContext)

    override fun fetchTapa(id: String): TapaModel {
        val tapa = db.tapaDao().fetchTapa(id)
        return tapa.toModel()
    }

    override fun fetchTapas(): List<TapaModel> {
        val tapas = db.tapaDao().fetchTapas()
        return tapas.map { entity ->
            entity.toModel()
        }
    }

    override fun saveTapa(tapa: TapaModel) {
        val tapaEntity = TapaEntity(
            tapa.id,
            tapa.name,
            tapa.description,
            tapa.price,
            tapa.urlMainPhoto,
            tapa.barModel.id
        )
        val barEntity = BarEntity(tapa.barModel.id, tapa.barModel.name, tapa.barModel.address)

        db.tapaDao().saveTapa(TapaAndBar(tapaEntity, barEntity))
    }
}