package com.example.aad_playground.ut03.ex04.domain

interface CustomerRepository {
    fun saveCustomerList(modelList: List<CustomerModel>)
    fun saveCustomerModel(model: CustomerModel)
    fun fetchAllCustomers(): List<CustomerModel>
    fun fetchCustomerById(id: Int): CustomerModel
}

interface InvoiceRepository {
    fun saveInvoiceList(modelList: List<InvoiceModel>)
    fun saveInvoiceModel(model: InvoiceModel)
    fun fetchAllInvoice(): List<InvoiceModel>
    fun fetchInvoiceById(id: Int): InvoiceModel
}