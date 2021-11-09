package com.example.aad_playground.ut03.ex02.domain

data class PersonModel(
    val id: Int,
    val name: String,
    val age: Int,
    val address: String?
)

data class PetModel(val id: Int, val name: String, val age: Int)