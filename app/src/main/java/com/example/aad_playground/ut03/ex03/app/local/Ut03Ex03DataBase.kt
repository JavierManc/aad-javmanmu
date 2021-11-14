package com.example.aad_playground.ut03.ex03.app.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aad_playground.ut03.ex03.data.local.AlertDao
import com.example.aad_playground.ut03.ex03.data.local.AlertEntity

@Database(
    entities = [AlertEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex03DataBase : RoomDatabase() {

    abstract fun alertDao(): AlertDao

    companion object {
        @Volatile
        private var instance: Ut03Ex03DataBase? = null

        fun getInstance(applicationContext: Context): Ut03Ex03DataBase {
            if (instance == null) {
                instance = buildDataBase(applicationContext)
            }
            return instance as Ut03Ex03DataBase
        }

        private fun buildDataBase(applicationContext: Context): Ut03Ex03DataBase {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex03DataBase::class.java,
                "db-ut03-ex02"
            ).build()
        }
    }
}