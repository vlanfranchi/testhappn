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
    fun renderFavoriteAdded(articleId: String, checked: Boolean)
    fun renderFavoriteRemoved(articleId: String, checked: Boolean)
}