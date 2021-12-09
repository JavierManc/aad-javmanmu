package com.example.aad_playground.ut02.exercise04.domain

class SaveModelUseCase(private val modelRepository: ModelRepository) {
    fun execute(model: Models) {
        modelRepository.save(model)
    }
}