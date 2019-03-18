package com.jehutyno.testhappn.framework.articles

import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.Converter
import com.jehutyno.testhappn.database.articles.ArticleRoom

object RoomArticleConverter: Converter<Article, ArticleRoom> {

    override fun convert(input: Article): ArticleRoom {
        return ArticleRoom(
            id = input._id,
            title = input.title,
            pubDate = input.pubDate,
            link = input.link,
            description = input.description,
            author = input.author,
            content = input.content,
            thumbnail = input.thumbnail,
            favoriteId = input.favorite_id,
            categories = input.categories?.joinToString(",")
        )
    }

}