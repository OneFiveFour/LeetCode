package com.onefivefour.codekatas.arrays

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
class MeetingRooms2 {


    private val rooms = ArrayList<LinkedList<IntArray>>()

    private fun minMeetingRooms(intervals: Array<IntArray>): Int {

        if (intervals.isEmpty()) return 0

        intervals.sortBy { it[0] }

        for (interval in intervals) {

            var needsNewRoom = true

            for (i in 0 .. rooms.lastIndex) {

                if (interval[0] >= rooms[i].last[1]) {
                    scheduleInRoom(i, interval)
                    needsNewRoom = false
                    break
                }
            }

            if (needsNewRoom) {
                scheduleInRoom(rooms.size, interval)
            }

        }

        return rooms.size

    }


    private fun scheduleInRoom(index: Int, interval: IntArray) {

        if (rooms.lastIndex < index) {
            rooms.add(LinkedList<IntArray>().apply { addLast(interval) })
        } else {
            rooms[index].addLast(interval)
        }


    }


    @Test
    fun test1() {
        val nums = arrayOf(
            intArrayOf(0,30),
            intArrayOf(5,10),
            intArrayOf(15,20)
        )
        
        val result = minMeetingRooms(nums)

        assertThat(result).isEqualTo(2)
    }
    
    @Test
    fun test2() {
        val nums = arrayOf(
            intArrayOf(7,10),
            intArrayOf(2,4)
        )
        
        val result = minMeetingRooms(nums)

        assertThat(result).isEqualTo(1)
    }
    
    @Test
    fun test3() {
        val nums = arrayOf(
            intArrayOf(0,2),
            intArrayOf(1,3),
            intArrayOf(4,8),
            intArrayOf(9,13),
            intArrayOf(6,7),
            intArrayOf(8,9),
            intArrayOf(7,10)
        )
        
        val result = minMeetingRooms(nums)

        assertThat(result).isEqualTo(3)
    }
    
    @Test
    fun test4() {
        val nums = arrayOf(
            intArrayOf(300,5870),
            
            intArrayOf(518,2918),
            
            intArrayOf(848,3846),
            
            intArrayOf(1293,2986),
            
            intArrayOf(4284,5907),
            intArrayOf(4466,4781),
        )
        
        val result = minMeetingRooms(nums)

        assertThat(result).isEqualTo(4)
    }

}