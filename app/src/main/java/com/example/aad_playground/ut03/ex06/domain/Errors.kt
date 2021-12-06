package com.example.aad_playground.ut03.ex06.domain

sealed class Failure : Throwable() {
    object DataError : Failure()
    object NetworkConnectionError : Failure()
    object ServerError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()
}