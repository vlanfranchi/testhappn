package com.jehutyno.testhappn.ui.details

import android.text.Spanned

interface DetailsView {

    fun renderTitle(title: String)
    fun renderContent(content: Spanned)
    fun renderCategories(categories: String?)
    fun renderDate(date: String)
    fun renderAuthor(author: String)
    fun renderThumbnail(url: String?)
    fun renderFavorite(checked: Boolean)
    fun renderFavoriteAddSuccess()
    fun renderFavoriteDeleteSuccess()
    fun renderError(errorMessage: String)
    fun hideFavorites()
}