package com.example.aad_playground.ut03.ex04.domain.customer_use_case

import com.example.aad_playground.ut03.ex04.domain.CustomerModel
import com.example.aad_playground.ut03.ex04.domain.CustomerRepository

class FetchCustomerByIdUseCase(private val customerRepository: CustomerRepository) {

    fun execute(id: Int): CustomerModel {
        return customerRepository.fetchCustomerById(id)
    }
}