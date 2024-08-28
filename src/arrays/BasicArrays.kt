package arrays

import kotlin.math.abs

class BasicArrays {

    /**
     * To initialize the array in Kotlin - 1D.
     */
    private val array1 = arrayOf(1, 2, 3, 4, 5) // Array<Int>
    private val array2 = listOf(3, 5, 8, 9).toTypedArray() // IntArray()
    private val array3 = IntArray(10) { it -> it * 2 } //IntArray()


    /**
     * To Initialize the 2D Array in Kotlin - 2D
     */
    private val array4 = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    private val array5 = Array(3) { IntArray(3) } // this will give the array 3X3


    /**
     * To print the array in kotlin
     */
    fun printArray() {
        //Method 1
        for (element in array1) {
            print("$element ")
        }

        //Method 2
        array2.forEach { it -> print("$it ") }

        //Method 3
        print(array3.joinToString())
    }

    fun print2DArray() {

        for (rows in array4) {
            println(rows.contentToString())
        }

        array4.forEach { row ->
            row.forEach { column ->
                print("$column, ")
            }
            println()
        }

        for (i in array4.indices) {
            for (j in array4[i].indices) {
                print("${array4[i][j]} ")
            }
            println()
        }
        var number = 0
        for (i in array4.indices) {
            for (j in array4[i].indices) {
                number += array4[i][j]
            }
        }
        print(number)
    }

    /**
     * find the last second digit in an array
     */
    fun findLastSecondDigit(arr: IntArray): Int{
       return arr[arr.size-2]
    }


    /**
     * calculate the sum of the array
     * @param [2,5,6,8]
     * @return [2,7,13,21]
     */
    fun calcSumOfArray(arr: IntArray): IntArray {
        for (i in 1 until arr.size) {
            arr[i] += arr[i - 1]
        }
        return arr
    }

    /**
     * Sum of the array
     * @param arr an integer array
     * @return  integer value of the array sum.
     */
    fun sumFromOne(arr: IntArray): Int {
        return arr.reduce { sum, element -> sum + element }
    }

    /**
     * find the Consequence in a binary array
     * @param  [1,0,1,1,0,1,1,1,0]
     * @return  3
     */
    fun findConsequenceOfArray(arr: IntArray): Int {
        var temp = 0
        var max = 0

        for (i in arr) {
            if (i == 0) {
                max = Math.max(max, temp)
                temp = 0
            } else {
                temp++
            }
        }
        return Math.max(max, temp)
    }

    fun findEvenNumbers(arr: IntArray): Int {
        var eventNumber = 0
        arr.forEach {
            var acc = 0;
            var cur = it
            while (cur != 0) {
                cur /= 10
                acc++
            }
            if (acc % 2 == 0) eventNumber++
        }
        return eventNumber
    }


    /**
     * Square of the sorted Array
     * @param [-4,-1,0,3,10]
     * @return [0,1,9,16,100]
     * Solution No - 1
     */
    fun squareOfSortedArray(arr: IntArray): IntArray {
        for (i in arr.indices) arr[i] *= arr[i]
        return arr.sortedArray()
    }

    //Solution No - 2 - The Faster way using Two Pointer
    fun squareOfSortedArray1(arr: IntArray): IntArray {
        var L = 0
        var R = arr.size - 1
        val nums = IntArray(arr.size)
        for (i in nums.indices.reversed()) {
            if (abs(arr[L]) >= abs(arr[R])) {
                nums[i] = arr[L] * arr[L]
                L++
            } else {
                nums[i] = arr[R] * arr[R]
                R--
            }
        }
        return nums
    }

    /**
     * Duplicate Zero
     * @param [1,0,3,2,0,5,4]
     * @return [1,0,0,3,2,0,0]
     */
    fun duplicateZero(arr: IntArray) {
        val length: Int = arr.size
        val res = IntArray(length)
        var j = 0
        var i = 0
        while (i < length && j < length) {
            if (arr[i] != 0) {
                res[j] = arr[i]
            } else {
                j++
            }
            j++
            i++ // inc for
        }


        for (k in 0 until length) {
            arr[k] = res[k]
        }

        arr.forEach {
            print("$it ")
        }

    }

    //Solution No - 2 - Fastest Way to
    fun duplicateZero1(arr: IntArray) {
        for (i in arr.indices.reversed()) { // This will reversed of array in kotlin
            if (arr[i] == 0) {
                for (j in arr.size - 1 downTo i + 1) {
                    arr[j] = arr[j - 1]
                }
            }
        }
        arr.forEach {
            print("$it ")
        }
    }

    /**
     * merge two array with non-decreasing Order
     * @param nums1 [1,2,3,0,0,0]
     * @param m 3
     * @param nums2 [2,5,6]
     * @param n 3
     * @return [1,2,2,3,5,6]
     */
    fun mergeTwoArray(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]
            } else {
                nums1[k--] = nums2[j--]
            }
        }
        nums1.forEach {
            print("$it ")
        }
    }


}