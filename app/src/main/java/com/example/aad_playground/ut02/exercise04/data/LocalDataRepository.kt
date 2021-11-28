package com.example.aad_playground.ut02.exercise04.data

import com.example.aad_playground.ut02.exercise04.domain.ModelRepository
import com.example.aad_playground.ut02.exercise04.domain.IModels

class LocalDataRepository(private val localSource: LocalSource) : ModelRepository {
    override fun save(model: IModels) {
        localSource.save(model)
    }

    override fun save(modelList: List<IModels>) {
        localSource.save(modelList)
    }

    override fun remove(modelId: Int) {
        localSource.remove(modelId)
    }

    override fun fetch(): List<IModels> {
        return localSource.fetch()
    }

    override fun fetchById(modelId: Int): IModels? {
        return localSource.fetchById(modelId)
    }
}