package com.example.aad_playground.ut03.ex06.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aad_playground.ut03.ex06.data.local.database.BarEntity
import com.example.aad_playground.ut03.ex06.data.local.database.TapaDao
import com.example.aad_playground.ut03.ex06.data.local.database.TapaEntity

@Database(
    entities = [TapaEntity::class, BarEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex06Database : RoomDatabase() {

    abstract fun tapaDao(): TapaDao

    /**
     * Necesitamos crear una única instancia de la base de datos. Esto es así porque es muy
     * constoso en recursos de memoria usar varias instancias.
     *
     * A través del patrón de diseño SINGLETON creamos una instancia de la base de datos
     * y nos aseguramos que no se creen más.
     */
    companion object {
        @Volatile
        private var instance: Ut03Ex06Database? = null

        fun getInstance(applicationContext: Context): Ut03Ex06Database {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(applicationContext).also { instance = it }
            }
        }

        private fun buildDatabase(applicationContext: Context): Ut03Ex06Database {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex06Database::class.java,
                "db-ut03-ex06-tapas"
            ).build()
        }
    }
}