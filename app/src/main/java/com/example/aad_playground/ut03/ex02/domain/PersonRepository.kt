package com.example.aad_playground.ut03.ex02.domain

interface PersonRepository {
    fun savePerson(personModel: PersonModel)
    suspend fun fetchAll(): List<PersonModel>
}