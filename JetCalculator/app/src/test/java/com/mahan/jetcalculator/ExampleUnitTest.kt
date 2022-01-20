package com.mahan.jetcalculator

import com.mahan.jetcalculator.utils.Utils.evaluate
import org.junit.Test

import org.junit.Assert.*
import java.lang.UnsupportedOperationException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun number() {
        assertEquals(245, evaluate("245"))
    }

    @Test
    fun simple_addition() {
        assertEquals(4, evaluate("2+2"))
    }

    @Test
    fun simple_reduction() {
        assertEquals(5, evaluate("10-5"))
    }

    @Test
    fun addition_reduction() {
        assertEquals(3, evaluate("3+4-4"))
    }

    @Test
    fun simple_multiply() {
        assertEquals(9, evaluate("3*3"))
    }

    @Test
    fun simple_divide() {
        assertEquals(5, evaluate("20/4"))
    }

    @Test
    fun divide_by_zero() {
        assertEquals(UnsupportedOperationException(), evaluate("4/0"))
    }

    @Test
    fun multiply_divide() {
        assertEquals(10, evaluate("4*5/2"))
    }

    @Test
    fun simple_expression() {
        assertEquals(11, evaluate("3+4*4/2"))
    }
}