package com.example.aad_playground.ut02.exercise04.data

import com.example.aad_playground.ut02.exercise04.domain.CustomerModel
import com.example.aad_playground.ut02.exercise04.domain.CustomerRepository

class CustomerDataRepository(private val customerLocalSource: CustomerLocalSource) :
    CustomerRepository {
    override fun save(model: CustomerModel) {
        customerLocalSource.save(model)
    }

    override fun save(modelList: List<CustomerModel>) {
        customerLocalSource.save(modelList)
    }

    override fun remove(modelId: Int) {
        customerLocalSource.remove(modelId)
    }

    override fun fetch(): Result<List<CustomerModel>> {
        return customerLocalSource.fetch()
    }

    override fun fetchById(modelId: Int): Result<CustomerModel?> {
        return customerLocalSource.fetchById(modelId)
    }
}