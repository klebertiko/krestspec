package br.com.itau.internet.mobile.teste.integrado.specs

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.api.include
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

/**
 * Created by kleber on 20/06/17.
 */
@RunWith(JUnitPlatform::class)
class SimpleUseOfSharedSpec : Spek({

    include(SimpleSharedSpec)

    given("numero = 1") {
        var numero = 1

        println("execucao 1 ")

        beforeEachTest {
            println("execucao 2 ")
        }

        on("some + 1") {

            var soma = numero + 1
            println("execucao 3 ")

            it("deve retornar 2") {
                assertEquals(2, soma)
                println("execucao 4 ")
            }
        }

        afterEachTest {
            println("execucao 6 ")
        }
    }
})
