package com.example.aad_playground.ut03.ex03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aad_playground.R
import com.example.aad_playground.ut03.ex03.app.remote.RetrofitApiClient
import com.example.aad_playground.ut03.ex03.data.AlertDataRepository
import com.example.aad_playground.ut03.ex03.data.local.AlertLocalSource
import com.example.aad_playground.ut03.ex03.data.remote.AlertRemoteSource
import com.example.aad_playground.ut03.ex03.domain.FindAlertUseCase
import com.example.aad_playground.ut03.ex03.domain.GetAlertsUseCase

class Ut03Ex03Activity : AppCompatActivity() {

    private lateinit var viewModel: Ut03Ex03ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex03)
        viewModel = Ut03Ex03ViewModel(
            GetAlertsUseCase(
                AlertDataRepository(
                    AlertRemoteSource(RetrofitApiClient()),
                    AlertLocalSource(
                        applicationContext
                    )
                )
            ),
            FindAlertUseCase(
                AlertDataRepository(
                    AlertRemoteSource(RetrofitApiClient()),
                    AlertLocalSource(applicationContext)
                )
            )
        )
        getAllAlerts()
        getAlertById()
    }


    private fun getAllAlerts() {
        viewModel.getAlerts()
    }

    private fun getAlertById() {
        val alertId = "1900673"
        viewModel.findAlert(alertId)
    }
}