package com.onefivefour.codekatas.linkedlists

import org.junit.Test

/**
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */
class OddEvenLinkedList {


    fun oddEvenList(head: ListNode?): ListNode? {
        
        if (head == null) return null
        if (head.next == null) return head
        
        val oddStart = ListNode(0)
        val evenStart = ListNode(0)
        
        var oddList : ListNode?  = oddStart 
        var evenList : ListNode? = evenStart
        
        var currentNode = head
        var i = 1
        
        while (currentNode != null) {
            
            if (i % 2 == 1) {
                oddList?.next = currentNode
                oddList = oddList?.next
            } else {
                evenList?.next = currentNode
                evenList = evenList?.next
            }
            
            i++
            currentNode = currentNode.next
            
        }
        
        evenList?.next = null
        oddList?.next = evenStart.next
        
        return oddStart.next
    }



    @Test
    fun test1() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(3)
        val a4 = ListNode(4)
        val a5 = ListNode(5)
        val a6 = ListNode(6)
        val a7 = ListNode(7)

        a1.next = a2
        a2.next = a3
        a3.next = a4
        a4.next = a5
        a5.next = a6
        a6.next = a7

        val result = oddEvenList(a1)

    }


} 