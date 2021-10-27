package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test
import java.lang.NumberFormatException

/**
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
class StrStr {

    private fun strStr(haystack: String, needle: String): Int { 
        
        if (needle.isEmpty()) return 0
        
        for (i in haystack.indices) {
            
            if (haystack[i] == needle[0]) {
                
                for (j in needle.indices) {
                    
                    if (i + j > haystack.lastIndex) {
                        // needle is now longer than haystack
                        return -1
                    } 
                    
                    if (needle[j] == haystack[i+j]) {
                        if (j == needle.lastIndex) {
                            // found the needle
                            return i
                        }
                    } else {
                        break
                    }
                    
                }
                
            }
            
        }
        
        return -1
        
        
    }


    @Test
    fun test1() {
        val input1 = "hello"
        val input2 = "ll"        

        val result = strStr(input1, input2)

        Truth.assertThat(result).isEqualTo(2)
    }


    @Test
    fun test2() {
        val input1 = "aaaaa"
        val input2 = "bba"     

        val result = strStr(input1, input2)

        Truth.assertThat(result).isEqualTo(-1)
    }


    @Test
    fun test3() {
        val input1 = ""
        val input2 = ""        

        val result = strStr(input1, input2)

        Truth.assertThat(result).isEqualTo(0)
    }


    @Test
    fun test4() {
        val input1 = "a"
        val input2 = ""        

        val result = strStr(input1, input2)

        Truth.assertThat(result).isEqualTo(0)
    }


    @Test
    fun test5() {
        val input1 = "aaa"
        val input2 = "aaaa"        

        val result = strStr(input1, input2)

        Truth.assertThat(result).isEqualTo(-1)
    }

    


}
