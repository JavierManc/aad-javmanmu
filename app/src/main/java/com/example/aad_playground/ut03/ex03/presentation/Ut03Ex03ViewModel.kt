package com.example.aad_playground.ut03.ex03.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aad_playground.ut03.ex03.domain.FindAlertUseCase
import com.example.aad_playground.ut03.ex03.domain.GetAlertsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex03ViewModel(
    private val getAlertsUseCase: GetAlertsUseCase,
    private val findAlertUseCase: FindAlertUseCase
) : ViewModel() {

    private val TAG = Ut03Ex03Activity::class.java.simpleName

    fun getAlerts() {
        viewModelScope.launch(Dispatchers.IO) {
            val alerts = getAlertsUseCase.execute()
            alerts.forEach { element -> Log.d(TAG, element.toString()) }
        }
    }

    fun findAlert(alertId: String) {
        viewModelScope.launch(Dispatchers.IO){
            val alert = findAlertUseCase.execute(alertId)
            Log.d(TAG, alert.toString())
        }
    }
}