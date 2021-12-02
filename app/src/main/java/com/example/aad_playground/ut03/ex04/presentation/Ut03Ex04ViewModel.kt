package com.example.aad_playground.ut03.ex04.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aad_playground.ut03.ex04.domain.*
import com.example.aad_playground.ut03.ex04.domain.customer_use_case.FetchAllCustomersUseCase
import com.example.aad_playground.ut03.ex04.domain.customer_use_case.FetchCustomerByIdUseCase
import com.example.aad_playground.ut03.ex04.domain.customer_use_case.SaveCustomerUseCase
import com.example.aad_playground.ut03.ex04.domain.invoice_use_case.FetchAllInvoiceUseCase
import com.example.aad_playground.ut03.ex04.domain.invoice_use_case.FetchInvoiceByIdUseCase
import com.example.aad_playground.ut03.ex04.domain.invoice_use_case.SaveInvoiceUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex04ViewModel(
    private val fetchAllCustomersUseCase: FetchAllCustomersUseCase,
    private val fetchCustomerByIdUseCase: FetchCustomerByIdUseCase,
    private val saveCustomerUseCase: SaveCustomerUseCase,
    private val fetchAllInvoiceUseCase: FetchAllInvoiceUseCase,
    private val fetchInvoiceByIdUseCase: FetchInvoiceByIdUseCase,
    private val saveInvoiceUseCase: SaveInvoiceUseCase
) : ViewModel() {

    fun fetchAllCustomers() {
        viewModelScope.launch(Dispatchers.IO) {
            val customers = fetchAllCustomersUseCase.execute()
            customers.forEach { model ->
                Log.d("Customer", model.toString())
            }
        }

    }

    fun fetchCustomerById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val customer = fetchCustomerByIdUseCase.execute(id)
            Log.d("Customer", customer.toString())
        }
    }

    fun saveCustomer(customer: CustomerModel) {
        viewModelScope.launch(Dispatchers.IO) {
            saveCustomerUseCase.execute(customer)
        }
    }

    fun fetchAllInvoice() {
        viewModelScope.launch(Dispatchers.IO) {
            val invoices = fetchAllInvoiceUseCase.execute()
            invoices.forEach { model ->
                Log.d("Invoice", model.toString())
            }
        }
    }

    fun fetchInvoiceById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val invoice = fetchInvoiceByIdUseCase.execute(id)
            Log.d("Invoice", invoice.toString())
        }
    }

    fun saveInvoice(invoice: InvoiceModel) {
        viewModelScope.launch(Dispatchers.IO) {
            saveInvoiceUseCase.execute(invoice)
        }
    }
}