package com.example.aad_playground.ut03.ex03.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aad_playground.ut03.ex03.app.remote.ApiResponse
import com.example.aad_playground.ut03.ex03.data.remote.AlertApiModel
import retrofit2.Call
import retrofit2.http.Path

@Dao
interface AlertDao {
    @Query("SELECT * FROM alert")
    fun getAlerts(): List<AlertEntity>

    @Query("SELECT * FROM alert WHERE id = :alert_id")
    fun getAlert(alert_id: String): AlertEntity

    @Insert
    fun insert(alertEntity: AlertEntity)
}