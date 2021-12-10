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
        saveCustomersUseCase.execute(modelList)
    }

    fun saveCustomer(model: CustomerModel) {
        saveCustomerUseCase.execute(model)
    }

    fun getCustomers(): List<CustomerModel> {
        return getCustomersUseCase.execute()
    }

    fun getCustomer(modelId: Int): CustomerModel? {
        return getCustomerByIdUseCase.execute(modelId)
    }

    fun removeCustomer(modelId: Int) {
        deleteCustomerUseCase.execute(modelId)
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
        saveInvoicesUseCase.execute(modelList)
    }

    fun saveInvoice(model: InvoiceModel) {
        saveInvoiceUseCase.execute(model)
    }

    fun getInvoices(): List<InvoiceModel> {
        return getInvoicesUseCase.execute()
    }

    fun getInvoice(modelId: Int): InvoiceModel? {
        return getInvoiceByIdUseCase.execute(modelId)
    }

    fun removeInvoice(modelId: Int) {
        deleteInvoiceUseCase.execute(modelId)
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