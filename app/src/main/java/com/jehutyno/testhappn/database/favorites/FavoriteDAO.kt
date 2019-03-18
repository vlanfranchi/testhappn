package com.jehutyno.testhappn.database.favorites

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface FavoriteDAO {
    @Query("Select * FROM favorites WHERE favoriteId = :favoriteId LIMIT 1")
    suspend fun getFavorite(favoriteId: String): FavoriteRoom

    @Query("Select * FROM favorites")
    suspend fun getAllFavorites(): List<FavoriteRoom>

    @Insert(onConflict = REPLACE)
    suspend fun addFavorites(favorite: List<FavoriteRoom>?)

    @Query("Delete FROM favorites")
    suspend fun deleteAllFavorites()
}