package com.jehutyno.testhappn.ui.articles

import com.jehutyno.usecases.GetArticles
import com.jehutyno.usecases.RequestNewArticles
import kotlinx.coroutines.*
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class ArticlesPresenter(
    private var view: ArticlesView?,
    private val getArticles: GetArticles,
    private val requestNewArticles: RequestNewArticles
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job

    fun onCreate() {
        job = Job()
    }

    fun loadPersistedArticles() {
        launch {
            val articles = withContext(Dispatchers.IO) { getArticles() }
            view?.renderArticles(ArticleConverter.convert(articles))
        }
    }

    fun newTripsRequested() = launch {
        view?.renderRefresh()
        try {
            val articles = withContext(Dispatchers.IO) {
                requestNewArticles()
            }
            if (articles.isNullOrEmpty())
                view?.renderEmpty()
            else
                view?.renderArticles(ArticleConverter.convert(articles))

        } catch (e: HttpException) {
            view?.renderError("HTTP error: ${e.code()}")
            println("HTTP error: ${e.code()}")
        } catch (e: Throwable) {
            view?.renderError("Error: ${e.message} ")
            println("Error: ${e.message} ")
        }
    }

    fun onDestroy() {
        job.cancel()
        view = null
    }


}