package com.example.aad_playground.ut03.ex04.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aad_playground.ut03.ex04.data.*

@Database(
    entities = [CustomerEntity::class, ProductEntity::class, InvoiceEntity::class, InvoiceLinesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Ut03Ex04DataBase : RoomDatabase() {

    abstract fun customerDao(): CustomerDao
    abstract fun invoiceDao(): InvoiceDao
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var instance: Ut03Ex04DataBase? = null

        fun getInstance(applicationContext: Context): Ut03Ex04DataBase {
            if (instance == null) {
                instance = buildDataBase(applicationContext)
            }
            return instance as Ut03Ex04DataBase
        }

        private fun buildDataBase(applicationContext: Context): Ut03Ex04DataBase {
            return Room.databaseBuilder(
                applicationContext,
                Ut03Ex04DataBase::class.java,
                "db-ut03-ex04"
            ).build()
        }
    }
}