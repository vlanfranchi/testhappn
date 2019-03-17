package com.jehutyno.testhappn.ui.articles

interface ArticlesView {

    enum class Page {
        Content,
        Message
    }

    fun renderRefresh()
    fun renderArticles(articles: List<ArticleItem>?)
    fun renderError(errorMessage: String)
    fun renderEmpty()
}