@file:JvmName("ParserUtil")

package org.krestspec.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.file.Paths

/**
 * Created by kleber on 19/06/17.
 */
fun <T> T.toJsonString(): String {
    return ObjectMapper().writeValueAsString(this)
}

fun <T> String.toJsonObject(valueType: Class<T>): T {
    return ObjectMapper().readValue(this, valueType)
}

fun <T> fromJsonFile(jsonFilePath: String, valueType: Class<T>): T {
    return ObjectMapper().readValue(Paths.get(jsonFilePath).toFile(), valueType)
}

fun <T> T.toGsonString(valueType: Class<T>): String {
    return Gson().toJson(this, valueType)
}

fun <T> String.toGsonObject(valueType: Class<T>): T {
    return Gson().fromJson(this, valueType)
}

fun <T> fromGsonFile(jsonFilePath: String, valueType: Class<T>): T {
    return Gson().fromJson(InputStreamReader(FileInputStream(jsonFilePath), "UTF8"), valueType)
}