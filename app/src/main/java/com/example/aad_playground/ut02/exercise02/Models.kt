package com.example.aad_playground.ut02.exercise02

interface LocalModel {
    fun getId(): Int
}

data class TapaLocalModel(val tapaId: Int, val name: String, val description: String) : LocalModel {
    override fun getId(): Int = tapaId
}