package com.onefivefour.codekatas.linkedlists

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 */
class IntersectionOfTwoLinkedLists {


    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        
        val visited = HashSet<ListNode>()
        
        var listA = headA
        var listB = headB
        
        while (listA != null) {
            visited.add(listA)
            listA = listA.next
        }
        
        while (listB != null) {
            if (visited.contains(listB)) return listB
            listB = listB.next
        }
        
        return null
        
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
        
        val b1 = ListNode(5)
        val b2 = ListNode(6)
        
        b1.next = b2
        b2.next = a3

        val result = getIntersectionNode(a1, b1)
        
        assertThat(result).isEqualTo(a3)

    }


} 