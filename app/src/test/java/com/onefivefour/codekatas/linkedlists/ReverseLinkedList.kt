package com.onefivefour.codekatas.linkedlists

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
class ReverseLinkedList {


    /**
     * Iterative approach
     */
    fun reverseList2(head: ListNode?): ListNode? {

        var prev: ListNode? = null
        var current = head

        while (current != null) {
            // store next node for later
            val next = current.next

            // reverse order
            current.next = prev

            // move prev and current forward
            prev = current
            current = next

        }

        return prev

    }

    /**
     * Recursive approach
     */
    private fun reverseList(head: ListNode?): ListNode? {

        if (head?.next == null) return head

        val reversedList = reverseList(head.next)

        head.next!!.next = head
        head.next = null

        return reversedList

    }


    @Test
    fun test1() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(3)
        val a4 = ListNode(4)

        a1.next = a2
        a2.next = a3
        a3.next = a4

        val result = reverseList(a1)

        assertThat(result?.`val`).isEqualTo(4)
        assertThat(result?.next?.`val`).isEqualTo(3)
        assertThat(result?.next?.next?.`val`).isEqualTo(2)
        assertThat(result?.next?.next?.next?.`val`).isEqualTo(1)
    }

} 