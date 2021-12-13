package com.onefivefour.codekatas.trees

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

class PopulatingNextRightPointersInEachNode {
    
    
    private fun connect(root: Node?): Node? {

        if (root == null) return null

        val queue =  LinkedList<Node>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            
            val levelSize = queue.size

            for (i in 0 until levelSize) {
                
                val node = queue.poll()!!
                
                if (i < levelSize - 1) {
                    node.next = queue.peek()
                }
                
                if (node.left != null) {
                    queue.add(node.left!!)
                }
                
                if (node.right != null) {
                    queue.add(node.right!!)
                }
                
            }
        }


        return root

    }
    
    
    @Test
    fun test1() {
        val input = Node(1).apply { 
            left = Node(2).apply { 
                left = Node(4)
                right = Node(5)
            }
            right = Node(3).apply { 
                left = Node(6)
                right = Node(7)
            }
        }
        
        val result = connect(input)
        
        assertThat(result).isEqualTo(listOf(1, 3, 2))
    }
    
    
}