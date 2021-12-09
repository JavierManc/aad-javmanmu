package com.example.aad_playground.ut02.exercise04.domain

class GetModelUseCase(private val modelRepository: ModelRepository) {
    fun execute(): List<Models> {
        return modelRepository.fetch()
    }
}