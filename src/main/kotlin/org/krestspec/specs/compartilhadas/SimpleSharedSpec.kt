package br.com.itau.internet.mobile.teste.integrado.specs

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

/**
 * Created by kleber on 20/06/17.
 */
@RunWith(JUnitPlatform::class)
object SimpleSharedSpec : Spek({

    given("uma string") {
        var string = "palavra.errada"

        println("execucao 1 ")

        beforeEachTest {
            println("execucao 2 ")
        }

        on("split by .") {

            var splitted = string.split(".")
            println("execucao 3 ")

            it("should not be null") {
                assertNotNull(splitted)
                println("execucao 4 ")
            }

            it("should has length 2") {
                assertEquals(2, splitted.size)
                println("execucao 5 ")
            }
        }

        afterEachTest {
            println("execucao 6 ")
        }
    }
})
