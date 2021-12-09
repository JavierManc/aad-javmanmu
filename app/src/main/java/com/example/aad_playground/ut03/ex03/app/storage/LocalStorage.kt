package com.example.aad_playground.ut03.ex03.app.storage

interface LocalStorage<T : LocalModel> {
    fun fetch(modelId: String, type: Class<T>): T?
    fun save(model: T)
}





