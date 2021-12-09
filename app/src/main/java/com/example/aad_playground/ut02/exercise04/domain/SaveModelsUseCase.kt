package com.example.aad_playground.ut02.exercise04.domain

class SaveModelsUseCase(private val modelRepository: ModelRepository) {
    fun execute(models: List<IModels>) {
        modelRepository.save(models)
    }
}