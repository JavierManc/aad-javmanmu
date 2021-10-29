package com.example.aad_playground.ut02.exercise03.data

interface LocalModel {
    fun getId(): String
}

data class AppModel(
    private val id: String,
    val isFirstTime: Boolean = false,
    private val rating: Float = 0f
) : LocalModel {
    fun getFirstTime(): Boolean {
        return isFirstTime
    }

    fun getRating(): Float {
        return rating
    }

    override fun getId(): String {
        return id
    }
}

