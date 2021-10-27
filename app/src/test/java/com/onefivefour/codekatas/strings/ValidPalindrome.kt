package com.onefivefour.codekatas.strings

import com.google.common.truth.Truth
import org.junit.Test

/**
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
class ValidPalindrome {

    private fun isPalindrome(s: String): Boolean {

        val validChars = charArrayOf(
            'A','B','C','D','E','F','G','H','I','J',
            'K','L','M','N','O','P','Q','R','S','T',
            'U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j',
            'k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z',
            '0','1','2','3','4','5','6','7','8','9'
        )

        var left = 0
        var right = s.lastIndex
        
        while (left < right) {

            var leftChar = s[left]
            var rightChar = s[right]
            
            if (!validChars.contains(leftChar)) {
                left++
                continue
            }

            if (!validChars.contains(rightChar)) {
                right--
                continue
            }

            val indexOfLeftChar = validChars.indexOf(leftChar)
            if (indexOfLeftChar > -1 && indexOfLeftChar < 26) {
                leftChar = validChars[indexOfLeftChar + 26]
            }

            val indexOfRightChar = validChars.indexOf(rightChar)
            if (indexOfRightChar > -1 && indexOfRightChar < 26) {
                rightChar = validChars[indexOfRightChar + 26]
            }
            
            if (!leftChar.equals(rightChar, true)) {
                return false
            } else {
                left++
                right --
            }
                
        }
        
        return true
    }


    @Test
    fun test1() {
        val input1 = "A man, a plan, a canal: Panama"

        val result = isPalindrome(input1)

        Truth.assertThat(result).isEqualTo(true)
    }

    @Test
    fun test2() {
        val input1 = "race a car"   

        val result = isPalindrome(input1)

        Truth.assertThat(result).isEqualTo(false)
    }



}
