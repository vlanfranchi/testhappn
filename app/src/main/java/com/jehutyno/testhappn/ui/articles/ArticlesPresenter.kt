package com.jehutyno.testhappn.ui.articles

import com.jehutyno.usecases.GetArticles
import com.jehutyno.usecases.RequestNewArticles

class ArticlesPresenter(
    private var view: ArticlesView?,
    private val getArticles: GetArticles,
    private val requestNewArticles: RequestNewArticles
) {

    fun onCreate() {

    }

    fun onDestroy() {

    }

}