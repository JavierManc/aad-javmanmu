package com.example.aad_playground.ut03.ex02.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aad_playground.ut03.ex02.domain.PersonModel
import com.example.aad_playground.ut03.ex02.domain.PetModel

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "pet") val pet: PetEntity
) {

    fun toModel(): PersonModel = PersonModel(id, name, age, null, pet.toModel())
}

@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int
) {
    fun toModel(): PetModel = PetModel(id, name, age)
}