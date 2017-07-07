package org.krestspec.dto

/**
 * Created by kleber on 07/07/17.
 */
data class RestRequestData(var apiURL: String, var headers: MutableList<MutableMap>, var paths: MutableList<MutableMap>, var querys: MutableList<MutableMap>, var body: String, var method: String)