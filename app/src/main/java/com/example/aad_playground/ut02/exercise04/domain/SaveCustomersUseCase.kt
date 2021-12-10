package com.example.aad_playground.ut02.exercise04.domain

class SaveCustomersUseCase(private val modelRepository: CustomerRepository) {
    fun execute(models: List<CustomerModel>) {
        modelRepository.save(models)
    }
}