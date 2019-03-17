package com.jehutyno.testhappn.ui.articles

import com.jehutyno.domain.model.Article

interface ArticlesView {

    enum class Page {
        Content,
        Progress,
        Message
    }


    fun renderProgressBar()
    fun renderArticles(articles: List<Article>)
    fun renderError(errorMessage: String)
}