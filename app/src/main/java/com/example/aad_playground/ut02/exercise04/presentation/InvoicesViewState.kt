package com.example.aad_playground.ut02.exercise04.presentation

import com.example.aad_playground.ut02.exercise04.domain.InvoiceModel

data class InvoicesViewState(
    val invoices: List<InvoiceModel>?,
    val failure: Throwable?
)

data class InvoiceViewState(
    val invoice: InvoiceModel?,
    val failure: Throwable?
)