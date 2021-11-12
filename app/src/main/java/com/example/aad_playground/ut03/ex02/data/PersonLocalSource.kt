package com.example.aad_playground.ut03.ex02.data

import android.content.Context
import com.example.aad_playground.ut03.ex02.app.Ut03Ex02DataBase
import com.example.aad_playground.ut03.ex02.domain.PersonModel

class PersonLocalSource(aplicationContext: Context) {

    private val db = Ut03Ex02DataBase.getInstance(aplicationContext)

    init {
        //Workaround
        Thread {
            db.clearAllTables()
        }.start()
        Thread.sleep(1000)
    }

    fun findAll(): List<PersonModel> {
        val entities = db.personDao().findAll()
        return entities.map { people -> people.toModel() }
    }

    fun findPersonAndPet(): List<PersonModel> {
        val entities = db.personDao().getPersonAndPets()
        return entities?.map { personAndPet -> personAndPet.toModel() } ?: mutableListOf()
    }

    fun findPersonAndPetAndCar(): List<PersonModel> {
        val entities = db.personDao().getPersonAndPetAndCars()
        return entities?.map { personAndPetAndCar -> personAndPetAndCar.toModel() }
            ?: mutableListOf()
    }

    fun findPersonAndPetAndCarAndJob(): List<PersonModel> {
        val entities = db.personDao().getPersonAndPetAndCarsAndJob()
        return entities?.map { personAndPetAndCarAndJob -> personAndPetAndCarAndJob.toModel() }
            ?: mutableListOf()
    }


    fun save(personalModel: PersonModel) {
        db.personDao().insertPeopleAndPetAndCarsAndJobs(
            PersonEntity.toEntity(personalModel),
            PetEntity.toEntity(personalModel.pet, personalModel.id),
            CarEntity.toEntity(personalModel.carModel, personalModel.id),
            JobEntity.toEntity(personalModel.jobModel),
            PersonJobEntity.toEntity(
                personalModel.id,
                personalModel.jobModel.map { it.id }.toList()
            )
        )
    }

}