package com.example.aad_playground.ut_01.ex02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aad_playground.R
import com.example.aad_playground.ut_01.ex02.serializer.GsonSerializer
import com.google.gson.Gson
import java.io.File

class Ut01Ex02Activity : AppCompatActivity() {

    private lateinit var customerFileLocalSource: CustomerFileLocalSource
    private lateinit var customersFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex02)
        customersFile = File(this.filesDir, "customers.txt")
        customerFileLocalSource = CustomerFileLocalSource(GsonSerializer(Gson()), customersFile)

        customerPlayGround()
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
        customerFileLocalSource.save(customers)
        showCustomers(customerFileLocalSource.fetch())
        customerFileLocalSource.update(CustomerModel(1, "Name01", "Surname01"))
        showCustomer(customerFileLocalSource.findById(1))
        customerFileLocalSource.remove(3)
        showCustomers(customerFileLocalSource.fetch())
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


}