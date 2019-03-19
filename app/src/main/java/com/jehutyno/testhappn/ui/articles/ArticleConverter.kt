package com.jehutyno.testhappn.ui.articles

import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.Converter
import com.jehutyno.testhappn.extensions.toHumanSlash
import com.jehutyno.testhappn.extensions.toISO8601

object ArticleConverter: Converter<Article, ArticleItem> {

    override fun convert(input: Article): ArticleItem {
        return ArticleItem(
            id = input._id,
            title = input.title,
            description = input.description,
            date = input.pubDate.toISO8601().toHumanSlash(),
            thumbnail = input.thumbnail,
            author = input.author,
            content = input.content,
            favoriteId = input.favorite_id
        )
    }

}