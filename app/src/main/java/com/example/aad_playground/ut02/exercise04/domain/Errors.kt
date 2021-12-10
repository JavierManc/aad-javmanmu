package com.example.aad_playground.ut02.exercise04.domain

sealed class Failure : Throwable() {
    object XmlError : Failure()
}