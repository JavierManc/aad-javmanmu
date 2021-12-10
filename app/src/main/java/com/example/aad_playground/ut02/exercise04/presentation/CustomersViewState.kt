package com.example.aad_playground.ut02.exercise04.presentation

import com.example.aad_playground.ut02.exercise04.domain.CustomerModel

data class CustomersViewState(
    val customers: List<CustomerModel>?,
    val failure: Throwable?
)

data class CustomerViewState(
    val customer: CustomerModel?,
    val failure: Throwable?
)