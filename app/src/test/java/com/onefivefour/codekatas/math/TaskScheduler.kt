package com.onefivefour.codekatas.math

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.
 */
class TaskScheduler {

    private fun leastInterval(tasks: CharArray, n: Int): Int {

        // count frequency of tasks
        val taskFrequencies = IntArray(26)

        for (task in tasks) {
            val index = task - 'A'
            taskFrequencies[index] += 1
        }

        var maxFrequency = 0
        for (taskFrequency in taskFrequencies) {
            if (taskFrequency > maxFrequency) {
                maxFrequency = taskFrequency
            }
        }

        var maxCount = 0
        for (taskFrequency in taskFrequencies) {
            if (taskFrequency == maxFrequency) {
                maxCount++
            }
        }


        return Math.max(tasks.size, (maxFrequency - 1) * (n + 1) + maxCount)


    }


    @Test
    fun test1() {
        val input1 = charArrayOf('A','A','A','B','B','B')
        val input2 = 2
        
        val result = leastInterval(input1, input2)

        assertThat(result).isEqualTo(8)
    }


    
}