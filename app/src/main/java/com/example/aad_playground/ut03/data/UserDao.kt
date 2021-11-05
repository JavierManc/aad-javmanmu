package com.example.aad_playground.ut03.data

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM user WHERE id= :id ")
    fun findById(id: Int): UserEntity?

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun findAllByIds(userIds: List<Int>): List<UserEntity>?

    @Query("SELECT * FROM user WHERE name LIKE :name AND username LIKE :username LIMIT 1")
    fun findByName(name: String, username: String): UserEntity?

    @Insert
    fun insert(userEntity: UserEntity)

    @Delete
    fun delete(userEntity: UserEntity)

    @Update
    fun update(userEntity: UserEntity)
}
