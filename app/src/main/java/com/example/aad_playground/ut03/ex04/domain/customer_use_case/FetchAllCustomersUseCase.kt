package com.example.aad_playground.ut03.ex04.domain.customer_use_case

import com.example.aad_playground.ut03.ex04.domain.CustomerModel
import com.example.aad_playground.ut03.ex04.domain.CustomerRepository

class FetchAllCustomersUseCase(private val customerRepository: CustomerRepository) {

    fun execute(): List<CustomerModel> {
        return customerRepository.fetchAllCustomers()
    }
}