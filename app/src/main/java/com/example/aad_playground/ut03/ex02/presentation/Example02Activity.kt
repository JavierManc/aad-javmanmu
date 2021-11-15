package com.example.aad_playground.ut03.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aad_playground.R
import com.example.aad_playground.ut03.ex02.data.PersonDataRepository
import com.example.aad_playground.ut03.ex02.data.PersonLocalSource
import com.example.aad_playground.ut03.ex02.domain.*

class Example02Activity : AppCompatActivity() {

    private val TAG = Example02Activity::class.java.simpleName

    private val repository: PersonRepository by lazy {
        PersonDataRepository(PersonLocalSource(applicationContext))
    }

    private lateinit var viewModel: Example02ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example02)
        viewModel = Example02ViewModel()
        executeQuery()
    }

    private fun executeQuery() {
        viewModel.getPeople(repository)
    }
}