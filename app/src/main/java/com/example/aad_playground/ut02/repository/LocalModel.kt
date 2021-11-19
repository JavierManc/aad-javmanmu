package com.example.aad_playground.ut02.repository

interface Model {
    fun getId(): Int
}

data class UserModel(val userId: Int, val name: String, val surname: String) : Model {
    override fun getId(): Int = userId
}