package com.example.aad_playground.ut02.exercise04.domain

class GetInvoiceByIdUseCase(private val invoiceRepository: InvoiceRepository) {
    fun execute(modelId: Int): Result<InvoiceModel?> {
        return invoiceRepository.fetchById(modelId)
    }
}