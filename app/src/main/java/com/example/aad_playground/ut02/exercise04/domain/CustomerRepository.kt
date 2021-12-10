package com.example.aad_playground.ut02.exercise04.domain

interface CustomerRepository {
    fun save(model: CustomerModel)
    fun save(modelList: List<CustomerModel>)
    fun remove(modelId: Int)
    fun fetch(): List<CustomerModel>
    fun fetchById(modelId: Int): CustomerModel?
}