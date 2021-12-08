package com.example.aad_playground.ut03.ex04.data

import com.example.aad_playground.ut03.ex04.domain.InvoiceModel
import com.example.aad_playground.ut03.ex04.domain.InvoiceRepository

class InvoiceDataRepository(private val invoiceLocalSource: InvoiceLocalSource) :
    InvoiceRepository {

    override fun saveInvoiceList(modelList: List<InvoiceModel>) {
        modelList.forEach { model ->
            saveInvoiceModel(model)
        }
    }

    override fun saveInvoiceModel(model: InvoiceModel) {
        invoiceLocalSource.saveInvoice(model)
    }

    override fun fetchAllInvoice(): List<InvoiceModel> {
        return invoiceLocalSource.fetchAll()
    }

    override fun fetchInvoiceById(id: Int): InvoiceModel {
        return invoiceLocalSource.fetchById(id)
    }

}