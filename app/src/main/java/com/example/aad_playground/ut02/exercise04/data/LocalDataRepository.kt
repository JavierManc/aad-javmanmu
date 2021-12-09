package com.example.aad_playground.ut02.exercise04.data

import com.example.aad_playground.ut02.exercise04.domain.ModelRepository
import com.example.aad_playground.ut02.exercise04.domain.Models

class LocalDataRepository(private val localSource: LocalSource) : ModelRepository {
    override fun save(model: Models) {
        localSource.save(model)
    }

    override fun save(modelList: List<Models>) {
        localSource.save(modelList)
    }

    override fun remove(modelId: Int) {
        localSource.remove(modelId)
    }

    override fun fetch(): List<Models> {
        return localSource.fetch()
    }

    override fun fetchById(modelId: Int): Models? {
        return localSource.fetchById(modelId)
    }
}