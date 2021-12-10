package com.example.aad_playground.ut02.exercise04.data

import com.example.aad_playground.ut02.exercise04.domain.InvoiceModel

interface InvoiceLocalSource {
    fun save(model: InvoiceModel)
    fun save(modelList: List<InvoiceModel>)
    fun remove(modelId: Int)
    fun fetch(): Result<List<InvoiceModel>>
    fun fetchById(modelId: Int): Result<InvoiceModel?>
}