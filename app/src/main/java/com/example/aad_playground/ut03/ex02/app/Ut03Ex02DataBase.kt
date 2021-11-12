package com.example.aad_playground.ut03.ex02.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aad_playground.ut03.ex02.data.*

@Database(
    entities = [PersonEntity::class, PetEntity::class, CarEntity::class, JobEntity::class, PersonJobEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex02DataBase : RoomDatabase() {

    abstract fun personDao(): PersonDao
    abstract fun petDao(): PetDao

    companion object {
        @Volatile
        private var instance: Ut03Ex02DataBase? = null

        fun getInstance(applicationContext: Context): Ut03Ex02DataBase {
            if (instance == null) {
                instance = buildDataBase(applicationContext)
            }
            return instance as Ut03Ex02DataBase
        }

        private fun buildDataBase(applicationContext: Context): Ut03Ex02DataBase {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex02DataBase::class.java,
                "db-ut03-ex02"
            ).build()
        }
    }
}