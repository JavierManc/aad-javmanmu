package com.example.aad_playground.ut02.repository

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.coroutines.Continuation

/**
 * Interfaz genérica que define una fuente a datos sin especificar el tipo
 */
interface DataSource<T : Model> {
    fun save(model: List<T>)
    fun fetch(id: Int): T?
    fun fetchAll(): List<T>?
}

/**
 * Clase que permite almacenar objetos en memoria
 */
class MemDataSource<T : Model> : DataSource<T> {

    private val memDataStorage: MutableList<T> = mutableListOf()

    override fun save(model: List<T>) {
        memDataStorage.addAll(model)
    }

    override fun fetch(id: Int): T? {
        memDataStorage.forEach {
            if (it.getId() == id) {
                return it
            }
        }
        return null
    }

    override fun fetchAll(): List<T>? = memDataStorage.toList()

}

class SharPrefDataSource<T : Model>(private val context: AppCompatActivity) : DataSource<T> {

    private val gson = Gson()
    private val type = object : TypeToken<UserModel>() {}.type

    private val sharedPref = context.getSharedPreferences(
        "ut02_shared_pref", Context.MODE_PRIVATE
    )

    override fun save(model: List<T>) {

        val edit = sharedPref.edit()
        model.forEach {
            edit?.putString(it.getId().toString(), gson.toJson(it))
        }
        edit?.apply()
    }

    override fun fetch(id: Int): T? {

        TODO("Not yet implemented")


    }

    override fun fetchAll(): List<T>? {
        TODO("Not yet implemented")
    }
}