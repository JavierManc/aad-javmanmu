package com.example.aad_playground.ut02.exercise04.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aad_playground.ut02.exercise04.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

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

    fun getCustomers(): CustomersViewState {
        var viewState = CustomersViewState(mutableListOf(), null)
        viewModelScope.launch(Dispatchers.IO) {
            val result = getCustomersUseCase.execute()
            viewState = CustomersViewState(result.getOrNull(), result.exceptionOrNull())
        }
        return viewState
    }

    fun getCustomer(modelId: Int): CustomerViewState {
        var customer = CustomerViewState(CustomerModel(0, "", ""), null)
        viewModelScope.launch(Dispatchers.IO) {
            val result = getCustomerByIdUseCase.execute(modelId)
            customer = CustomerViewState(result.getOrNull(), result.exceptionOrNull())
        }
        return customer
    }

    fun removeCustomer(modelId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteCustomerUseCase.execute(modelId)
        }
    }

    fun showCustomerList(customer: CustomersViewState) {
        viewModelScope.launch(Dispatchers.Main) {
            customer.customers?.forEach { element ->
                Log.d("Costumers", element.toString())
            }

        }
    }

    fun showCustomers(model: CustomerViewState) {
        viewModelScope.launch(Dispatchers.Main) {
            Log.d("Customer", model.customer.toString())
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

    fun getInvoices(): InvoicesViewState {
        var invoices = InvoicesViewState(mutableListOf(), null)
        viewModelScope.launch(Dispatchers.IO) {
            val result = getInvoicesUseCase.execute()
            invoices = InvoicesViewState(result.getOrNull(), result.exceptionOrNull())
        }
        return invoices
    }

    fun getInvoice(modelId: Int): InvoiceViewState {
        var invoice =
            InvoiceViewState(
                InvoiceModel(0, Date(), CustomerModel(0, "", ""), mutableListOf()),
                null
            )
        viewModelScope.launch(Dispatchers.IO) {
            val result = getInvoiceByIdUseCase.execute(modelId)
            invoice = InvoiceViewState(result.getOrNull(), result.exceptionOrNull())
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