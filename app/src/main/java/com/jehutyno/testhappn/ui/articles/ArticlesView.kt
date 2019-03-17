package com.jehutyno.testhappn.ui.articles

import com.jehutyno.domain.model.Article

interface ArticlesView {
    fun renderArticles(articles: List<Article>)
    fun renderError(message: String)
}