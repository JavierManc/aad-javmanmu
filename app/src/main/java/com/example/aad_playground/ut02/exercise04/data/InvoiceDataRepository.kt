package com.example.aad_playground.ut02.exercise04.data

import com.example.aad_playground.ut02.exercise04.domain.InvoiceModel
import com.example.aad_playground.ut02.exercise04.domain.InvoiceRepository

class InvoiceDataRepository(private val invoiceLocalSource: InvoiceLocalSource) :
    InvoiceRepository {
    override fun save(model: InvoiceModel) {
        invoiceLocalSource.save(model)
    }

    override fun save(modelList: List<InvoiceModel>) {
        invoiceLocalSource.save(modelList)
    }

    override fun remove(modelId: Int) {
        invoiceLocalSource.remove(modelId)
    }

    override fun fetch(): Result<List<InvoiceModel>> {
        return invoiceLocalSource.fetch()
    }

    override fun fetchById(modelId: Int): Result<InvoiceModel?> {
        return invoiceLocalSource.fetchById(modelId)
    }

}