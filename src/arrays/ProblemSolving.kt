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
