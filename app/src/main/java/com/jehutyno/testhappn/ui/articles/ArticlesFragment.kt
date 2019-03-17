package com.jehutyno.testhappn.ui.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.R
import com.jehutyno.testhappn.di.component.ArticlesScreenComponent
import com.jehutyno.testhappn.di.module.ArticlesScreenModule
import com.jehutyno.testhappn.extensions.app
import com.jehutyno.testhappn.extensions.mainActivity
import kotlinx.android.synthetic.main.fragment_articles.*
import javax.inject.Inject


class ArticlesFragment : Fragment(), ArticlesView {

    private val navHost by lazy { findNavController(this) }

    private val articlesScreenComponent: ArticlesScreenComponent by lazy {
        app.articlesComponent.plus(
            ArticlesScreenModule(this)
        )
    }

    @Inject
    lateinit var articlesPresenter: ArticlesPresenter

    private val adapter: ArticlesAdapter by lazy { ArticlesAdapter(mainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articlesScreenComponent.inject(this)
        articlesPresenter.onCreate()
        articlesPresenter.newTripsRequested()
        articlesList.layoutManager = LinearLayoutManager(mainActivity)
        articlesList.adapter = adapter
        message.setOnClickListener { navHost.navigate(R.id.action_articlesFragment_to_articleFragment) }
    }

    override fun onDestroy() {
        super.onDestroy()
        articlesPresenter.onDestroy()
    }

    override fun renderProgressBar() {
        flipper.displayedChild = ArticlesView.Page.Progress.ordinal
    }

    override fun renderArticles(articles: List<Article>) {
        flipper.displayedChild = ArticlesView.Page.Content.ordinal
        adapter.update(articles)
    }

    override fun renderError(errorMessage: String) {
        flipper.displayedChild = ArticlesView.Page.Message.ordinal
        message.text = errorMessage
    }

}
