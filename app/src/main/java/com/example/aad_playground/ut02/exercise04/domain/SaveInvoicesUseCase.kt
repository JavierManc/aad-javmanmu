package com.example.aad_playground.ut02.exercise04.domain

class SaveInvoicesUseCase(private val invoiceRepository: InvoiceRepository) {
    fun execute(modelList: List<InvoiceModel>) {
        invoiceRepository.save(modelList)
    }
}