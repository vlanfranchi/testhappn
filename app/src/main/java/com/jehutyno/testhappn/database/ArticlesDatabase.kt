package com.jehutyno.testhappn.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jehutyno.testhappn.database.articles.ArticleDAO
import com.jehutyno.testhappn.database.articles.ArticleRoom
import com.jehutyno.testhappn.database.favorites.FavoriteDAO
import com.jehutyno.testhappn.database.favorites.FavoriteRoom

@Database(entities = [ArticleRoom::class, FavoriteRoom::class], version = 1)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDAO
    abstract fun favoriteDao(): FavoriteDAO
}