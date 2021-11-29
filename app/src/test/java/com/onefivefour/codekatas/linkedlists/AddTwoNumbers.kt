package com.onefivefour.codekatas.linkedlists

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class AddTwoNumbers {


    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {

        val result = ListNode(0)
        var currentDigitNode : ListNode? = result
        var overflow = 0
        
        var list1 = l1
        var list2 = l2

        while (list1 != null || list2 != null) {

            val digit1 = list1?.`val` ?: 0
            val digit2 = list2?.`val` ?: 0

            val digit = digit1 + digit2 + overflow

            overflow = digit / 10

            currentDigitNode?.`val` = digit % 10

            if (overflow > 0 || list1?.next != null || list2?.next != null) {
                currentDigitNode?.next = ListNode(overflow)
                currentDigitNode = currentDigitNode?.next
            }

            list1 = list1?.next
            list2 = list2?.next
            
        }


        return result
        

    }


    @Test
    fun test1() {
        val a1 = ListNode(2)
        val a2 = ListNode(4)
        val a3 = ListNode(3)
        
        val b1 = ListNode(5)
        val b2 = ListNode(6)
        val b3 = ListNode(4)

        a1.next = a2
        a2.next = a3
        
        b1.next = b2
        b2.next = b3

        val result = addTwoNumbers(a1, b1)        

        assertThat(result.`val`).isEqualTo(7)
        assertThat(result.next?.`val`).isEqualTo(0)
        assertThat(result.next?.next?.`val`).isEqualTo(8)
    }

    
    @Test
    fun test2() {
        val a1 = ListNode(9)
        val a2 = ListNode(9)
        
        val b1 = ListNode(9)
        val b2 = ListNode(9)
        val b3 = ListNode(9)
        val b4 = ListNode(9)

        a1.next = a2
        
        b1.next = b2
        b2.next = b3
        b3.next = b4

        val result = addTwoNumbers(a1, b1)        

        assertThat(result.`val`).isEqualTo(8)
        assertThat(result.next?.`val`).isEqualTo(9)
        assertThat(result.next?.next?.`val`).isEqualTo(0)
        assertThat(result.next?.next?.next?.`val`).isEqualTo(0)
        assertThat(result.next?.next?.next?.next?.`val`).isEqualTo(1)
    }




} 