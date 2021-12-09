package com.example.aad_playground.ut03.ex03.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface AlertDao {

    @Transaction
    @Query("SELECT * FROM alert")
    fun getAlerts(): List<AlertWithFiles>

    @Transaction
    @Query("SELECT * FROM alert WHERE id = :alert_id")
    fun getAlert(alert_id: String): AlertWithFiles

    @Insert
    fun insert(alertEntity: AlertEntity, fileEntity: List<FileEntity>)
}