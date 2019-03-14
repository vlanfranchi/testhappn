package com.jehutyno.domain.model

import java.util.*

data class Article(
    val title: String,
    val pubDate: Date,
    val link: String,
    val description: String,
    val guid: String,
    val author: String,
    val content: String?,
    val categories: List<String>?,
    val thumbnail: String?,
    val favorite_id: Long?
)