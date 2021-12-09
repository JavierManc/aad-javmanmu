package com.example.aad_playground.ut02.exercise04.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aad_playground.ut02.exercise04.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut02Ex06ViewModel(
    private val getModelUseCase: GetModelUseCase,
    private val getEspecificModelUseCase: GetEspecificModelUseCase,
    private val deleteModelUseCase: DeleteModelUseCase,
    private val saveModelUseCase: SaveModelUseCase,
    private val saveModelsUseCase: SaveModelsUseCase
) : ViewModel() {

    fun saveModelList(modelList: List<Models>) {
        saveModelsUseCase.execute(modelList)
    }

    fun saveModel(model: Models) {
        saveModelUseCase.execute(model)
    }

    fun getModels(): List<Models> {
        return getModelUseCase.execute()
    }

    fun getModel(modelId: Int): Models? {
        return getEspecificModelUseCase.execute(modelId)
    }

    fun removeModel(modelId: Int) {
        deleteModelUseCase.execute(modelId)
    }

    fun showModelList(list: List<Models>) {
        viewModelScope.launch(Dispatchers.Main) {
            list.forEach { element ->
                Log.d("Costumers", element.toString())
            }

        }
    }

    fun showModel(model: Models) {
        viewModelScope.launch(Dispatchers.Main) {
            Log.d("Customer", model.toString())
        }
    }
}