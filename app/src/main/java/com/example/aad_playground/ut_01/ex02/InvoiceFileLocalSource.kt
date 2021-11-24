package com.example.aad_playground.ut_01.ex02

import com.example.aad_playground.ut_01.ex02.serializer.JsonSerializer
import java.io.File
import java.util.*

/**
 * Clase para persistir información en ficheros.
 */
class InvoiceFileLocalSource(
    private val gson: JsonSerializer,
    private val file: File
) {

    /**
     * Función que me permite guardar un cliente en un fichero.
     */
    fun save(invoice: InvoiceModel) {
        file.writeText(gson.toJson(invoice, InvoiceModel::class.java) + System.lineSeparator())
    }

    /**
     * Función que me permite eliminar un cliente de un fichero.
     */
    fun remove() {
        deleteFile()
    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un fichero.
     */
    fun fetch(): List<InvoiceModel> {
        return if (file.exists()) {
            file.readLines().map { entity ->
                gson.fromJson(entity, InvoiceModel::class.java)
            }
        } else {
            return emptyList()
        }
    }

    fun findById(invoiceId: Int): InvoiceModel {
        val invoiceList = fetch()
        var invoice =
            InvoiceModel(0, Date("24/11/21"), CustomerModel(1, "", ""), emptyList())
        invoiceList.forEach { entity ->
            if (entity.id == invoiceId) {
                invoice = entity
            }
        }
        return invoice
    }

    fun deleteFile() {
        if (file.exists()) {
            file.delete()
        }
    }
}