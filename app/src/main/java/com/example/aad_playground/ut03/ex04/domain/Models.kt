package com.example.aad_playground.ut03.ex04.domain

import java.time.LocalDate

data class CustomerModel(val id: Int, val name: String, val surname: String)

data class ProductModel(val id: Int, val name: String, val model: String, val price: Double)
data class InvoiceLinesModel(val id: Int, val product: ProductModel)
data class InvoiceModel(
    val id: Int,
    val date: LocalDate,
    val customerModel: CustomerModel,
    val invoiceLinesModel: List<InvoiceLinesModel>
)