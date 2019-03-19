package com.jehutyno.testhappn.ui.details

import androidx.core.text.HtmlCompat
import com.jehutyno.testhappn.extensions.toHumanSlash
import com.jehutyno.testhappn.extensions.toISO8601
import com.jehutyno.usecases.AddFavorite
import com.jehutyno.usecases.GetArticle
import com.jehutyno.usecases.RemoveFavorite
import kotlinx.coroutines.*
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class DetailsPresenter(
    private var view: DetailsView?,
    private val getArticle: GetArticle,
    private val addFavorite: AddFavorite,
    private val removeFavorite: RemoveFavorite
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job

    fun onCreate() {
        job = Job()
    }

    fun loadPersistedArticle(articleId: String) {
        launch {
            val article = withContext(Dispatchers.IO) { getArticle(articleId) }
            article?.let {
                view?.renderTitle(article.title)
                article.content?.let {
                    view?.renderContent(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY))
                }
                article.categories?.let {
                    view?.renderCategories("#${article.categories?.joinToString(" #")}")
                }
                view?.renderDate(article.pubDate.toISO8601().toHumanSlash())
                view?.renderAuthor(article.author)
                view?.renderThumbnail(article.thumbnail)
                view?.renderFavorite(article.favorite_id != null)
            }
        }
    }

    fun switchFavorite(articleId: String) = launch {
        val article = withContext(Dispatchers.IO) { getArticle(articleId) }
        article?.let {
            try {
                if (article.favorite_id != null) {
                    withContext(Dispatchers.IO) {
                        removeFavorite(article._id, article.favorite_id!!)
                    }
                    view?.renderFavoriteDeleteSuccess()
                } else {
                    val favorite = withContext(Dispatchers.IO) {
                        addFavorite(articleId)
                    }
                    view?.renderFavoriteAddSuccess()
                }
            } catch (e: HttpException) {
                view?.renderError("HTTP error: ${e.code()}")
                println("HTTP error: ${e.code()}")
            } catch (e: Throwable) {
                view?.renderError("Error: ${e.message} ")
                println("Error: ${e.message} ")
            }
        }
    }

    fun onDestroy() {
        job.cancel()
        view = null
    }

}