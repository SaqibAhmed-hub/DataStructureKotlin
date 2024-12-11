package arrays

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var maxSum = Int.MIN_VALUE
    for (i in 0..<arr.size-2) {
        for (j in 0..<arr[i].size-2) {
            val sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] +arr[i+2][j+2]
            maxSum = maxSum.coerceAtLeast(sum)
        }
    }
    return maxSum
}


fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    return (a.drop(d) + a.take(d)).toTypedArray()
}

fun rightRotateArray(arr: Array<Int>,d: Int) : Array<Int>{
    for(i in 0..d){
        val first = arr[0] //rotate it by one value
        for (j in 0..arr.size-2){
            arr[j] = arr[j+1]
        }
        arr[arr.size - 1] = first
    }
    return arr
}


/**
 *
 *     val test1 = arrayOf(2, 1, 5, 3, 4) // Expected: 3
 *     val test2 = arrayOf(2, 5, 1, 3, 4) // Expected: Too chaotic
 *     O(n) for normal cases, O(n2) in the worst-case scenario
 */
fun minimumBribes(q: Array<Int>): Unit {
    var totalBribes = 0
    for( i in q.indices.reversed()){
        if(q[i] - (i+1) > 2){
            println("Too chaotic")
            return
        }

        for(j in maxOf(0,q[i]-2)..<i){
            if (q[j] > q[i]) {
                totalBribes++
            }
        }
    }

    println(totalBribes)
}

/**
 * val arr = arrayOf(7, 1, 3, 2, 4, 5, 6)
 * @sample - 5
 * time Complexity - O(n log n)
 */
fun minimumSwaps(arr: Array<Int>): Int {
    val n = arr.size
    val visited = BooleanArray(n) { false }
    var swapCount = 0

    // Create an array of pairs (value, index)
    val indexedArray = arr.withIndex().sortedBy { it.value }

    for (i in 0..<n) {
        // If element is already visited or in the correct position, skip
        if (visited[i] || indexedArray[i].index == i) continue

        var cycleSize = 0
        var j = i

        // Traverse the cycle
        while (!visited[j]) {
            visited[j] = true
            j = indexedArray[j].index
            cycleSize++
        }

        // If there is a cycle of size > 1, we need (cycleSize - 1) swaps
        if (cycleSize > 1) {
            swapCount += cycleSize - 1
        }
    }

    return swapCount

}

/**
 * Two Sum Product
 */
fun twoSumProduct(arr : Array<Int>,k :Int): Array<Int>{
    for (i in arr.indices){
        for(j in i+1..<arr.size){
            if((arr[i] + arr[j]) == k){
                return arrayOf(i,j)
            }
        }
    }
    return arrayOf()
}

/**
 * Activity Notification problems
 * arrayOf(2, 3, 4, 2, 3, 6, 8, 4, 5)  d = 5 // Expected : 2
 * Time Complexity - O(n)
 */
fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    if (expenditure.size <= d) return 0

    val count = IntArray(201)
    var notifications = 0

    for (i in 0..<d) {
        count[expenditure[i]]++
    }

    for (i in d..<expenditure.size) {
        val median = getMedian(count, d)

        if (expenditure[i] >= 2 * median) {
            notifications++
        }

        count[expenditure[i]]++
        count[expenditure[i - d]]--
    }

    return notifications

}

fun getMedian(count: IntArray, d: Int): Double {
    var sum = 0
    var median1 = -1
    var median2 = -1

    for (i in count.indices) {
        sum += count[i]

        // First median value (for odd and even cases)
        if (median1 == -1 && sum >= (d / 2) + 1) {
            median1 = i
        }

        // Second median value (for even case only)
        if (median2 == -1 && sum >= (d / 2) + (d % 2)) {
            median2 = i
        }

        if (median1 != -1 && median2 != -1) {
            break
        }
    }

    return if (d % 2 == 0) (median1 + median2) / 2.0 else median2.toDouble()
}

/**
 * Time Complexity : O(n+ m)
 */
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    // Create an array of size n+1 (1-based indexing)
    val arr = LongArray(n + 1) { 0L }

    // Apply the operations using prefix sum approach
    for (query in queries) {
        val start = query[0]
        val end = query[1]
        val value = query[2].toLong()

        arr[start] += value
        if (end + 1 <= n) {
            arr[end + 1] -= value
        }
    }

    // Compute prefix sum and find the maximum value
    var max = 0L
    var currentSum = 0L
    for (i in 1..n) {
        currentSum += arr[i]
        max = maxOf(max, currentSum)
    }

    return max

}


