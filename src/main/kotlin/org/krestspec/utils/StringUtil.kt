@file:JvmName("StringUtil")

package org.krestspec.utils

import org.apache.commons.lang3.StringUtils

/**
 * Created by kleber on 19/06/17.
 */
fun String.leftPad(padChar: Char, size: Int): String? {
    return StringUtils.leftPad(this, size, padChar)
}

fun String.rightPad(padChar: Char, size: Int): String? {
    return StringUtils.rightPad(this, size, padChar)
}