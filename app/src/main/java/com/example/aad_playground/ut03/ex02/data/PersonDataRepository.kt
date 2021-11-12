package com.example.aad_playground.ut03.ex02.data

import com.example.aad_playground.ut03.ex02.domain.PersonModel
import com.example.aad_playground.ut03.ex02.domain.PersonRepository

class PersonDataRepository(private val personLocalSource: PersonLocalSource) : PersonRepository {
    override fun savePerson(personModel: PersonModel) {
        personLocalSource.save(personModel)
    }

    override fun fetchAll(): List<PersonModel> = personLocalSource.findAll()

    override fun findPersonAndPet(): List<PersonModel> = personLocalSource.findPersonAndPet()

    override fun findPersonAndPetAndCar(): List<PersonModel> =
        personLocalSource.findPersonAndPetAndCar()

}