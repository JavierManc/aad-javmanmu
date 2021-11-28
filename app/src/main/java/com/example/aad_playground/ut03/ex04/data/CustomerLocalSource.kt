package com.example.aad_playground.ut03.ex04.data

import android.content.Context
import com.example.aad_playground.ut03.ex04.app.Ut03Ex04DataBase
import com.example.aad_playground.ut03.ex04.domain.CustomerModel

class CustomerLocalSource(aplicationContext: Context) {

    private val db = Ut03Ex04DataBase.getInstance(aplicationContext)

    fun findAll(): List<CustomerModel> {
        return db.customerDao().findAllCustomers().map { entity -> entity.toModel() }
    }

    fun findById(id: Int): CustomerModel {
        return db.customerDao().findCustomerByID(id).toModel()
    }

    fun saveCustomer(customerModel: CustomerModel) {
        db.customerDao().saveCustomer(CustomerEntity.toEntity(customerModel))
    }

    fun saveCustomerList(customerList: List<CustomerModel>) {
        db.customerDao()
            .saveCustomerList(
                customerList.map { model ->
                    CustomerEntity.toEntity(model)
                }
            )
    }
}