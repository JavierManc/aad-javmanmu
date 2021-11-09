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
            Thread.sleep(2000)
        }.start()
    }

    fun findAll(): List<PersonModel> {
        val people = db.personDao().findAll()
        return people.map { peopleEntity -> peopleEntity.toModel() }
    }

    fun save(personalModel: PersonModel) {
        db.personDao().insert(
            PersonEntity(
                personalModel.id,
                personalModel.name,
                personalModel.age,
                db.petDao().findAll().first()
            )
        )
    }

}