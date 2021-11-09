package com.example.aad_playground.ut03.ex02.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun findAll(): List<PersonEntity>

    @Insert
    fun insert(personEntity: PersonEntity)
}