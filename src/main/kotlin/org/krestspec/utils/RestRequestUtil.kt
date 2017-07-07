package org.krestspec.utils

import io.restassured.RestAssured
import io.restassured.config.ObjectMapperConfig.objectMapperConfig
import io.restassured.http.Header
import io.restassured.http.Headers
import io.restassured.mapper.ObjectMapperType
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import org.krestspec.dto.RestRequestData
import java.nio.file.Paths
import kotlin.properties.Delegates

/**
 * Created by kleber on 07/07/17.
 */
object RestRequestUtil : RestAssured() {

    var aux: String by Delegates.observable("") {
        _, old, new ->
        println("aux: $old -> aux: $new")
    }

    init {
        val testConfiguration = loadFromYaml(Paths.get("src/test/resources/rest-configuration.yml"))
        config = config().objectMapperConfig(objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON))
        baseURI = testConfiguration["baseURI"].toString()
        basePath = testConfiguration["basePath"].toString()
    }

    fun fillRequest(restRequestData: RestRequestData): RequestSpecification {
        return given().
                headers(this.fillRestDefaultRequestHeaders()).
                pathParams(mutableMapOf<String, Object>()).
                queryParams(mutableMapOf<String, Object>())
    }

    fun getRequest(restRequestData: RestRequestData): Response {
        return given().
                body(restRequestData).
                get()
                .also { response -> this.fillAuxValueFrom(response) }
    }

    fun postRequest(restRequestData: RestRequestData): Response {
        return given().
                body(restRequestData).
                post()
                .also { response -> this.fillAuxValueFrom(response) }
    }

    fun putRequest(restRequestData: RestRequestData): Response {
        return given().
                body(restRequestData).
                put()
                .also { response -> this.fillAuxValueFrom(response) }
    }

    fun deleteRequest(restRequestData: RestRequestData): Response {
        return given().
                body(restRequestData).
                delete()
                .also { response -> this.fillAuxValueFrom(response) }
    }

    fun optionsRequest(restRequestData: RestRequestData): Response {
        return given().
                body(restRequestData).
                options()
                .also { response -> this.fillAuxValueFrom(response) }
    }

    fun patchRequest(restRequestData: RestRequestData): Response {
        return given().
                body(restRequestData).
                patch()
                .also { response -> this.fillAuxValueFrom(response) }
    }

    fun headRequest(restRequestData: RestRequestData): Response {
        return given().
                body(restRequestData).
                head()
                .also { response -> this.fillAuxValueFrom(response) }
    }

    fun fillRestDefaultRequestHeaders(): Headers {
        val defaultHeaders: MutableList<Header> = mutableListOf()
        loadFromYaml(Paths.get("src/test/resources/rest-default-headers.yml")).forEach {
            entry ->
            defaultHeaders.add(Header(entry.key.toString(), entry.value.toString()))
        }
        return Headers(defaultHeaders)
    }

    fun fillAuxValueFrom(response: Response) {

    }
}