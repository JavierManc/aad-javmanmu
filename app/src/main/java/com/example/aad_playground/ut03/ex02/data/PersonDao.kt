package com.example.aad_playground.ut03.ex02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun findAll(): List<PersonEntity>

    @Transaction
    @Query("SELECT * FROM person")
    fun getPersonAndPets(): List<PersonAndPet>?

    @Transaction
    @Query("SELECT * FROM person")
    fun getPersonAndPetAndCars(): List<PersonAndPetAndCar>?

    @Insert
    fun insert(personEntity: PersonEntity): Long

    @Insert
    fun insertPersonAndPet(personEntity: PersonEntity, petEntity: PetEntity, carEntity: List<CarEntity>)

}

@Dao
interface PetDao {
    @Query("SELECT * FROM pet")
    fun findAll(): List<PetEntity>
}