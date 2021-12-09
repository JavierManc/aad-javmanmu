package com.example.aad_playground.ut02.exercise04.domain

class GetEspecificModelUseCase(private val modelRepository: ModelRepository) {
    fun execute(modelId: Int): IModels? {
        return modelRepository.fetchById(modelId)
    }
}