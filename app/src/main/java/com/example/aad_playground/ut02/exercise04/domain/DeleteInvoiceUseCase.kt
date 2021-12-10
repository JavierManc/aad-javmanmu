package com.example.aad_playground.ut02.exercise04.domain

class DeleteInvoiceUseCase(private val invoiceRepository: InvoiceRepository) {
    fun execute(modelId: Int) {
        invoiceRepository.remove(modelId)
    }
}