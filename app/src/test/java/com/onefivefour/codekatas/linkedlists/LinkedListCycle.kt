package com.onefivefour.codekatas.linkedlists

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */
class LinkedListCycle {


    fun hasCycle2(head: ListNode?): Boolean {
        
        var head2 = head

        val visited = mutableMapOf<ListNode, Boolean>()
        
        while (head2 != null) {
            
            if (visited[head2] == true) {
                return true
            }
            
            visited[head2] = true

            head2 = head2.next
            
        }
        
        return false
    }
    
    fun hasCycle(head: ListNode?): Boolean {
        
        var slow = head
        var fast = head?.next
        
        while (fast?.next != null) {
            
            if (slow == fast) {
                return true
            }
            
            slow = slow?.next
            fast = fast.next?.next
            
        }
        
        return false
    }


    @Test
    fun test1() {
        val a1 = ListNode(4)
        val a2 = ListNode(5)
        val a3 = ListNode(1)
        val a4 = ListNode(9)

        a1.next = a2
        a2.next = a3
        a3.next = a4
        a4.next = a2

        val result = hasCycle(a1)

        assertThat(result).isTrue()
    }


    @Test
    fun test2() {
        val a1 = ListNode(4)
        val a2 = ListNode(5)
        val a3 = ListNode(1)
        val a4 = ListNode(9)

        a1.next = a2
        a2.next = a3
        a3.next = a4

        val result = hasCycle(a1)

        assertThat(result).isFalse()
    }


} 