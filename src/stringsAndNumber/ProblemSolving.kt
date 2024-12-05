package stringsAndNumber


/**
 * Time Complexity : O(n+m)
 */
fun makeAnagram(a: String, b: String): Int {
    val frequency1 = IntArray(26)
    val frequency2 = IntArray(26)

    // Count character frequencies for the first string
    for (char in a) {
        frequency1[char - 'a']++
    }

    // Count character frequencies for the second string
    for (char in b) {
        frequency2[char - 'a']++
    }

    var deletions = 0

    // Calculate the number of deletions required
    for (i in 0..<26) {
        deletions += kotlin.math.abs(frequency1[i] - frequency2[i])
    }

    return deletions
}

fun alternatingCharacters(str: String): Int{
    var deletion = 0
    for(i in 0..str.length-2){
        if(str[i] == str[i+1]){
            deletion++
        }
    }
    return deletion
}

/**
 *   The Sherlock and the Valid String problem
 *   val str1 = "aabbcc" // Expected: "YES"
 *   Time Complexity - O(n)
 */
fun isValid(s: String): String {
    val frequency = mutableMapOf<Char, Int>()

    // Count the frequency of each character
    for (char in s) {
        frequency[char] = frequency.getOrDefault(char, 0) + 1
    }

    // Count occurrences of each frequency
    val frequencyCount = mutableMapOf<Int, Int>()
    for (count in frequency.values) {
        frequencyCount[count] = frequencyCount.getOrDefault(count, 0) + 1
    }

    // Case 1: All frequencies are the same (only one distinct frequency)
    if (frequencyCount.size == 1) {
        return "YES"
    }

    // Case 2: Two distinct frequencies exist
    if (frequencyCount.size == 2) {
        val keys = frequencyCount.keys.toList()
        val freq1 = keys[0]
        val freq2 = keys[1]

        // Check if removing one character from the higher frequency works
        if ((frequencyCount[freq1] == 1 && (freq1 - 1 == freq2 || freq1 == 1)) ||
            (frequencyCount[freq2] == 1 && (freq2 - 1 == freq1 || freq2 == 1))
        ) {
            return "YES"
        }
    }

    return "NO"
}


/**
 * Special Sub String
 *     val s1 = "aaaa" // Expected: 10
 *     val s2 = "abcbaba" // Expected: 10
 *     val s3 = "aabaa" // Expected: 9
 *     Time Complexity - O(n2)
 */
fun substrCount(n: Int, s: String): Long {
    var count: Long = 0

    // Count all substrings where all characters are the same
    var i = 0
    while (i < n) {
        val char = s[i]
        var repeatCount = 0

        while (i < n && s[i] == char) {
            i++
            repeatCount++
        }

        // Add the count of substrings formed by repeated characters
        count += (repeatCount.toLong() * (repeatCount + 1)) / 2
    }

    // Check for special palindromic substrings with different middle character
    for (j in 1..<n) {
        var offset = 1

        while (
            j - offset >= 0 && j + offset < n &&
            s[j - offset] == s[j - 1] && s[j + offset] == s[j - 1] &&
            s[j] != s[j - 1]
        ) {
            count++
            offset++
        }
    }

    return count
}