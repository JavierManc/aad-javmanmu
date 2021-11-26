package com.example.aad_playground.ut02.exercise04

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut02Ex06ViewModel(private val localSource: LocalSource) : ViewModel() {

    fun saveModelList(modelList: List<IModels>) {
        localSource.save(modelList)
    }

    fun saveModel(model: IModels) {
        localSource.save(model)
    }

    fun getModels(): List<IModels> {
        return localSource.fetch()
    }

    fun getModel(modelId: Int): IModels? {
        return localSource.fetchById(modelId)
    }

    fun removeModel(modelId: Int) {
        localSource.remove(modelId)
    }

    fun showModelList(list: List<IModels>) {
        viewModelScope.launch(Dispatchers.Main) {
            list.forEach { element ->
                Log.d("Costumers", element.toString())
            }

        }
    }

    fun showModel(model: IModels) {
        viewModelScope.launch(Dispatchers.Main) {
            Log.d("Customer", model.toString())
        }
    }
}