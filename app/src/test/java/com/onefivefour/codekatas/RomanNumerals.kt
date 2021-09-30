package com.onefivefour.codekatas

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RomanNumerals {


    fun encode(num: Int): String {

        return num.toString()
            .toCharArray() // split into single chars
            .reversed() // reverse so that we ensure to go from ones to (ten)-thousands
            .mapIndexed { index, digit ->

                val value = Character.getNumericValue(digit)

                when (index) {
                    0 -> get(value, "I", "V", "X") // ones
                    1 -> get(value, "X", "L", "C") // tens
                    2 -> get(value, "C", "D", "M") // hundreds
                    else -> getThousands(value) // thousands
                }
            }
            .reversed() // reverse back to correct order of digits
            .joinToString("") // join char array to final output
    }



    private fun get(value: Int, oneChar: String, fiveChar: String, tenChar: String): String {
        return when {
            value <= 3 -> oneChar.repeat(value)
            value == 4 -> oneChar + fiveChar
            value <= 8 -> fiveChar + oneChar.repeat(value - 5)
            value == 9 -> oneChar + tenChar
            else -> ""
        }
    }


    private fun getThousands(thousands: Int): String {
        return "M".repeat(thousands)
    }


    @Test
    fun basic() {
        assertEquals("", encode(0))
        assertEquals("I", encode(1))
        assertEquals("XXI", encode(21))
        assertEquals("MMVIII", encode(2008))
        assertEquals("MDCLXVI", encode(1666))
    }
}