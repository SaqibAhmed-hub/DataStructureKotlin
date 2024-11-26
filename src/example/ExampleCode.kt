package example

import kotlin.math.sqrt


fun fizzBuzz(n: Int) {
    for (i in 1..n) {
        when {
            i % 15 == 0 -> println("FizzBuzz")
            i % 3 == 0 -> println("Fizz")
            i % 5 == 0 -> println("Buzz")
            else -> println(i)
        }
    }
}
fun countVowels(input: String): Int {
    return input.count { it in "aeiouAEIOU" }
}

fun removeDuplicates(numbers: Array<Int>): List<Int> {
    return numbers.distinct()
}

fun firstNonRepeatedCharacter(input: String): Char? {
    val charCount = mutableMapOf<Char, Int>()
    input.forEach { char -> charCount[char] = charCount.getOrDefault(char, 0) + 1 }
    return input.find { char -> charCount[char] == 1 }
}

fun findMissingNumber(arr: Array<Int>, n: Int): Int {
    val totalSum = (n * (n + 1)) / 2
    val arrSum = arr.sum()
    return totalSum - arrSum
}

fun areAnagrams(str1: String, str2: String): Boolean {
    return str1.toCharArray().sorted() == str2.toCharArray().sorted()
}

fun findCommonElements(arr1: Array<Int>, arr2: Array<Int>): Array<Int> {
    return arr1.intersect(arr2.toSet()).toTypedArray()
}

fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}

fun largestPalindrome(input: String): String {
    var largestPalindrome = ""

    for (i in input.indices) {
        for (j in i + 1..input.length) {
            val substring = input.substring(i, j)
            if (substring == substring.reversed() && substring.length > largestPalindrome.length) {
                largestPalindrome = substring
            }
        }
    }
    return largestPalindrome
}

fun findMissingCharacter(input: String): Char? {
    val fullAlphabet = "abcdefghijklmnopqrstuvwxyz"
    for (char in fullAlphabet) {
        if (char !in input) return char
    }
    return null
}