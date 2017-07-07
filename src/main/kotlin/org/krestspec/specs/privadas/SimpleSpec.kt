package br.com.itau.internet.mobile.teste.integrado.specs.privadas

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

/**
 * Created by kleber on 18/05/17.
 */
@RunWith(JUnitPlatform::class)
class SimpleSpec : Spek({

    given("uma string") {
        var string = "palavra.errada"

        beforeEachTest {
            println("Antes de cada on()")
        }

        on("split by .") {

            var splitted = string.split(".")

            it("should not be null") {
                assertNotNull(splitted)
                println("Teste 1 - 1")
            }

            it("should has length 2") {
                assertEquals(2, splitted.size)
                println("Teste 1 - 2")
            }

            it("splitted[0] should be equals palavra") {
                assertEquals("palavra", splitted[0])
                println("Teste 1 - 3")
            }

            it("splitted[1] should be equals errada") {
                assertEquals("errada", splitted[1])
                println("Teste 1 - 4")
            }
        }

        on("string.length") {
            var length = string.length

            it("should not be null") {
                assertNotNull(length)
                println("Teste 2 - 1")
            }
        }

        afterEachTest {
            string = "banana.maça"
            println("Apos cada on()")
        }
    }
})