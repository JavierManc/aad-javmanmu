package com.example.aad_playground.ut03.ex06.presentation

import com.example.aad_playground.ut03.ex06.domain.TapaModel

data class TapasViewState(val isLoading: Boolean,
                          val tapaModels: List<TapaModel>?,
                          val failure: Throwable?)

data class TapaViewState(val isLoading: Boolean,
                         val tapaModels: TapaModel?,
                         val failure: Throwable?)