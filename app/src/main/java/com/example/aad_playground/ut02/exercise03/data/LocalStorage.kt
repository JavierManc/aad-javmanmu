package com.example.aad_playground.ut02.exercise03.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.aad_playground.R
import com.example.aad_playground.commons.Serializer

interface LocalStorage<T : LocalModel> {
    fun save(model: T)
    fun fetch(id: Int): T?
}

class SharPrefLocalStorage<T : LocalModel>(
    private val activity: AppCompatActivity,
    private val serializer: Serializer<T>
) : LocalStorage<T> {

    private val sharedPref = activity.getSharedPreferences(
        activity.getString(R.string.preference_file_exercise03),
        Context.MODE_PRIVATE
    )

    override fun save(model: T) {
        val editor = sharedPref.edit()
        editor.putString(model.getId(), serializer.toJson(model))
        editor.apply()
    }

    override fun fetch(id: Int): T? {
        val jsonModel = sharedPref.getString(id.toString(), "{}")
        return if (jsonModel != null) {
            serializer.fromJson(jsonModel)
        } else {
            null
        }
    }
}
