package com.example.aad_playground.ut02.exercise04.domain

interface ModelRepository {
    fun save(model: Models)
    fun save(modelList: List<Models>)
    fun remove(modelId: Int)
    fun fetch(): List<Models>
    fun fetchById(modelId: Int): Models?
}