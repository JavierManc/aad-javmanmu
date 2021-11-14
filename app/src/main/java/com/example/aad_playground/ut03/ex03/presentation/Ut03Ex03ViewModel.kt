package com.example.aad_playground.ut03.ex03.presentation

import androidx.lifecycle.ViewModel
import com.example.aad_playground.ut03.ex03.domain.FindAlertUseCase
import com.example.aad_playground.ut03.ex03.domain.GetAlertsUseCase

class Ut03Ex03ViewModel(private val getAlertsUseCase: GetAlertsUseCase,
                        private val findAlertUseCase: FindAlertUseCase) : ViewModel() {

    fun getAlerts() = getAlertsUseCase.execute()

    fun findAlert(alertId: String) = findAlertUseCase.execute(alertId)
}