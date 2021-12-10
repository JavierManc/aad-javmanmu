package com.example.aad_playground.ut02.exercise04.domain

class GetCustomersUseCase(private val customerRepository: CustomerRepository) {
    fun execute(): List<CustomerModel> {
        return customerRepository.fetch()
    }
}