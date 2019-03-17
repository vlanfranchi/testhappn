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
        launch {
            val trips = withContext(Dispatchers.IO) { getArticles() }
            view?.renderArticles(trips)
        }
    }

    fun newTripsRequested() = launch {
        try {
            val trips = withContext(Dispatchers.Default) {
                requestNewArticles()
            }
            view?.renderArticles(trips)
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
    }


}