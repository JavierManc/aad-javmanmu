package com.example.aad_playground.ut02.exercise04.domain

class DeleteModelUseCase(private val modelRepository: ModelRepository) {
    fun execute(modelId: Int) {
        modelRepository.remove(modelId)
    }
}