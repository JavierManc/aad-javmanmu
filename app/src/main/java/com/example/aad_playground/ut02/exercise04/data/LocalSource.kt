package com.example.aad_playground.ut02.exercise04.data

import com.example.aad_playground.ut02.exercise04.domain.Models

interface LocalSource {
    fun save(model: Models)
    fun save(modelList: List<Models>)
    fun remove(modelId: Int)
    fun fetch(): List<Models>
    fun fetchById(modelId: Int): Models?
}