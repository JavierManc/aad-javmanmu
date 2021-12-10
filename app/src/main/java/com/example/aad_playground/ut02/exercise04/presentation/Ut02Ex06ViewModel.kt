package com.example.aad_playground.ut02.exercise04.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aad_playground.ut02.exercise04.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut02Ex06ViewModel(
    private val getCustomersUseCase: GetCustomersUseCase,
    private val getCustomerByIdUseCase: GetCustomerByIdUseCase,
    private val deleteCustomerUseCase: DeleteCustomerUseCase,
    private val saveCustomerUseCase: SaveCustomerUseCase,
    private val saveCustomersUseCase: SaveCustomersUseCase,

    private val getInvoicesUseCase: GetInvoicesUseCase,
    private val getInvoiceByIdUseCase: GetInvoiceByIdUseCase,
    private val deleteInvoiceUseCase: DeleteInvoiceUseCase,
    private val saveInvoicesUseCase: SaveInvoicesUseCase,
    private val saveInvoiceUseCase: SaveInvoiceUseCase
) : ViewModel() {

    /**
     * Funciones para los customer
     */

    fun saveCustomerList(modelList: List<CustomerModel>) {
        viewModelScope.launch(Dispatchers.IO) {
            saveCustomersUseCase.execute(modelList)
        }
    }

    fun saveCustomer(model: CustomerModel) {
        viewModelScope.launch(Dispatchers.IO) {
            saveCustomerUseCase.execute(model)
        }
    }

    fun getCustomers(): List<CustomerModel> {
        var customers: List<CustomerModel> = mutableListOf()
        viewModelScope.launch(Dispatchers.IO) {
            customers = getCustomersUseCase.execute()
        }
        return customers
    }

    fun getCustomer(modelId: Int): CustomerModel? {
        var customer: CustomerModel? = null
        viewModelScope.launch(Dispatchers.IO) {
            customer = getCustomerByIdUseCase.execute(modelId)
        }
        return customer
    }

    fun removeCustomer(modelId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteCustomerUseCase.execute(modelId)
        }
    }

    fun showCustomerList(list: List<CustomerModel>) {
        viewModelScope.launch(Dispatchers.Main) {
            list.forEach { element ->
                Log.d("Costumers", element.toString())
            }

        }
    }

    fun showCustomers(model: CustomerModel) {
        viewModelScope.launch(Dispatchers.Main) {
            Log.d("Customer", model.toString())
        }
    }


    /**
     * Funciones para las invoice
     */

    fun saveInvoiceList(modelList: List<InvoiceModel>) {
        viewModelScope.launch(Dispatchers.IO) {
            saveInvoicesUseCase.execute(modelList)
        }
    }

    fun saveInvoice(model: InvoiceModel) {
        viewModelScope.launch(Dispatchers.IO) {
            saveInvoiceUseCase.execute(model)
        }
    }

    fun getInvoices(): List<InvoiceModel> {
        var invoices: List<InvoiceModel> = mutableListOf()
        viewModelScope.launch(Dispatchers.IO) {
            invoices = getInvoicesUseCase.execute()
        }
        return invoices
    }

    fun getInvoice(modelId: Int): InvoiceModel? {
        var invoice: InvoiceModel? = null
        viewModelScope.launch(Dispatchers.IO) {
            invoice = getInvoiceByIdUseCase.execute(modelId)
        }
        return invoice
    }

    fun removeInvoice(modelId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteInvoiceUseCase.execute(modelId)
        }
    }

    fun showInvoicesList(list: List<InvoiceModel>) {
        viewModelScope.launch(Dispatchers.Main) {
            list.forEach { element ->
                Log.d("Invoices", element.toString())
            }

        }
    }

    fun showModel(model: InvoiceModel) {
        viewModelScope.launch(Dispatchers.Main) {
            Log.d("Invoice", model.toString())
        }
    }
}