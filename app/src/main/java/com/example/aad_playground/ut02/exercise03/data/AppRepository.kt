package com.example.aad_playground.ut02.exercise03.data

class AppRepository(private val localStorage: LocalStorage<AppModel>) {

    fun save(model: AppModel) = localStorage.save(model)

    fun fetch(): AppModel? = localStorage.fetch(AppModel.ID)
}