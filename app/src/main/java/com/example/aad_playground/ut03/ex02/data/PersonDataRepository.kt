package com.example.aad_playground.ut03.ex02.data

import com.example.aad_playground.ut03.ex02.domain.PersonModel
import com.example.aad_playground.ut03.ex02.domain.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataRepository(private val personLocalSource: PersonLocalSource) : PersonRepository {
    override fun savePerson(personModel: PersonModel) {
        personLocalSource.save(personModel)
    }

    override suspend fun fetchAll(): List<PersonModel> = withContext(Dispatchers.IO){
        personLocalSource.findPersonAndPetAndCarAndJob()
    }


}