package com.onefivefour.codekatas.linkedlists

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.
 */
class DeleteNodeInLinkedList {


    /**
     * Recursive approach
     */
    fun deleteNode(node: ListNode?) {

        if (node == null) return

        // copy the value from the next node and then...
        node.`val` = node.next!!.`val`

        // ...ignore the next node. Basically "deleting" the next node after copying its value
        node.next = node.next!!.next

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

        deleteNode(a2)

        assertThat(a2.`val`).isEqualTo(1)
        assertThat(a2.next?.`val`).isEqualTo(9)
        assertThat(a2.next?.next).isNull()
    }

    @Test
    fun test2() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(3)
        val a4 = ListNode(4)

        a1.next = a2
        a2.next = a3
        a3.next = a4

        deleteNode(a3)

        assertThat(a3.`val`).isEqualTo(4)
        assertThat(a3.next).isNull()
    }

    @Test
    fun test3() {
        val a1 = ListNode(0)
        val a2 = ListNode(1)

        a1.next = a2

        deleteNode(a1)

        assertThat(a1.`val`).isEqualTo(1)
        assertThat(a1.next).isNull()
    }

    @Test
    fun test4() {
        val a1 = ListNode(-3)
        val a2 = ListNode(5)
        val a3 = ListNode(-99)

        a1.next = a2
        a2.next = a3

        deleteNode(a1)

        assertThat(a1.`val`).isEqualTo(5)
        assertThat(a1.next?.`val`).isEqualTo(-99)
        assertThat(a1.next?.next).isNull()
    }

} 