package com.example.aad_playground.ut03.ex06.data.local.files

import android.content.Context
import com.example.aad_playground.commons.serializer.JsonSerializer
import com.example.aad_playground.ut03.ex06.data.local.TapaLocalSource
import com.example.aad_playground.ut03.ex06.domain.BarModel
import com.example.aad_playground.ut03.ex06.domain.TapaModel
import java.io.File

class FileTapaLocalSource(
    private val context: Context,
    private val serializer: JsonSerializer
) : TapaLocalSource {

    private fun getFile(fileName: String): File {
        val file = File(context.filesDir, fileName)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    override fun fetchTapa(id: String): TapaModel? {
        var tapa: TapaModel? = null
        val file = getFile(TAPAS_FILENAME)
        val lines = file.readLines()
        lines.map { line ->
            val model = serializer.fromJson(line, TapaModel::class.java)
            if (model.id == id) {
                tapa = model
            }
        }
        return tapa
    }

    override fun fetchTapas(): List<TapaModel> {
        val tapas: MutableList<TapaModel> = mutableListOf()
        val file = getFile(TAPAS_FILENAME)
        val lines = file.readLines()
        lines.map { line ->
            tapas.add(serializer.fromJson(line, TapaModel::class.java))
        }
        return tapas
    }

    override fun saveTapa(tapa: TapaModel) {
        val file = getFile(TAPAS_FILENAME)
        file.appendText(serializer.toJson(tapa, TapaModel::class.java) + System.lineSeparator())
    }

    companion object {
        const val TAPAS_FILENAME: String = "aad_tapas.txt"
    }
}