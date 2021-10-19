package com.example.aad_playground.ut02

class GenericClass<T> {

    fun getName(model: T): String {
        return ""
    }
}

class MainClass {

    fun initMain() {
        val genericClass1 = GenericClass<AnimalClass>()
        val genericClass2 = GenericClass<AnimalClass>()
    }
}

class AnimalClass {}