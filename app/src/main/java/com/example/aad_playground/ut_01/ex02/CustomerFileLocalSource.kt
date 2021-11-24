package com.example.aad_playground.ut_01.ex02

import com.example.aad_playground.ut_01.ex02.serializer.JsonSerializer
import java.io.File

/**
 * Clase para persistir información en ficheros.
 */
class CustomerFileLocalSource(
    private val gson: JsonSerializer,
    private val file: File
) {


    /**
     * Función que me permite guardar un cliente en un fichero.
     */
    fun save(customer: CustomerModel) {
        file.appendText(gson.toJson(customer, CustomerModel::class.java) + System.lineSeparator())
    }

    /**
     * Función que me permite guardar un listado de clientes en un fichero.
     */
    fun save(customers: List<CustomerModel>) {
        if (file.exists()) {
            deleteFile()
        }
        customers.forEach { customer ->
            save(customer)
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
        return if (file.exists()) {
            file.readLines().map { entity ->
                gson.fromJson(entity, CustomerModel::class.java)
            }
        } else {
            return emptyList()
        }


    }

    fun findById(customerId: Int): CustomerModel {
        val customerList = fetch()
        var customer: CustomerModel = CustomerModel(0, "", "")
        customerList.forEach { entity ->
            if (entity.id == customerId) {
                customer = entity
            }
        }
        return customer
    }

    fun deleteFile() {
        if (file.exists()) {
            file.delete()
        }
    }
}