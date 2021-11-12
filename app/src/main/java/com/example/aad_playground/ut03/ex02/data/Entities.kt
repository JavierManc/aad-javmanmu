package com.example.aad_playground.ut03.ex02.data

import androidx.room.*
import com.example.aad_playground.ut03.ex02.domain.CarModel
import com.example.aad_playground.ut03.ex02.domain.PersonModel
import com.example.aad_playground.ut03.ex02.domain.PetModel

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
) {

    fun toModel(): PersonModel =
        PersonModel(id!!, name, age, null, PetModel(1, "", 1), mutableListOf())
}

@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "person_id") val personId: Int,
) {
    fun toModel(): PetModel = PetModel(id!!, name, age)
}

data class PersonAndPet(
    @Embedded val personEntity: PersonEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity
) {
    fun toModel() = PersonModel(
        personEntity.id!!,
        personEntity.name,
        personEntity.age,
        "",
        PetModel(petEntity.id!!, petEntity.name, petEntity.age),
        mutableListOf()
    )
}

@Entity(tableName = "car")
data class CarEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "person_id") val personId: Int,
)

data class PersonAndPetAndCar(
    @Embedded val personEntity: PersonEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val carEntity: List<CarEntity>

) {

    fun toModel() = PersonModel(
        personEntity.id!!,
        personEntity.name,
        personEntity.age,
        "",
        PetModel(petEntity.id!!, petEntity.name, petEntity.age),
        carEntity.map { element ->
            CarModel(element.id, element.brand, element.model)
        }.toMutableList()
    )
}