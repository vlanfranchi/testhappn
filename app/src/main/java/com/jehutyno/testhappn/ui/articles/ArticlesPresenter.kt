package com.jehutyno.testhappn.ui.articles

import com.jehutyno.usecases.AddFavorite
import com.jehutyno.usecases.GetArticles
import com.jehutyno.usecases.RemoveFavorite
import com.jehutyno.usecases.RequestNewArticles
import kotlinx.coroutines.*
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class ArticlesPresenter(
    private var view: ArticlesView?,
    private val getArticles: GetArticles,
    private val requestNewArticles: RequestNewArticles,
    private val addFavorite: AddFavorite,
    private val removeFavorite: RemoveFavorite
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job

    private var sortAscending = true
    private var sortFavorites = false
    private var currentSearch = ""

    fun onCreate() {
        job = Job()
    }

    private fun loadPersistedArticles(query: String = "") {
        currentSearch = query
        launch {
            val articles = withContext(Dispatchers.IO) { getArticles() }
            if (articles.isNullOrEmpty())
                view?.renderEmpty()
            else {
                var filtered = articles.filter { it.title.toLowerCase().contains(currentSearch.toLowerCase()) }
                if (sortFavorites)
                    filtered = filtered.filter { it.favorite_id != null }
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
        } catch (e: HttpException) {
            view?.renderError("HTTP error: ${e.code()}")
            println("HTTP error: ${e.code()}")
        } catch (e: Throwable) {
            view?.renderError("Error: ${e.message} ")
            println("Error: ${e.message} ")
        }
        loadPersistedArticles(currentSearch)
    }

    fun switchSort() {
        sortAscending = !sortAscending
        loadPersistedArticles(currentSearch)
    }

    fun switchFavorites() {
        sortFavorites = !sortFavorites
        loadPersistedArticles(currentSearch)
    }

    fun searchArticles(query: String) {
        loadPersistedArticles(query)
    }

    fun switchFavorite(articleId: String, favoriteId: String?) = launch {
        try {
            if (favoriteId != null) {
                withContext(Dispatchers.IO) {
                    removeFavorite(articleId, favoriteId)
                }
                view?.renderFavoriteDeleteSuccess(articleId)
                if (sortFavorites)
                    loadPersistedArticles(currentSearch)
            } else {
                val favorite = withContext(Dispatchers.IO) {
                    addFavorite(articleId)
                }
                view?.renderFavoriteAddSuccess(articleId, favorite._id)
            }
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