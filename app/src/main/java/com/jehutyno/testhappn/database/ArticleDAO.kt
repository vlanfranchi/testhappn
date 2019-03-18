package com.jehutyno.testhappn.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ArticleDAO {
    @Query("Select * FROM articles WHERE id = :articleId LIMIT 1")
    suspend fun getAllArticle(articleId: String): ArticleRoom

    @Query("Select * FROM articles")
    suspend fun getAllArticles(): List<ArticleRoom>

    @Insert(onConflict = REPLACE)
    suspend fun addArticles(articles: List<ArticleRoom>?)

    @Query("Delete FROM articles")
    suspend fun deleteAllArticles()
}