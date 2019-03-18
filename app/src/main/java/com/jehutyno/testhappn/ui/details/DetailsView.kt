package com.jehutyno.testhappn.ui.details

interface DetailsView {

    fun renderTitle(title: String)
    fun renderContent(content: String?)
    fun renderCategories(categories: String?)
    fun renderDate(date: String)
    fun renderAuthor(author: String)
    fun renderThumbnail(url: String?)

}