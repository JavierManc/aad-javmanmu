package com.example.aad_playground.ut02.exercise04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aad_playground.databinding.ActivityUt02Ex04Binding
import com.example.aad_playground.ut02.exercise04.serializer.GsonSerializer
import com.google.gson.Gson
import java.util.*

class Ut02Ex04Activity : AppCompatActivity() {

    private val bind: ActivityUt02Ex04Binding by lazy {
        ActivityUt02Ex04Binding.inflate(layoutInflater)
    }

    private lateinit var viewModelCostumer: Ut02Ex06ViewModel
    private lateinit var viewModelInvoice: Ut02Ex06ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        actionButtons()
    }

    private fun setupView() {
        setContentView(bind.root)
        viewModelCostumer =
            Ut02Ex06ViewModel(CustomerSharPrefLocalSource(this, GsonSerializer(Gson())))
        viewModelInvoice =
            Ut02Ex06ViewModel(InvoiceSharPrefLocalSource(this, GsonSerializer(Gson())))
    }

    private fun actionButtons() {
        bind.saveCustomers.setOnClickListener {
            viewModelCostumer.saveModelList(customers)
        }
        bind.findCustomer1.setOnClickListener {
            viewModelCostumer.getModel(1)?.let { it1 -> viewModelCostumer.showModel(it1) }
        }
        bind.getCustomers.setOnClickListener {
            viewModelCostumer.showModelList(viewModelCostumer.getModels())
        }
        bind.deleteCustomer.setOnClickListener {
            viewModelCostumer.removeModel(1)
        }

        bind.saveInvoice.setOnClickListener {
            viewModelInvoice.saveModel(invoice)
        }
        bind.getInvoices.setOnClickListener {
            viewModelInvoice.showModelList(viewModelInvoice.getModels())
        }
        bind.findInvoice1.setOnClickListener {
            viewModelInvoice.getModel(1)?.let { it1 -> viewModelInvoice.showModel(it1) }
        }
        bind.deleteInvoice.setOnClickListener {
            viewModelInvoice.removeModel(1)
        }
    }


    private val customers: List<CustomerModel> = mutableListOf(
        CustomerModel(
            1, "Name1", "Surname1"
        ),
        CustomerModel(
            2, "Name2", "Surname2"
        ),
        CustomerModel(
            3, "Name3", "Surname3"
        ),
        CustomerModel(
            4, "Name4", "Surname4"
        )
    )

    private val invoice: InvoiceModel = InvoiceModel(
        1,
        Date("24/11/21"),
        viewModelCostumer.getModel(1) as CustomerModel,
        mutableListOf(
            InvoiceLinesModel(
                1,
                ProductModel(1, "Product1", "Model1", 10.5)
            ),
            InvoiceLinesModel(
                2,
                ProductModel(2, "Product2", "Model2", 15.5)
            ),
            InvoiceLinesModel(
                3,
                ProductModel(3, "Product3", "Model3", 20.5)
            )
        )
    )
}