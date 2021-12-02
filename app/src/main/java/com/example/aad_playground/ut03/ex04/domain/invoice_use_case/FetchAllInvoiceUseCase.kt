package com.example.aad_playground.ut03.ex04.domain.invoice_use_case

import com.example.aad_playground.ut03.ex04.domain.InvoiceModel
import com.example.aad_playground.ut03.ex04.domain.InvoiceRepository

class FetchAllInvoiceUseCase(private val invoiceRepository: InvoiceRepository) {

    fun execute(): List<InvoiceModel> {
        return invoiceRepository.fetchAllInvoice()
    }
}