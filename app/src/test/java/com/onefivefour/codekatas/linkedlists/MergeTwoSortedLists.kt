package com.onefivefour.codekatas.linkedlists

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */
class MergeTwoSortedLists {


    /**
     * Iterative approach
     */
    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        
        // make sure each list has at least one element
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1

        // work with two pointers - one for each list        
        var left = l1
        var right = l2
        
        // initialise result -> the starting node with the lowest value
        val result: ListNode
        if (left.`val` < right.`val`) {
            result = left
            left = left.next // move left further
        } else {
            result = right
            right = right.next // move right further
        }
        
        // use tail to add upcoming nodes to result
        var tail = result

        while (true) {
            
            if (left == null && right == null) {
                // reached end on both lists
                break
            }
            
            if (left == null) {
                // reached end on left list -> add remaining nodes of right
                tail.next = right
                break
            }
            
            if (right == null) {
                // reached end on right list -> add remaining nodes of left
                tail.next = left
                break                
            }
            
            
            // add lower value to tail (i.e. result), move forward in according list
            if (left.`val` < right.`val`) {
                tail.next = left
                left = left.next
            } else {
                tail.next = right
                right = right.next
            }
            
            
            tail = tail.next!!

        }

        return result
    }

    /**
     * Recursive approach
     */
    fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1==null && l2==null) return null
        if(l1==null) return l2
        if(l2==null) return l1
        if(l1.`val`<=l2.`val`){
            l1.next=mergeTwoLists(l1.next,l2)
            return l1
        }
        l2.next=mergeTwoLists(l1,l2.next)
        return l2
    }

    @Test
    fun test1() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(5)
        val a4 = ListNode(6)

        a1.next = a2
        a2.next = a3
        a3.next = a4

        val b1 = ListNode(2)
        val b2 = ListNode(3)
        val b3 = ListNode(4)
        val b4 = ListNode(6)

        b1.next = b2
        b2.next = b3
        b3.next = b4

        val result = mergeTwoLists(a1, b1)

        assertThat(result?.`val`).isEqualTo(1)
        assertThat(result?.next?.`val`).isEqualTo(2)
        assertThat(result?.next?.next?.`val`).isEqualTo(2)
        assertThat(result?.next?.next?.next?.`val`).isEqualTo(3)
        assertThat(result?.next?.next?.next?.next?.`val`).isEqualTo(4)
        assertThat(result?.next?.next?.next?.next?.next?.`val`).isEqualTo(5)
        assertThat(result?.next?.next?.next?.next?.next?.next?.`val`).isEqualTo(6)
        assertThat(result?.next?.next?.next?.next?.next?.next?.next?.`val`).isEqualTo(6)
    }
    
    @Test
    fun test2() {
        
        val result = mergeTwoLists(null, null)

        assertThat(result?.`val`).isEqualTo(null)
        
    }
    
    @Test
    fun test3() {
        
        val result = mergeTwoLists(null,ListNode(0))

        assertThat(result?.`val`).isEqualTo(0)
        
    }
} 