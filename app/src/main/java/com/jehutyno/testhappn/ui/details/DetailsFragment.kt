package com.jehutyno.testhappn.ui.details

import android.os.Bundle
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.jehutyno.testhappn.R
import com.jehutyno.testhappn.di.component.DetailsScreenComponent
import com.jehutyno.testhappn.di.module.DetailsScreenModule
import com.jehutyno.testhappn.extensions.app
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : Fragment(), DetailsView {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    private val args by navArgs<DetailsFragmentArgs>()

    private val detailsScreenComponent: DetailsScreenComponent by lazy {
        app.articlesComponent.plus(
            DetailsScreenModule(this)
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsScreenComponent.inject(this)
        detailsPresenter.onCreate()
        detailsPresenter.loadPersistedArticle(args.articleId)
        bookmarkTv.setOnClickListener {
            detailsPresenter.switchFavorite(args.articleId)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        detailsPresenter.onDestroy()
    }

    override fun renderTitle(title: String) {
        titleTv.text = title
    }

    override fun renderContent(content: Spanned) {
        contentTv.text = content
    }

    override fun renderCategories(categories: String?) {
        categoriesTv.text = categories
    }

    override fun renderDate(date: String) {
        dateTv.text = date
    }

    override fun renderAuthor(author: String) {
        authorTv.text = author
    }

    override fun renderThumbnail(url: String?) {
        Picasso.get().load(url).placeholder(R.drawable.placeholder).into(thumbnailTv)
    }

    override fun renderFavorite(checked: Boolean) {
        bookmarkTv.isChecked = checked
    }

    override fun renderFavoriteAddSuccess() {
        Snackbar.make(container, getString(R.string.favorite_add_success), Snackbar.LENGTH_LONG).show()
        bookmarkTv.isChecked = true
    }

    override fun renderFavoriteDeleteSuccess() {
        Snackbar.make(container, getString(R.string.favorite_delete_success), Snackbar.LENGTH_LONG).show()
        bookmarkTv.isChecked = false
    }

    override fun renderError(errorMessage: String) {
        Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG).show()
    }

}
