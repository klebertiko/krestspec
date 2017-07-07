@file:JvmName("FileUtil")

package org.krestspec.utils

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.nio.file.Files
import java.nio.file.Path

/**
 * Created by kleber on 19/06/17.
 */
fun loadFromYaml(path: Path): Map<*, *> {
    val mapper = ObjectMapper(YAMLFactory())
    mapper.registerModule(KotlinModule())

    return Files.newBufferedReader(path).use {
        mapper.readValue(it, Map::class.java)
    }
}

fun loadFromJson(path: Path): Map<*, *> {
    val mapper = ObjectMapper(JsonFactory())
    mapper.registerModule(KotlinModule())

    return Files.newBufferedReader(path).use {
        mapper.readValue(it, Map::class.java)
    }
}

fun loadFromProperties(path: Path): Map<*, *> {
    val mapper = ObjectMapper(JavaPropsFactory())
    mapper.registerModule(KotlinModule())

    return Files.newBufferedReader(path).use {
        mapper.readValue(it, Map::class.java)
    }
}
