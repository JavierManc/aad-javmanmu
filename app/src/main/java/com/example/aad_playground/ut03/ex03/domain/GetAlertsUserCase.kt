package com.example.aad_playground.ut03.ex03.domain

class GetAlertsUseCase(private val repository: AlertRepository) {
    fun execute(): List<AlertModel> = repository.fetchAll()
}