package com.example.aad_playground.ut02.exercise04.domain

class DeleteCustomerUseCase(private val customerRepository: CustomerRepository) {
    fun execute(modelId: Int) {
        customerRepository.remove(modelId)
    }
}