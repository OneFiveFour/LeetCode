package com.onefivefour.codekatas.linkedlists

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given the head of a singly linked list, return true if it is a palindrome.
 */
class PalindromeLinkedList {


    fun isPalindrome(head: ListNode?): Boolean {
        
        if (head == null) return false
        
        var fast = head
        var slow = head
        
        // find middle node
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next            
        }
        
        // slow is now in the middle. Reverse the list from here
        var previous : ListNode? = null
        while (slow != null) {
            
            val temp = slow.next
            slow.next = previous
            previous = slow
            slow = temp
            
        }
        
        // 2nd haf of list is reversed. compare it with first half
        var left = head
        var right = previous
        while (right != null){
            
            if (right.`val` != left?.`val`) return false

            left = left.next
            right = right.next
            
        }
        
        return true
        
    }


    fun isPalindrome2(head: ListNode?): Boolean {

        if (head == null) return false

        var head2 = head
        val list = mutableListOf<Int>()

        while (head2 != null) {
            list.add(head2.`val`)
            head2 = head2.next
        }
        
        var left = 0
        var right = list.lastIndex
        
        while (left < right) {
            
            if (list[left] != list[right]) {
                return false
            }
            
            left++
            right--
            
        }
        
        return true

    }


    @Test
    fun test1() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(2)
        val a4 = ListNode(1)

        a1.next = a2
        a2.next = a3
        a3.next = a4

        val result = isPalindrome(a1)

        assertThat(result).isTrue()
    }

    @Test
    fun test2() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(3)
        val a4 = ListNode(1)

        a1.next = a2
        a2.next = a3
        a3.next = a4

        val result = isPalindrome(a1)

        assertThat(result).isFalse()
    }


} 