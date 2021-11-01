package com.onefivefour.codekatas.linkedlists

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
class RemoveNthNode {


    private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        val start = ListNode(-1)
        start.next = head
        
        var fast : ListNode? = start
        var slow : ListNode? = start
        
        for (i in 1 .. n) {
            fast = fast?.next
        }
        
        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }
        
        slow?.next = slow?.next?.next 
        
        return start.next

    }


    @Test
    fun test1() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(3)
        val a4 = ListNode(4)
        val a5 = ListNode(5)

        a1.next = a2
        a2.next = a3
        a3.next = a4
        a4.next = a5

        removeNthFromEnd(a1, 2)

        assertThat(a3.next).isEqualTo(a5)
    }

    @Test
    fun test2() {
        val a1 = ListNode(1)

        val result = removeNthFromEnd(a1, 1)

        assertThat(result).isNull()
    }


    @Test
    fun test3() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)

        a1.next = a2

        removeNthFromEnd(a1, 1)

        assertThat(a1.next).isNull()
    }

    @Test
    fun test4() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)

        a1.next = a2

        val result = removeNthFromEnd(a1, 2)

        assertThat(result).isEqualTo(a2)
    }
}