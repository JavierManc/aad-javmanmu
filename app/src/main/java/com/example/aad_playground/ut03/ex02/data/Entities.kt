package com.example.aad_playground.ut03.ex02.data

import androidx.room.*
import com.example.aad_playground.ut03.ex02.domain.CarModel
import com.example.aad_playground.ut03.ex02.domain.JobModel
import com.example.aad_playground.ut03.ex02.domain.PersonModel
import com.example.aad_playground.ut03.ex02.domain.PetModel

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
) {

    fun toModel(): PersonModel =
        PersonModel(id!!, name, age, null, PetModel(1, "", 1), mutableListOf(), mutableListOf())

    companion object {
        fun toEntity(personModel: PersonModel) =
            PersonEntity(personModel.id, personModel.name, personModel.age)
    }
}

@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "person_id") val personId: Int,
) {
    fun toModel(): PetModel = PetModel(id!!, name, age)

    companion object {
        fun toEntity(petModel: PetModel, personId: Int) =
            PetEntity(petModel.id, petModel.name, petModel.age, personId)
    }
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
        mutableListOf(),
        mutableListOf()
    )
}

@Entity(tableName = "car")
data class CarEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "person_id") val personId: Int,
) {
    companion object {
        fun toEntity(carsModel: List<CarModel>, personId: Int) = carsModel.map {
            CarEntity(it.id, it.brand, it.model, personId)
        }
    }
}

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
        }.toMutableList(),
        mutableListOf()
    )

}

@Entity(tableName = "job")
data class JobEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String
) {
    fun toModel() = JobModel(id, name)

    companion object {
        fun toEntity(jobsModel: List<JobModel>) = jobsModel.map {
            JobEntity(it.id, it.name)
        }
    }
}

@Entity(
    tableName = "person_job",
    primaryKeys = ["person_id", "job_id"]
)
data class PersonJobEntity(
    @ColumnInfo(name = "person_id") val personId: Int,
    @ColumnInfo(name = "job_id") val jobId: Int
) {
    companion object {
        fun toEntity(personId: Int, jobId: List<Int>) =
            jobId.map { PersonJobEntity(personId, it) }
    }
}


data class PersonAndPetAndCarAndJob(
    @Embedded val personEntity: PersonEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val petEntity: PetEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "person_id"
    ) val carEntity: List<CarEntity>,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = PersonJobEntity::class,
            parentColumn = "person_id",
            entityColumn = "job_id"
        )
    ) val jobEntities: List<JobEntity>,
) {
    fun toModel() = PersonModel(
        personEntity.id!!,
        personEntity.name,
        personEntity.age,
        "",
        PetModel(petEntity.id!!, petEntity.name, petEntity.age),
        carEntity.map { element ->
            CarModel(element.id, element.brand, element.model)
        }.toMutableList(),
        jobEntities.map { element ->
            JobModel(element.id, element.name)
        }.toMutableList()
    )
}