package com.onefivefour.codekatas.math

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Create a function taking a positive integer as its parameter and returning a string containing the Roman Numeral representation of that integer.
 * 
 * Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. 
 * In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 
 * 2008 is written as 2000=MM, 8=VIII; or MMVIII. 
 * 1666 uses each Roman symbol in descending order: MDCLXVI.
 */
class IntegerToRoman {


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