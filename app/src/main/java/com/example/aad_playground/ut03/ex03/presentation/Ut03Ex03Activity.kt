package com.example.aad_playground.ut03.ex03.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.aad_playground.R
import com.example.aad_playground.ut03.ex03.app.RetrofitApiClient
import com.example.aad_playground.ut03.ex03.data.AlertDataRepository
import com.example.aad_playground.ut03.ex03.data.remote.AlertRemoteSource
import com.example.aad_playground.ut03.ex03.domain.AlertRepository

class Ut03Ex03Activity : AppCompatActivity() {

    private val TAG = Ut03Ex03Activity::class.java.simpleName

    private val viewModel: Ut03Ex03ViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex03)
    }

    private fun getAllAlerts() {
        val alerts = viewModel.getAlerts()
    }

    private fun getAlertById() {
        val alertId = ""
        val alerts = viewModel.findAlert(alertId)
    }
}