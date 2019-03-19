package com.jehutyno.testhappn.database.favorites

import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME = "favorites"

@Entity(tableName = TABLE_NAME)
class FavoriteRoom() : Comparable<FavoriteRoom> {

    @PrimaryKey(autoGenerate = false)
    var favoriteId: String = ""
    var articleId: String? = ""

    override fun compareTo(other: FavoriteRoom): Int {
        return other.favoriteId.compareTo(this.favoriteId)
    }

    constructor(
        favoriteId: String,
        articleId: String?
    ) : this() {
        this.favoriteId = favoriteId
        this.articleId = articleId
    }

}