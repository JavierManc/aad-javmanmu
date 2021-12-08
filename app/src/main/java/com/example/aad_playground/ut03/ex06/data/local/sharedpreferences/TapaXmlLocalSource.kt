package com.example.aad_playground.ut03.ex06.data.local.sharedpreferences

import android.content.Context
import com.example.aad_playground.commons.serializer.JsonSerializer
import com.example.aad_playground.ut03.ex06.data.local.TapaLocalSource
import com.example.aad_playground.ut03.ex06.domain.TapaModel

class TapaXmlLocalSource(
    private val context: Context,
    private val serializer: JsonSerializer
) : TapaLocalSource {

    private val nameXmlFile = "ut03_ex03_alerts"
    private val sharedPref = context.getSharedPreferences(nameXmlFile, Context.MODE_PRIVATE)

    override fun fetchTapa(id: String): TapaModel? {
        val model = sharedPref.getString(id, null)
        return if (model != null) {
            serializer.fromJson(model, TapaModel::class.java)
        } else {
            null
        }
    }

    override fun fetchTapas(): List<TapaModel> {
        val tapas: MutableList<TapaModel> = mutableListOf()
        val tapaStrings = sharedPref.all.map { it.value }
        tapaStrings.map { stringModel ->
            val model = serializer.fromJson(stringModel.toString(), TapaModel::class.java)
            tapas.add(model)
        }
        return tapas
    }

    override fun saveTapa(tapa: TapaModel) {
        val edit = sharedPref.edit()
        edit?.putString(tapa.id, serializer.toJson(tapa, TapaModel::class.java))
        edit?.apply()
    }
}