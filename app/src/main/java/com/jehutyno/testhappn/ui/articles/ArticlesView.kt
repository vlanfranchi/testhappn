package com.jehutyno.testhappn.ui.articles

interface ArticlesView {

    enum class Page {
        Content,
        Progress,
        Message
    }

    fun renderProgressBar()
    fun renderArticles(articles: List<ArticleItem>?)
    fun renderError(errorMessage: String)
}