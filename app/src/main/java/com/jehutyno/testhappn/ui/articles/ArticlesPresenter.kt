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

    private var sortAscending = true

    fun onCreate() {
        job = Job()
    }

    private fun loadPersistedArticles(query: String = "") {
        launch {
            val articles = withContext(Dispatchers.IO) { getArticles() }
            if (articles.isNullOrEmpty())
                view?.renderEmpty()
            else {
                val filtered = articles.filter { it.title.toLowerCase().contains(query.toLowerCase()) }
                view?.renderArticles(
                    ArticleConverter.convert(
                        if (sortAscending)
                            filtered.sortedBy { it.pubDate }
                        else
                            filtered.sortedByDescending { it.pubDate }
                    )
                )
            }
        }
    }

    fun newTripsRequested() = launch {
        view?.renderRefresh()
        try {
            withContext(Dispatchers.IO) {
                requestNewArticles()
            }
            loadPersistedArticles()
        } catch (e: HttpException) {
            view?.renderError("HTTP error: ${e.code()}")
            println("HTTP error: ${e.code()}")
        } catch (e: Throwable) {
            view?.renderError("Error: ${e.message} ")
            println("Error: ${e.message} ")
        }
    }

    fun switchSort() {
        sortAscending = !sortAscending
        loadPersistedArticles()
    }

    fun searchArticles(query: String) {
        loadPersistedArticles(query)
    }

    fun onDestroy() {
        job.cancel()
        view = null
    }

}