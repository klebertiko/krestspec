package br.com.itau.internet.mobile.teste.integrado.specs.privadas

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertTrue

/**
 * Created by kleber on 18/05/17.
 */
@RunWith(JUnitPlatform::class)
class SimpleDescribeSpec : Spek({

    describe("um numero") {
        var number = 0

        beforeEachTest {
            number++
        }

        it("should be 1") {
            assertTrue(number == 1)
        }

        it("should be 3") {
            assertTrue(number == 3)
        }

        afterEachTest {
            number++
        }
    }
})