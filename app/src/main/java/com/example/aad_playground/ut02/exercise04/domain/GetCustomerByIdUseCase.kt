package com.example.aad_playground.ut02.exercise04.domain

class GetCustomerByIdUseCase(private val modelRepository: CustomerRepository) {
    fun execute(modelId: Int): CustomerModel? {
        return modelRepository.fetchById(modelId)
    }
}