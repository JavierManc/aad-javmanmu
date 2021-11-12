package com.example.aad_playground.ut03.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aad_playground.R
import com.example.aad_playground.ut03.ex02.data.PersonDataRepository
import com.example.aad_playground.ut03.ex02.data.PersonLocalSource
import com.example.aad_playground.ut03.ex02.domain.*

class Example02Activity : AppCompatActivity() {

    private val TAG = Example02Activity::class.java.simpleName

    private val repository: PersonRepository by lazy {
        PersonDataRepository(PersonLocalSource(applicationContext))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example02)
        executeQuery()
    }

    private fun executeQuery() {
        Thread {
            val carList: MutableList<CarModel> = mutableListOf(
                CarModel(1, "Audi", "A3"),
                CarModel(2, "Audi", "A5")
            )
            val jobList: MutableList<JobModel> = mutableListOf(
                JobModel(1, "Programador"),
                JobModel(2, "JefeProyecto")
            )
            repository.savePerson(PersonModel(1, "Name01", 1, "1", PetModel(1, "Pet01", 2), carList, jobList))
            val people = repository.findPersonAndPetAndCarAndJob()
            Log.d(TAG, "$people")
        }.start()
    }
}