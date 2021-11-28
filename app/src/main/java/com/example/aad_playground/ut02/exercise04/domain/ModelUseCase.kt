package com.example.aad_playground.ut02.exercise04.domain

class GetModelUseCase(private val modelRepository: ModelRepository) {
    fun execute(): List<IModels> {
        return modelRepository.fetch()
    }
}

class GetEspecificModelUseCase(private val modelRepository: ModelRepository) {
    fun execute(modelId: Int): IModels? {
        return modelRepository.fetchById(modelId)
    }
}

class DeleteModelUseCase(private val modelRepository: ModelRepository) {
    fun execute(modelId: Int) {
        modelRepository.remove(modelId)
    }
}

class SaveModelsUseCase(private val modelRepository: ModelRepository) {
    fun execute(models: List<IModels>) {
        modelRepository.save(models)
    }
}

class SaveModelUseCase(private val modelRepository: ModelRepository) {
    fun execute(model: IModels) {
        modelRepository.save(model)
    }
}