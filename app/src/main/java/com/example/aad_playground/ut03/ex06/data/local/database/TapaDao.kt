package com.example.aad_playground.ut03.ex06.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TapaDao {

    @Query("SELECT * FROM tapas")
    fun fetchTapas(): List<TapaAndBar>

    @Query("SELECT * FROM tapas WHERE tapaId= :id")
    fun fetchTapa(id: String): TapaAndBar

    @Insert
    fun saveTapa(tapa: TapaAndBar)

}