package com.onefivefour.codekatas.math

class FizzBuzz {

    fun fizzBuzz(n: Int): List<String> {

        val result = mutableListOf<String>()

        for (i in 1 .. n) {
            if (i % 15 == 0) {result.add("FizzBuzz")}
            else if (i %  3 == 0) {result.add("Fizz")}
            else if (i %  5 == 0) {result.add("Buzz")}
            else { result.add(i.toString())}
        }

        return result
    }
    
    
}