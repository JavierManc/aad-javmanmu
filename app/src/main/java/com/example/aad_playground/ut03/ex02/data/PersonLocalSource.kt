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


    fun save(personalModel: PersonModel) {
        db.personDao().insertPersonAndPet(
            PersonEntity(
                personalModel.id,
                personalModel.name,
                personalModel.age
            ),
            PetEntity(
                personalModel.pet.id,
                personalModel.pet.name,
                personalModel.pet.age,
                personalModel.id
            ),
            personalModel.carModel.map { element ->
                CarEntity(
                    element.id,
                    element.brand,
                    element.model,
                    personalModel.id
                )
            }
        )
        /*
        db.personDao().insert(
            PersonEntity(
                personalModel.id,
                personalModel.name,
                personalModel.age
            )
        )
        */
    }

}