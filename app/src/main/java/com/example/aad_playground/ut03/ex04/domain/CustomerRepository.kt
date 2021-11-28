package com.example.aad_playground.ut03.ex04.domain

interface ModelRepository {
    fun saveCustomerList(modelList: List<CustomerModel>)
    fun saveCustomerModel(model: CustomerModel)
    fun fetchAllCustomers(): List<CustomerModel>
    fun fetchCustomerById(id: Int): CustomerModel
}