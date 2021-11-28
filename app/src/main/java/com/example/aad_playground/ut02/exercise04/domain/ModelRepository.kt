package com.example.aad_playground.ut02.exercise04.domain

interface ModelRepository {
    fun save(model: IModels)
    fun save(modelList: List<IModels>)
    fun remove(modelId: Int)
    fun fetch(): List<IModels>
    fun fetchById(modelId: Int): IModels?
}