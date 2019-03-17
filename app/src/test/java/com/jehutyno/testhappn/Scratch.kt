package com.jehutyno.testhappn

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

internal fun loadScratch(name: String): File {
    return File(ClassLoader.getSystemResource(name).path)
   // return File("app/src/test/java/com/jehutyno/testhappn/scratch/$name")
}

internal inline fun <reified T> load(name: String): T {
    val string = loadScratch(name).readText()
    return Gson().fromJson<T>(string)
}

inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)