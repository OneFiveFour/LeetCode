package com.onefivefour.codekatas.binarysearch

import com.google.common.truth.Truth
import org.junit.Test

/**
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
class FirstBadVersion {
    
    private fun firstBadVersion(n: Int) : Int {
        var left = 1
        var right = n   
        
        while (left < right) {
            val mid = left + (right - left) / 2
            
            if (isBadVersion(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        
        return left 
    }
    


    @Test
    fun test1() {
        val result = firstBadVersion(5)

        Truth.assertThat(result).isEqualTo(4)
    }


    private fun isBadVersion(int: Int) : Boolean {
        if (int < 4) return false
        return true
    }

    
    @Test
    fun test2() {
        val result = firstBadVersion(1)

        Truth.assertThat(result).isEqualTo(1)
    }


    private fun isBadVersion2(int: Int) : Boolean {
        return true
    }

}
