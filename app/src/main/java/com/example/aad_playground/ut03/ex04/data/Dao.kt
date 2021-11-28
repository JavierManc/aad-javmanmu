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

    @Insert
    fun saveCustomerList(customers: List<CustomerEntity>)

}