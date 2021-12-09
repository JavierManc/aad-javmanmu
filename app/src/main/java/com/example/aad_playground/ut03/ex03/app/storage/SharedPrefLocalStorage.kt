package com.example.aad_playground.ut03.ex03.app.storage

import android.content.Context
import com.example.aad_playground.ut03.ex03.data.local.db.AlertWithFiles
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPrefLocalStorage<T : LocalModel>(context: Context, xmlFileName: String) : LocalStorage<T> {

    private val gson = Gson()
    private val type = object : TypeToken<AlertWithFiles>() {}.type

    private val sharedPref = context.getSharedPreferences(
        xmlFileName, Context.MODE_PRIVATE
    )

    override fun fetch(modelId: String, type: Class<T>): T? {

        val model = sharedPref.getString(modelId, "{}")
        return if (model.isNullOrEmpty()){
            null
        }else {
            gson.fromJson(model, type)
        }

    }

    override fun save(model: T) {
        val edit = sharedPref.edit()
        edit?.putString(model.getId(), gson.toJson(model))
        edit?.apply()
    }
}