package com.jehutyno.testhappn.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jehutyno.testhappn.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : Fragment(), DetailsView {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsPresenter.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsPresenter.loadPersistedArticle(args.articleId)
    }

    override fun onDestroy() {
        super.onDestroy()
        detailsPresenter.onDestroy()
    }

    override fun renderTitle(title: String) {
        titleTv.text = title
    }

    override fun renderContent(content: String?) {
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
}
