package com.example.aad_playground.ut03.ex04.domain

class FetchAllCustomersUseCase(private val customerRepository: CustomerRepository) {

    fun execute(): List<CustomerModel> {
        return customerRepository.fetchAllCustomers()
    }
}

class FetchCustomerByIdUseCase(private val customerRepository: CustomerRepository) {

    fun execute(id: Int): CustomerModel {
        return customerRepository.fetchCustomerById(id)
    }
}

class SaveCustomerUseCase(private val customerRepository: CustomerRepository){

    fun execute(model: CustomerModel){
        customerRepository.saveCustomerModel(model)
    }
}