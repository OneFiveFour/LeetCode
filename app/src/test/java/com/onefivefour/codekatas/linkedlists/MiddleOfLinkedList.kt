package com.onefivefour.codekatas.linkedlists

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
 */
class MiddleOfLinkedList {


    private fun middleNode(head: ListNode?): ListNode? {
        
        head ?: return null

        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next?.next
        }
        
        return slow
    }


    @Test
    fun test1() {
        val a1 = ListNode(1)
        val a2= ListNode(2)
        val a3= ListNode(3)
        val a4= ListNode(4)
        val a5= ListNode(5)
        
        a1.next = a2
        a2.next = a3
        a3.next = a4
        a4.next = a5
        
        val result = middleNode(a1)

        assertThat(result).isEqualTo(a3)
    }


    @Test
    fun test2() {
        val a1 = ListNode(1)
        val a2= ListNode(2)
        val a3= ListNode(3)
        val a4= ListNode(4)
        val a5= ListNode(5)
        val a6= ListNode(6)

        a1.next = a2
        a2.next = a3
        a3.next = a4
        a4.next = a5
        a5.next = a6

        val result = middleNode(a1)

        assertThat(result).isEqualTo(a4)
    }
}