package com.example.aad_playground.ut02.exercise04.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aad_playground.databinding.ActivityUt02Ex04Binding
import com.example.aad_playground.ut02.exercise04.data.CustomerSharPrefLocalSource
import com.example.aad_playground.ut02.exercise04.data.InvoiceSharPrefLocalSource
import com.example.aad_playground.ut02.exercise04.data.CustomerDataRepository
import com.example.aad_playground.ut02.exercise04.data.InvoiceDataRepository
import com.example.aad_playground.ut02.exercise04.domain.*
import com.example.aad_playground.ut02.exercise04.serializer.GsonSerializer
import com.google.gson.Gson
import java.util.*

class Ut02Ex04Activity : AppCompatActivity() {

    private val bind: ActivityUt02Ex04Binding by lazy {
        ActivityUt02Ex04Binding.inflate(layoutInflater)
    }

    private lateinit var viewModel: Ut02Ex06ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        actionButtons()
    }

    private fun setupView() {
        setContentView(bind.root)
        viewModel =
            Ut02Ex06ViewModel(
                GetCustomersUseCase(
                    CustomerDataRepository(
                        CustomerSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                ),
                GetCustomerByIdUseCase(
                    CustomerDataRepository(
                        CustomerSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                ),
                DeleteCustomerUseCase(
                    CustomerDataRepository(
                        CustomerSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                ),
                SaveCustomerUseCase(
                    CustomerDataRepository(
                        CustomerSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                ),
                SaveCustomersUseCase(
                    CustomerDataRepository(
                        CustomerSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                ),
                GetInvoicesUseCase(
                    InvoiceDataRepository(
                        InvoiceSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                ),
                GetInvoiceByIdUseCase(
                    InvoiceDataRepository(
                        InvoiceSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                ),
                DeleteInvoiceUseCase(
                    InvoiceDataRepository(
                        InvoiceSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                ),
                SaveInvoicesUseCase(
                    InvoiceDataRepository(
                        InvoiceSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                ),
                SaveInvoiceUseCase(
                    InvoiceDataRepository(
                        InvoiceSharPrefLocalSource(
                            this,
                            GsonSerializer(Gson())
                        )
                    )
                )
            )

    }

    private fun actionButtons() {
        bind.saveCustomers.setOnClickListener {
            viewModel.saveCustomerList(customers)
        }
        bind.findCustomer1.setOnClickListener {
            viewModel.saveCustomer(customers[1])
        }
        bind.getCustomers.setOnClickListener {
            viewModel.showCustomerList(viewModel.getCustomers())
        }
        bind.deleteCustomer.setOnClickListener {
            viewModel.removeCustomer(1)
        }

        bind.saveInvoice.setOnClickListener {
            viewModel.saveInvoice(invoice)
        }
        bind.getInvoices.setOnClickListener {
            viewModel.saveInvoiceList(viewModel.getInvoices())
        }
        bind.findInvoice1.setOnClickListener {
            viewModel.getInvoice(1)
        }
        bind.deleteInvoice.setOnClickListener {
            viewModel.removeInvoice(1)
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
        Date(),
        viewModel.getCustomer(1) as CustomerModel,
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