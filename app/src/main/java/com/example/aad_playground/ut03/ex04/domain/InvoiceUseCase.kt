package com.example.aad_playground.ut03.ex04.domain

class FetchAllInvoiceUseCase(private val invoiceRepository: InvoiceRepository) {

    fun execute(): List<InvoiceModel> {
        return invoiceRepository.fetchAllInvoice()
    }
}

class FetchInvoiceByIdUseCase(private val invoiceRepository: InvoiceRepository) {

    fun execute(id: Int): InvoiceModel {
        return invoiceRepository.fetchInvoiceById(id)
    }
}

class SaveInvoiceUseCase(private val invoiceRepository: InvoiceRepository) {

    fun execute(model: InvoiceModel) {
        invoiceRepository.saveInvoiceModel(model)
    }
}