package com.onefivefour.codekatas

import junit.framework.Assert.assertEquals
import org.junit.Test

class ConvertToCamelCase {

    private fun toCamelCase(str: String): String {

        return when {
            str.isEmpty() -> return ""
            else -> {
                str
                    .split("[_,-]".toRegex())
                    .mapIndexed { index, s -> 
                        if (index > 0) s.replaceFirstChar { it.uppercase() } else s }
                    .joinToString("")
            }
        }
    }

    @Test
    fun testFixed() {
        assertEquals("", toCamelCase(""))
        assertEquals("theStealthWarrior", toCamelCase("the_stealth_warrior"))
        assertEquals("TheStealthWarrior", toCamelCase("The-Stealth-Warrior"))
        assertEquals("ABC", toCamelCase("A-B-C"))
        
        for (i in 0..10) {
            
        }
    }
}