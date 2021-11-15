package com.example.aad_playground.ut03.ex02.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aad_playground.ut03.ex02.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Example02ViewModel() : ViewModel() {
    private val TAG = Example02Activity::class.java.simpleName

    fun getPeople(repository: PersonRepository) {
        viewModelScope.launch(Dispatchers.IO) {
            val carList: MutableList<CarModel> = mutableListOf(
                CarModel(1, "Audi", "A3"),
                CarModel(2, "Audi", "A5")
            )
            val jobList: MutableList<JobModel> = mutableListOf(
                JobModel(1, "Programador"),
                JobModel(2, "JefeProyecto")
            )
            repository.savePerson(
                PersonModel(
                    1,
                    "Name01",
                    1,
                    "1",
                    PetModel(1, "Pet01", 2),
                    carList,
                    jobList
                )
            )
            val people = repository.fetchAll()
            Log.d(TAG, "$people")
        }
    }
}