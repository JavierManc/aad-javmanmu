package com.example.aad_playground.ut_01.ex02

import android.content.Context
import com.example.aad_playground.ut_01.ex02.serializer.JsonSerializer
import java.io.File
import java.util.*

/**
 * Clase para persistir información en ficheros.
 */
class InvoiceFileLocalSource(
    private val gson: JsonSerializer,
    private val context: Context
) {

    private val invoiceFile: File by lazy {
        buildFile()
    }

    /**
     * Función que me permite guardar un cliente en un fichero.
     */
    fun save(invoice: InvoiceModel) {
        val invoiceList = fetch().toMutableList()
        invoiceList.add(invoice)
        save(invoiceList)
    }

    fun save(invoiceList: MutableList<InvoiceModel>) {
        invoiceFile.writeText("")
        invoiceList.map { model ->
            invoiceFile.appendText(
                gson.toJson(model, InvoiceModel::class.java) + System.lineSeparator()
            )
        }
    }

    /**
     * Función que me permite eliminar un cliente de un fichero.
     */
    fun remove(invoiceId: Int) {
        val invoiceList = fetch().toMutableList()
        var i = 0
        while (i < invoiceList.size) {
            if (invoiceList[i].id == invoiceId) {
                invoiceList.remove(invoiceList[i])
            }
            i++
        }
        save(invoiceList)
    }

    /**
     * Función que me permite obtener un listado de todos los clientes almacenados en un fichero.
     */
    fun fetch(): List<InvoiceModel> {
        val invoices: MutableList<InvoiceModel> = mutableListOf()
        val lines = invoiceFile.readLines()
        lines.map { model ->
            val invoiceModel = gson.fromJson(model, InvoiceModel::class.java)
            invoices.add(invoiceModel)
        }
        return invoices
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
        invoiceFile.delete()
    }

    private fun buildFile(): File {
        val file = File(context.filesDir, INVOICE_FILE)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    companion object {
        const val INVOICE_FILE: String = "aad_ut01_ex02_invoice.txt"
    }
}