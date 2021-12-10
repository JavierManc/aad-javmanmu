package com.example.aad_playground.ut_01.ex02

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.aad_playground.R
import com.example.aad_playground.ut_01.ex02.serializer.GsonSerializer
import com.google.gson.Gson
import java.util.*

class Ut01Ex02Activity : AppCompatActivity() {

    private lateinit var customerFileLocalSource: CustomerFileLocalSource
    private lateinit var invoiceFileLocalSource: InvoiceFileLocalSource


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex02)

        customerPlayGround()
        invoicePlayGround()
    }

    private val customers = mutableListOf<CustomerModel>(
        CustomerModel(
            1,
            "Name1",
            "Surname1"
        ),
        CustomerModel(
            2,
            "Name2",
            "Surname2"
        ),
        CustomerModel(
            3,
            "Name3",
            "Surname3"
        ),
        CustomerModel(
            4,
            "Name4",
            "Surname4"
        ),
        CustomerModel(
            5,
            "Name5",
            "Surname5"
        )
    )

    private fun customerPlayGround() {
        customerFileLocalSource =
            CustomerFileLocalSource(GsonSerializer(Gson()), applicationContext)

        customerFileLocalSource.save(customers)
        showCustomers(customerFileLocalSource.fetch())
        customerFileLocalSource.update(CustomerModel(1, "Name01", "Surname01"))
        showCustomer(customerFileLocalSource.findById(1))
        customerFileLocalSource.remove(3)
        showCustomers(customerFileLocalSource.fetch())
        customerFileLocalSource.deleteFile()
    }

    private fun showCustomer(customer: CustomerModel) {
        Thread {
            runOnUiThread {
                Log.d("@dev", customer.toString())
            }
        }.start()
    }

    private fun showCustomers(customers: List<CustomerModel>) {
        customers.forEach { entity ->
            showCustomer(entity)
        }
    }

    private fun invoicePlayGround() {
        val customer = customerFileLocalSource.findById(1)
        invoiceFileLocalSource = InvoiceFileLocalSource(GsonSerializer(Gson()), applicationContext)

        invoiceFileLocalSource.save(invoice)
        showInvoice(invoiceFileLocalSource.fetch().first())
        showInvoice(invoiceFileLocalSource.findById(1))
        invoiceFileLocalSource.remove(1)
    }

    private val invoice: InvoiceModel = InvoiceModel(
        1,
        Date("24/11/21"),
        customerFileLocalSource.findById(1),
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

    private fun showInvoice(invoice: InvoiceModel) {
        Thread {
            runOnUiThread {
                Log.d("@dev", invoice.toString())
            }
        }.start()
    }

}