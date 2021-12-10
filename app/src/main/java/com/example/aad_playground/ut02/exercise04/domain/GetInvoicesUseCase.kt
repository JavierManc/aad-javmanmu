package com.example.aad_playground.ut02.exercise04.domain

class GetInvoicesUseCase(private val invoiceRepository: InvoiceRepository) {
    fun execute(): Result<List<InvoiceModel>> {
        return invoiceRepository.fetch()
    }
}