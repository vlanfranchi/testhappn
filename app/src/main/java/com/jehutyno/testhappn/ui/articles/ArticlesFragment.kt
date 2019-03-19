package com.jehutyno.testhappn.ui.articles

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jehutyno.testhappn.R
import com.jehutyno.testhappn.di.component.ArticlesScreenComponent
import com.jehutyno.testhappn.di.module.ArticlesScreenModule
import com.jehutyno.testhappn.extensions.app
import com.jehutyno.testhappn.extensions.mainActivity
import kotlinx.android.synthetic.main.fragment_articles.*
import javax.inject.Inject


class ArticlesFragment : Fragment(), ArticlesView, ArticlesAdapter.OnArticleClickListener {

    private val navHost by lazy { findNavController(this) }

    private val articlesScreenComponent: ArticlesScreenComponent by lazy {
        app.articlesComponent.plus(
            ArticlesScreenModule(this)
        )
    }

    @Inject
    lateinit var articlesPresenter: ArticlesPresenter

    private val adapter: ArticlesAdapter by lazy { ArticlesAdapter(mainActivity, this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(com.jehutyno.testhappn.R.layout.fragment_articles, container, false)
        setHasOptionsMenu(true)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articlesScreenComponent.inject(this)
        articlesPresenter.onCreate()
        flipper.displayedChild = ArticlesView.Page.Content.ordinal
        articlesList.layoutManager = GridLayoutManager(mainActivity, 2)
        articlesList.adapter = adapter
        pullToRefresh.setOnRefreshListener {
            articlesPresenter.newTripsRequested()
        }
        articlesPresenter.newTripsRequested()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(com.jehutyno.testhappn.R.menu.menu, menu)
        (menu.findItem(com.jehutyno.testhappn.R.id.search).actionView as SearchView).apply {
            this.setOnQueryTextListener(
                object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String): Boolean {
                        articlesPresenter.searchArticles(query)
                        return false
                    }

                    override fun onQueryTextChange(query: String): Boolean {
                        articlesPresenter.searchArticles(query)
                        return false
                    }
                }
            )
        }

        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.sort -> articlesPresenter.switchSort()
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        articlesPresenter.onDestroy()
    }

    override fun renderRefresh() {
        pullToRefresh.isRefreshing = true
    }

    override fun renderArticles(articles: List<ArticleItem>?) {
        pullToRefresh.isRefreshing = false
        flipper.displayedChild = ArticlesView.Page.Content.ordinal
        adapter.update(articles)
    }

    override fun renderError(errorMessage: String) {
        pullToRefresh.isRefreshing = false
        Snackbar.make(pullToRefresh, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun renderEmpty() {
        pullToRefresh.isRefreshing = false
        Snackbar.make(pullToRefresh, getString(com.jehutyno.testhappn.R.string.no_articles), Snackbar.LENGTH_LONG).show()
    }

    override fun onArticleClickListener(articleId: String) {
        navHost.navigate(ArticlesFragmentDirections.showDetails(articleId))
    }

    override fun onFavoriteClickListener(articleId: String, favoriteId: String?) {
        articlesPresenter.switchFavorite(articleId, favoriteId)
    }

    override fun renderFavoriteAddSuccess(articleId: String, favoriteId: String) {
        Snackbar.make(pullToRefresh, getString(R.string.favorite_add_success), Snackbar.LENGTH_LONG).show()
        adapter.updateFavorite(articleId, favoriteId)
    }

    override fun renderFavoriteDeleteSuccess(articleId: String) {
        Snackbar.make(pullToRefresh, getString(R.string.favorite_delete_success), Snackbar.LENGTH_LONG).show()
        adapter.updateFavorite(articleId, null)
    }

}
