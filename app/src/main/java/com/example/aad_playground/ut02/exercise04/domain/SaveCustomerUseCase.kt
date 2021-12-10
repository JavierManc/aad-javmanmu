package com.example.aad_playground.ut02.exercise04.domain

class SaveCustomerUseCase(private val modelRepository: CustomerRepository) {
    fun execute(model: CustomerModel) {
        modelRepository.save(model)
    }
}