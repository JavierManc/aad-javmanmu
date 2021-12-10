package com.example.aad_playground.ut02.exercise04.domain

interface InvoiceRepository {
    fun save(model: InvoiceModel)
    fun save(modelList: List<InvoiceModel>)
    fun remove(modelId: Int)
    fun fetch(): List<InvoiceModel>
    fun fetchById(modelId: Int): InvoiceModel?
}