package com.example.aad_playground.ut02.exercise04.domain

class SaveInvoiceUseCase(private val invoiceRepository: InvoiceRepository) {
    fun execute(model : InvoiceModel){
        invoiceRepository.save(model)
    }
}