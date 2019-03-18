package com.jehutyno.testhappn.ui.details

import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.extensions.toHumanSlash
import com.jehutyno.testhappn.extensions.toISO8601

class DetailsPresenter(
    private val view: DetailsView?
) {

    fun onCreate(articleId: String) {
        view?.renderTitle(article.title)
        view?.renderContent(article.content)
        article.categories?.let {
            view?.renderCategories("#${article.categories?.joinToString { " #" }}")
        }
        view?.renderDate(article.pubDate.toISO8601().toHumanSlash())
        view?.renderAuthor(article.author)
        view?.renderThumbnail(article.thumbnail)
    }

    fun onDestroy() {

    }

}