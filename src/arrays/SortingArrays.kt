package arrays

class SortingArrays {

    /**
     * Bubble Sort
     * Time Complexity - O(n) Best Case,  O(n2) in worst case
     */
    fun bubbleSort(arr: Array<Int>) {
        for (i in arr.indices) {
            for (j in 0..<arr.size - 1) {
                if (arr[j] > arr[j + 1]) {
                    arr.swapAt(j, j + 1)
                }
            }
        }
        println(arr.joinToString(", "))
    }

    /**
     * Selection Sort
     * Time Complexity - O(n2)
     */
    fun selectionSort(arr: Array<Int>) {
        for (current in 0..<(arr.size - 1)) {
            var lowest = current
            for (other in (current + 1)..<arr.size) {
                if (arr[lowest] > arr[other]) {
                    lowest = other
                }
            }
            if (lowest != current) {
                arr.swapAt(lowest, current)
            }
        }
        println(arr.joinToString(", "))
    }

    /**
     * Insertion Sort -
     * Time Complexity - O(n2)
     */
    fun insertionSort(arr: Array<Int>) {
        for (current in 1..<arr.size) {
            for (shifting in (1..current).reversed()) {
                if (arr[shifting] < arr[shifting - 1]) {
                    arr.swapAt(shifting, shifting - 1)
                } else {
                    break
                }
            }
        }
        println(arr.joinToString(", "))
    }

    /**
     * Merge Sort -
     */
    fun mergeSort(arr: Array<Int>) {


    }

    /**
     * Quick Sort -
     */
    fun quickSort(arr: Array<Int>): Unit {}

    /**
     * Extension function to swap an array
     */
    private fun <T> Array<T>.swapAt(firstIndex: Int, secondIndex: Int) {
        val temp = this[firstIndex]
        this[firstIndex] = this[secondIndex]
        this[secondIndex] = temp
    }

}