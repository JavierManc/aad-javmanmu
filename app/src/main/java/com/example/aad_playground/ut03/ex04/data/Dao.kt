package com.example.aad_playground.ut03.ex04.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CustomerDao {

    @Query("SELECT * FROM customers")
    fun findAllCustomers(): List<CustomerEntity>

    @Query("SELECT * FROM customers WHERE id= :id LIMIT 1")
    fun findCustomerByID(id: Int): CustomerEntity

    @Insert
    fun saveCustomer(customer: CustomerEntity)

}

@Dao
interface InvoiceDao {

    @Query("SELECT * FROM invoice")
    fun findAllInvoice(): List<InvoiceLinesWithCustomer>

    @Query("SELECT * FROM invoice WHERE id= :id LIMIT 1")
    fun findInvoiceById(id: Int): InvoiceLinesWithCustomer

    @Insert
    fun saveInvoice(
        invoice: InvoiceEntity,
        customer: CustomerEntity,
        invoiceLinesEntity: List<InvoiceLinesEntity>
    )
}

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun findAllProduct(): List<ProductEntity>

    @Query("SELECT * FROM product WHERE id= :id LIMIT 1")
    fun findProductById(id: Int): ProductEntity

    @Insert
    fun saveProduct(productEntity: ProductEntity)
}