package arrays

class SortingArrays {

    /**
     * Bubble Sort
     * Time Complexity - O(n2) in worst case
     */
    fun bubbleSort(arr: Array<Int>): Unit {
        var counter = 0
        for (i in arr.indices) {
            for (j in 0..<arr.size - 1) {
                if (arr[j] > arr[j + 1]) {
                    arr.swapAt(j, j + 1)
                    counter++
                }
            }
        }
        println(counter)
        println(arr.joinToString(", "))
    }

    /**
     * Extension function to swap an array
     */
    private fun <T> Array<T>.swapAt(firstIndex: Int, secondIndex: Int) {
        val temp = this[firstIndex]
        this[firstIndex] = this[secondIndex]
        this[secondIndex] = temp
    }

}