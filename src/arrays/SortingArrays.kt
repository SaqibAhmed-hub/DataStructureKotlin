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
     * Time Complexity - O (n log n)
     * more Stability, used for large Set
     */
    fun mergeSort(arr: Array<Int>): Array<Int> {
        if (arr.size <= 1 ) return arr
        val mid = arr.size /2
        val left = mergeSort(arr.sliceArray(0..<mid))
        val right = mergeSort(arr.sliceArray(mid..<arr.size))
        return merge(left,right)
    }

    private fun merge(left: Array<Int>, right: Array<Int>): Array<Int>{
        var i = 0
        var j = 0
        val result = mutableListOf<Int>()
        while (i < left.size && j < right.size){
            if (left[i] <= right[j]){
                result.add(left[i])
                i++
            }else{
                result.add(right[j])
                j++
            }
        }
        result.addAll(left.slice(i..<left.size))
        result.addAll(right.slice(j..<right.size))
        return result.toTypedArray()
    }

    /**
     * Quick Sort -
     * Time Complexity - O(n log n)
     * Worst case: O(n²)
     * quick and fast Sorting, less Stability
     */
    fun quickSort(arr: Array<Int>): Array<Int> {
        if (arr.size <= 1) return arr

        val pivot = arr[arr.size / 2]
        val equal = arr.filter { it == pivot } // filter will return List of Item if condition match
        val less = arr.filter { it < pivot }
        val greater = arr.filter { it > pivot }

        return quickSort(less.toTypedArray()) + equal +
                quickSort(greater.toTypedArray())
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