package com.jehutyno.testhappn.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ArticleRoom::class], version = 1)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDAO
}