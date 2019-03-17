package com.jehutyno.testhappn

import com.jehutyno.testhappn.ui.articles.ArticlesView
import com.jehutyno.usecases.GetArticles
import com.jehutyno.usecases.RequestNewArticles
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ArticlesPresenterTest {

    @Mock
    lateinit var view: ArticlesView

    @Mock
    lateinit var getArticles: GetArticles

    @Mock
    lateinit var requestNewArticles: RequestNewArticles

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun validateSomething() {

    }

}