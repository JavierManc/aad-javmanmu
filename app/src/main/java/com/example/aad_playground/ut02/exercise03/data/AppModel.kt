package com.example.aad_playground.ut02.exercise03.data

interface LocalModel {
    fun getId(): String
}

data class AppModel(
    private var firstTime: Boolean = true, private var newRating: Float = 0f
) : LocalModel {
    var isFirstTime = firstTime
    var rating = newRating
    override fun getId(): String = ID

    /**
     * Método estático/ variables estática, es decir, se puede acceder desde fuera
     * sin crearse un objeto.
     */
    companion object {
        val ID = AppModel::class.java.simpleName
    }
}

