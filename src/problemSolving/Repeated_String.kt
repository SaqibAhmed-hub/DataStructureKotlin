package problemSolving

fun repeatedString(str: String, n: Long): Long {
    val len = str.length
    var count = 0.toLong()
    for (i in 0..<len) {
        if (str[i] == 'a') {
            count++
        }
    }
    val p = n / len
    count = (count * p)
    val k = n % len

    for (i in 0..<k) {
        if (str[i.toInt()] == 'a') {
            count++
        }
    }

    return count
}

fun main() {
    val n: Long = 10L
    val str = "abca"
    val result = repeatedString(str, n)
    println(result)
}
