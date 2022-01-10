package com.onefivefour.codekatas.design

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
class RandomizedSet() {
    
    private val indexMap = HashMap<Int, Int>()
    private val dataList = ArrayList<Int>()

    fun insert(`val`: Int): Boolean {
        if (indexMap.containsKey(`val`)) return false

        indexMap[`val`] = dataList.size
        dataList.add(dataList.size, `val`)
        
        return true
    }

    fun remove(`val`: Int): Boolean {
        
        val indexOfVal = indexMap[`val`] ?: return false
        dataList[indexOfVal] = dataList.last()
        dataList.remove(dataList.lastIndex)
        indexMap.remove(`val`)
        
        return true
    }

    fun getRandom(): Int {
        val randomIndex = Random.nextInt(dataList.indices)
        return dataList[randomIndex]
    }
    
    @Test
    fun test1() {
        val randomizedSet = RandomizedSet()
        
        assertThat(randomizedSet.insert(3)).isTrue()
        assertThat(randomizedSet.insert(-2)).isTrue()
        assertThat(randomizedSet.remove(2)).isFalse()
        assertThat(randomizedSet.insert(1)).isTrue()
        assertThat(randomizedSet.insert(-3)).isTrue()
        assertThat(randomizedSet.insert(-2)).isFalse()
        assertThat(randomizedSet.remove(-2)).isTrue()
        assertThat(randomizedSet.remove(3)).isTrue()
        assertThat(randomizedSet.insert(-1)).isTrue()
        assertThat(randomizedSet.remove(-3)).isTrue()
        assertThat(randomizedSet.insert(1)).isFalse()
        assertThat(randomizedSet.insert(-2)).isTrue()
        assertThat(randomizedSet.insert(-2)).isFalse()
        assertThat(randomizedSet.insert(-2)).isFalse()
        assertThat(randomizedSet.insert(1)).isFalse()
        
        assertThat(randomizedSet.getRandom()).isEqualTo(-2)
        
        assertThat(randomizedSet.insert(-2)).isFalse()
        assertThat(randomizedSet.remove(0)).isFalse()
        assertThat(randomizedSet.insert(-3)).isTrue()
        assertThat(randomizedSet.insert(1)).isFalse()
        


    }
    
    
}


