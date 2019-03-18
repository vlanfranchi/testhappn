package com.jehutyno.testhappn.ui.details

import androidx.core.text.HtmlCompat
import com.jehutyno.testhappn.extensions.toHumanSlash
import com.jehutyno.testhappn.extensions.toISO8601
import com.jehutyno.usecases.GetArticle
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DetailsPresenter(
    private var view: DetailsView?,
    private val getArticle: GetArticle
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
                    view?.renderCategories("#${article.categories?.joinToString(" #" )}")
                }
                view?.renderDate(article.pubDate.toISO8601().toHumanSlash())
                view?.renderAuthor(article.author)
                view?.renderThumbnail(article.thumbnail)
            }
        }
    }

    fun onDestroy() {
        job.cancel()
        view = null
    }

}