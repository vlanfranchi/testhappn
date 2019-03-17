package com.jehutyno.testhappn

import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.ui.articles.ArticlesPresenter
import com.jehutyno.testhappn.ui.articles.ArticlesView
import com.jehutyno.usecases.GetArticles
import com.jehutyno.usecases.RequestNewArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import java.net.HttpURLConnection

class ArticlesPresenterTest {

    @Mock
    lateinit var view: ArticlesView

    @Mock
    lateinit var getArticles: GetArticles

    @Mock
    lateinit var requestNewArticles: RequestNewArticles

    @Mock
    lateinit var httpException: HttpException

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun fetchEmptyDataShouldLoadIntoView() = runBlocking {
        `when`(requestNewArticles()).thenReturn(listOf())
        val presenter = ArticlesPresenter(
            view,
            getArticles,
            requestNewArticles
        )
        presenter.onCreate()
        presenter.newTripsRequested()

        val inOrder = Mockito.inOrder(view)
        inOrder.verify(view, times(1)).renderRefresh()
        inOrder.verify(view, times(1)).renderEmpty()

    }

    @Test
    fun fetchDataHttpErrorShouldLoadIntoView() = runBlocking {
        `when`(requestNewArticles()).thenThrow(httpException)
        `when`(httpException.code()).thenReturn(HttpURLConnection.HTTP_NOT_FOUND)
        val presenter = ArticlesPresenter(
            view,
            getArticles,
            requestNewArticles
        )
        presenter.onCreate()
        presenter.newTripsRequested()

        val inOrder = Mockito.inOrder(view)
        inOrder.verify(view, times(1)).renderRefresh()
        inOrder.verify(view, times(1)).renderError(ArgumentMatchers.anyString())

    }

    @Test
    fun fetchDataShouldLoadIntoView() = runBlocking {
        val model = load<List<Article>>("Articles.json")
        `when`(requestNewArticles()).thenReturn(model)
        val presenter = ArticlesPresenter(
            view,
            getArticles,
            requestNewArticles
        )
        presenter.onCreate()
        presenter.newTripsRequested()

        val inOrder = Mockito.inOrder(view)
        inOrder.verify(view, times(1)).renderRefresh()
        inOrder.verify(view, times(1)).renderArticles(ArgumentMatchers.anyList())
    }

}