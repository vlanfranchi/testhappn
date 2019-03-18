package com.jehutyno.testhappn.framework

import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.Converter
import com.jehutyno.testhappn.database.ArticleRoom

object ArticleRoomConverter: Converter<ArticleRoom, Article> {

    override fun convert(input: ArticleRoom): Article {
        return Article(
            _id = input.id,
            title = input.title,
            description = input.description,
            pubDate = input.pubDate,
            thumbnail = input.thumbnail,
            author = input.author,
            content = input.content,
            favorite_id = input.favoriteId,
            categories = input.categories?.split(","),
            link = input.link,
            guid = ""
        )
    }

}