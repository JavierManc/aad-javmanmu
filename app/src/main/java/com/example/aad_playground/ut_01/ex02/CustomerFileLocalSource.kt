package com.example.aad_playground.ut_01.ex02

import android.content.Context
import com.example.aad_playground.ut_01.ex02.serializer.JsonSerializer
import java.io.File

/**
 * Clase para persistir información en ficheros.
 */
class CustomerFileLocalSource(
    private val gson: JsonSerializer,
    private val context: Context
) {

    private val customersFile: File by lazy {
        buildFile()
    }

    /**
     * Función que me permite guardar un cliente en un fichero.
     */
    fun save(customer: CustomerModel) {
        val customerList = fetch().toMutableList()
        customerList.add(customer)
        save(customerList)
    }

    /**
     * Función que me permite guardar un listado de clientes en un fichero.
     */
    fun save(customers: List<CustomerModel>) {
        //Borra todos los clientes antes de guardar la lista
        customersFile.writeText("")
        customers.map { model ->
            customersFile.appendText(
                gson.toJson(
                    model,
                    CustomerModel::class.java
                ) + System.lineSeparator()
            )
        }
    }

    /**
     * Función que me permite modificar los datos de un cliente que se encuentran en un fichero.
     * Se puede modificar cualquier dato excepto el id del cliente.
     */
    fun update(customer: CustomerModel) {
        val customerList = fetch().toMutableList()
        var i = 0
        while (i < customerList.size) {
            if (customerList[i].id == customer.id) {
                customerList[i] = customer
            }
            i++
        }
        save(customerList)
    }

    /**
     * Función que me permite eliminar un cliente de un fichero.
     */
    fun remove(customerId: Int) {
        val customerList = fetch().toMutableList()
        var i = 0
        while (i < customerList.size) {
            if (customerList[i].id == customerId) {
                customerList.remove(customerList[i])
            }
            i++
        }
        save(customerList)
    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un fichero.
     */
    fun fetch(): List<CustomerModel> {
        val customers: MutableList<CustomerModel> = mutableListOf()
        val lines = customersFile.readLines()
        lines.map { model ->
            val customerModel = gson.fromJson(model, CustomerModel::class.java)
            customers.add(customerModel)
        }
        return customers
    }

    fun findById(customerId: Int): CustomerModel {
        val customerList = fetch()
        var customer = CustomerModel(0, "", "")
        customerList.forEach { entity ->
            if (entity.id == customerId) {
                customer = entity
            }
        }
        return customer
    }

    fun deleteFile() {
        customersFile.delete()
    }

    private fun buildFile(): File {
        val file = File(context.filesDir, CUSTOMER_FILENAME)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    companion object {
        const val CUSTOMER_FILENAME: String = "aad_ut01_ex02_customer.txt"
    }

}