package com.example.aad_playground.ut03.ex04.presentation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.aad_playground.R
import com.example.aad_playground.ut03.ex04.data.CustomerLocalRepository
import com.example.aad_playground.ut03.ex04.data.CustomerLocalSource
import com.example.aad_playground.ut03.ex04.data.InvoiceLocalRepository
import com.example.aad_playground.ut03.ex04.data.InvoiceLocalSource
import com.example.aad_playground.ut03.ex04.domain.*
import java.time.LocalDate

class Ut03Ex04Activity : AppCompatActivity() {

    private lateinit var viewModel: Ut03Ex04ViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex04)
        viewModel = Ut03Ex04ViewModel(
            FetchAllCustomersUseCase(CustomerLocalRepository(CustomerLocalSource(this.applicationContext))),
            FetchCustomerByIdUseCase(CustomerLocalRepository(CustomerLocalSource(this.applicationContext))),
            SaveCustomerUseCase(CustomerLocalRepository(CustomerLocalSource(this.applicationContext))),
            FetchAllInvoiceUseCase(InvoiceLocalRepository(InvoiceLocalSource(this.applicationContext))),
            FetchInvoiceByIdUseCase(InvoiceLocalRepository(InvoiceLocalSource(this.applicationContext))),
            SaveInvoiceUseCase(InvoiceLocalRepository(InvoiceLocalSource(this.applicationContext)))
        )
        customers.forEach { model ->
            viewModel.saveCustomer(model)
        }
        viewModel.fetchAllCustomers()

        invoices.forEach { model->
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