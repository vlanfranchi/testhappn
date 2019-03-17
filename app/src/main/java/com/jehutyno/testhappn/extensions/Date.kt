package com.jehutyno.testhappn.extensions

import java.text.SimpleDateFormat
import java.util.*

val humanDateSlashFormat
    get() = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).also {
        it.timeZone = TimeZone.getDefault()
    }

val dateFormat
    get() = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).also {
        it.timeZone = TimeZone.getTimeZone("UTC")
    }


fun Date.toHumanSlash(): String = humanDateSlashFormat.format(this)

fun String.toISO8601(): Date = dateFormat.parse(this)