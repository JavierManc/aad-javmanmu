package com.example.aad_playground.ut03.ex02.domain

interface PersonRepository {
    fun savePerson(personModel: PersonModel)
    fun fetchAll(): List<PersonModel>
    fun findPersonAndPet(): List<PersonModel>
    fun findPersonAndPetAndCar(): List<PersonModel>
    fun findPersonAndPetAndCarAndJob(): List<PersonModel>
}