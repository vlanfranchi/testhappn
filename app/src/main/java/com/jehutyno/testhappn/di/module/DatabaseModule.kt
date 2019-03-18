package com.jehutyno.testhappn.di.module

import androidx.room.Room
import com.jehutyno.testhappn.TestHappnApp
import com.jehutyno.testhappn.database.ArticleDAO
import com.jehutyno.testhappn.database.ArticlesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideDatabase(app: TestHappnApp): ArticlesDatabase {
        return Room.databaseBuilder(
            app,
            ArticlesDatabase::class.java,
            "articles.db")
            .build()
    }

    @Provides
    @Singleton
    internal fun provideArticlesDAO(articlesDatabase: ArticlesDatabase): ArticleDAO {
        return articlesDatabase.articleDao()
    }

}