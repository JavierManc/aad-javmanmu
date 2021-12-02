package com.example.aad_playground.ut03.ex04.domain.invoice_use_case

import com.example.aad_playground.ut03.ex04.domain.InvoiceModel
import com.example.aad_playground.ut03.ex04.domain.InvoiceRepository

class FetchInvoiceByIdUseCase(private val invoiceRepository: InvoiceRepository) {

    fun execute(id: Int): InvoiceModel {
        return invoiceRepository.fetchInvoiceById(id)
    }
}
