package com.example.aad_playground.ut03.ex06.data.local

import com.example.aad_playground.ut03.ex06.domain.TapaModel

interface TapaLocalSource {
    fun fetchTapa(id: String): TapaModel?
    fun fetchTapas(): List<TapaModel>
    fun saveTapa(tapa: TapaModel)
}