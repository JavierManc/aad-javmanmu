package com.example.aad_playground.ut03.ex04.data

import com.example.aad_playground.ut03.ex04.domain.CustomerModel
import com.example.aad_playground.ut03.ex04.domain.ModelRepository

class LocalRepository(private val customerLocalSource: CustomerLocalSource) : ModelRepository {
    override fun saveCustomerList(modelList: List<CustomerModel>) {
        customerLocalSource.saveCustomerList(modelList)
    }

    override fun saveCustomerModel(model: CustomerModel) {
        customerLocalSource.saveCustomer(model)
    }

    override fun fetchAllCustomers(): List<CustomerModel> {
        return customerLocalSource.findAll()
    }

    override fun fetchCustomerById(id: Int): CustomerModel {
        return customerLocalSource.findById(id)
    }
}