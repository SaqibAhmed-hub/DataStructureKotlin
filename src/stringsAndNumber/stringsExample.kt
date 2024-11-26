package stringsAndNumber


fun countVowels(input: String): Int {
    return input.count { it in "aeiouAEIOU" }
}


fun firstNonRepeatedCharacter(input: String): Char? {
    val charCount = mutableMapOf<Char, Int>()
    input.forEach { char -> charCount[char] = charCount.getOrDefault(char, 0) + 1 }
    return input.find { char -> charCount[char] == 1 }
}


fun areAnagrams(str1: String, str2: String): Boolean {
    return str1.toCharArray().sorted() == str2.toCharArray().sorted()
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