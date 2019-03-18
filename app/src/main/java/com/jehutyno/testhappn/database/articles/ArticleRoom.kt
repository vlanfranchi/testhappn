package com.jehutyno.testhappn.database.articles

import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME = "articles"

@Entity(tableName = TABLE_NAME)
class ArticleRoom() : Comparable<ArticleRoom> {

    @PrimaryKey(autoGenerate = false)
    var id: String = ""
    var title: String = ""
    var pubDate: String = ""
    var link: String = ""
    var description: String = ""
    var author: String = ""
    var content: String? = null
    var thumbnail: String? = null
    var favoriteId: Long? = null
    var categories: String? = null

    override fun compareTo(other: ArticleRoom): Int {
        return other.id.compareTo(this.id)
    }

    constructor(
        id: String,
        title: String,
        pubDate: String,
        link: String,
        description: String,
        author: String,
        content: String?,
        thumbnail: String?,
        favoriteId: Long?,
        categories: String?
    ) : this() {
        this.id = id
        this.title = title
        this.pubDate = pubDate
        this.link = link
        this.description = description
        this.author = author
        this.content = content
        this.thumbnail = thumbnail
        this.favoriteId = favoriteId
        this.categories = categories
    }

}