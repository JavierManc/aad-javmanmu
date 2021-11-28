package com.example.aad_playground.ut02.exercise04.data

import com.example.aad_playground.ut02.exercise04.domain.IModels

interface LocalSource {
    fun save(model: IModels)
    fun save(modelList: List<IModels>)
    fun remove(modelId: Int)
    fun fetch(): List<IModels>
    fun fetchById(modelId: Int): IModels?
}