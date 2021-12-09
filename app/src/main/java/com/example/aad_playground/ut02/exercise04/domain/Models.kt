package com.example.aad_playground.ut02.exercise04.domain

import java.util.*

interface Models {
    fun getId(): Int
}

data class CustomerModel(val customerId: Int, val name: String, val surname: String) :
    Models {
    override fun getId(): Int = customerId
}

data class ProductModel(
    val productId: Int,
    val name: String,
    val model: String,
    val price: Double
)

data class InvoiceLinesModel(val id: Int, val product: ProductModel)

data class InvoiceModel(
    val invoiceId: Int,
    val date: Date,
    val customerModel: CustomerModel,
    val invoiceLinesModel: List<InvoiceLinesModel>
) : Models {
    override fun getId(): Int = invoiceId
}