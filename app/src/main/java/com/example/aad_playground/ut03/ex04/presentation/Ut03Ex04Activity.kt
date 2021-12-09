package com.example.aad_playground.ut03.ex04.presentation

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.aad_playground.R
import com.example.aad_playground.ut03.ex04.data.CustomerDataRepository
import com.example.aad_playground.ut03.ex04.data.CustomerLocalSource
import com.example.aad_playground.ut03.ex04.data.InvoiceDataRepository
import com.example.aad_playground.ut03.ex04.data.InvoiceLocalSource
import com.example.aad_playground.ut03.ex04.domain.CustomerModel
import com.example.aad_playground.ut03.ex04.domain.InvoiceLinesModel
import com.example.aad_playground.ut03.ex04.domain.InvoiceModel
import com.example.aad_playground.ut03.ex04.domain.ProductModel
import com.example.aad_playground.ut03.ex04.domain.customer_use_case.FetchAllCustomersUseCase
import com.example.aad_playground.ut03.ex04.domain.customer_use_case.FetchCustomerByIdUseCase
import com.example.aad_playground.ut03.ex04.domain.customer_use_case.SaveCustomerUseCase
import com.example.aad_playground.ut03.ex04.domain.invoice_use_case.FetchAllInvoiceUseCase
import com.example.aad_playground.ut03.ex04.domain.invoice_use_case.FetchInvoiceByIdUseCase
import com.example.aad_playground.ut03.ex04.domain.invoice_use_case.SaveInvoiceUseCase
import java.time.LocalDate

class Ut03Ex04Activity : AppCompatActivity() {

    private lateinit var viewModel: Ut03Ex04ViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex04)
        viewModel = Ut03Ex04ViewModel(
            FetchAllCustomersUseCase(CustomerDataRepository(CustomerLocalSource(this.applicationContext))),
            FetchCustomerByIdUseCase(CustomerDataRepository(CustomerLocalSource(this.applicationContext))),
            SaveCustomerUseCase(CustomerDataRepository(CustomerLocalSource(this.applicationContext))),
            FetchAllInvoiceUseCase(InvoiceDataRepository(InvoiceLocalSource(this.applicationContext))),
            FetchInvoiceByIdUseCase(InvoiceDataRepository(InvoiceLocalSource(this.applicationContext))),
            SaveInvoiceUseCase(InvoiceDataRepository(InvoiceLocalSource(this.applicationContext)))
        )
        customers.forEach { model ->
            viewModel.saveCustomer(model)
        }
        viewModel.fetchAllCustomers()

        invoices.forEach { model ->
            viewModel.saveInvoice(model)
        }
        viewModel.fetchAllInvoice()
    }

    private val customers: List<CustomerModel> = mutableListOf(
        CustomerModel(6, "Name1", "Surname1"),
        CustomerModel(7, "Name2", "Surname2"),
        CustomerModel(8, "Name3", "Surname3"),
        CustomerModel(9, "Name4", "Surname4"),
        CustomerModel(10, "Name5", "Surname5"),
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private val invoices: List<InvoiceModel> = mutableListOf(
        InvoiceModel(
            1, LocalDate.now(), CustomerModel(1, "Name1", "Surname1"),
            mutableListOf(
                InvoiceLinesModel(1, ProductModel(1, "Product1", "Model1", 1.1)),
                InvoiceLinesModel(2, ProductModel(2, "Product2", "Model2", 2.2)),
                InvoiceLinesModel(3, ProductModel(3, "Product3", "Model3", 3.3)),
            )
        ),
        InvoiceModel(
            2, LocalDate.now(), CustomerModel(2, "Name2", "Surname2"),
            mutableListOf(
                InvoiceLinesModel(4, ProductModel(4, "Product4", "Model4", 1.1)),
                InvoiceLinesModel(5, ProductModel(5, "Product5", "Model5", 2.2)),
                InvoiceLinesModel(6, ProductModel(6, "Product6", "Model6", 3.3)),
            )
        )
    )
}