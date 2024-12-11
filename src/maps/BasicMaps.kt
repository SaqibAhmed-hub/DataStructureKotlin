package maps

class BasicMaps {

    /*
    mapOf()	        -   Immutable map, cannot modify elements.
    mutableMapOf()	-   Mutable map, allows add, update, delete.
    hashMapOf()	    -   A type of mutable map backed by a hash table.
    linkedMapOf()	-   Maintains insertion order for keys.
    sortedMapOf()	-   Maintains sorted order for keys.
    */


    private var map1 = mapOf("Key1" to 1, "Key2" to 256, "Key3" to 3)  // immutable Map
    private var map2 = mutableMapOf(101 to 1, 102 to 2, 103 to 3, 104 to 4) //mutable Map
    private val hashMap = hashMapOf(
        "Apple" to 2.00,
        "Banana" to 5.56,
        "Orange" to 8.10
    ) // hash Map , No Order guarentee
    private val linkedHashMap = linkedMapOf(
        "Zebra" to 1,
        "Apple" to 2,
        "Mango" to 3
    ) // Insertion Order


    fun printMap() {
        println("Map Value ==> ${map1.values} , ${map1.values::class}") // return the Collection
        println("Map Key ==> ${map1.keys},  ${map1.keys::class}") // return the Set
        println("Map Entries ==> ${map1.entries}") // return the Set
        map2.forEach { k, v -> print("${v * v}, ") }
        map2[105] = 5  // adding a value
        map2.remove(102)   // remove a value
        println(map1.getOrDefault("Key2", 0)) // this is return the value
        println("Maps : $map1 , $map2")
        println("Hash Map (UnOrdered) : $hashMap")
        println("LinkedHashMap (Insertion Order): $linkedHashMap")
        println("Merged Maps : ${map1 + map2}") //merging two maps


    }

    /**
     *     val magazine = "give me one grand today night"
     *     val notes = "give one grand today"
     *     checkMagazine(magazine.split(" ").toTypedArray(), notes.split(" ").toTypedArray())
     *     Result : Yes
     */
    fun checkMagazine(magazine: Array<String>, note: Array<String>) {
        val wordCount = mutableMapOf<String, Int>()
        for (i in magazine) {
            wordCount[i] = wordCount.getOrDefault(i, 0) + 1
        }
        for (j in note) {
            if (wordCount.getOrDefault(j, 0) == 0) {
                println("No")
                return
            }
            wordCount[j] = wordCount[j]!! - 1
        }
        println("Yes")
    }

    /**
     * two String Intersection
     * @sample - "ant" and "art"  - "YES"
     */
    fun twoStrings(s1: String, s2: String): String {
        val set1 = s1.toSet()
        val set2 = s2.toSet()
        return if (set1.intersect(set2).isNotEmpty()) {
            "YES"
        } else {
            "NO"
        }
    }

    /**
     * sherlock anagrams
     * @sample - mom , result = 2
     * Time Complexity - O (n3)
     */
    fun sherlockAndAnagrams(s: String): Int {
        val charMap = mutableMapOf<String, Int>()

        //Generate all subString
        for (i in s.indices) {
            for (j in i + 1..s.length) {
                val subString = s.substring(i, j)
                val sortedSubString = subString.toCharArray().sorted().joinToString("")
                charMap[sortedSubString] = charMap.getOrDefault(sortedSubString, 0) + 1
            }
        }
        // Calculate anagrammatic pairs
        var count = 0
        for (frequency in charMap.values) {
            count += (frequency * (frequency - 1)) / 2
        }

        return count

    }


    /**
     * count Triplet
     * Time Complexity: O(n)
     */
    fun countTriplets(arr: Array<Long>, r: Long): Long {
        val countLeft = mutableMapOf<Long, Long>()
        val countRight = mutableMapOf<Long, Long>()

        // Initialize countRight with the frequency of each number
        for (num in arr) {
            countRight[num] = countRight.getOrDefault(num, 0) + 1
        }

        var tripletCount = 0L

        // Traverse the array
        for (num in arr) {
            // Current number is the "middle" of a potential triplet
            countRight[num] = countRight[num]!! - 1

            if (num % r == 0L) { // Check if num can form a triplet
                val left = num / r
                val right = num * r

                val countLeftOccurrences = countLeft.getOrDefault(left, 0)
                val countRightOccurrences = countRight.getOrDefault(right, 0)

                tripletCount += countLeftOccurrences * countRightOccurrences
            }

            // Update countLeft with the current number
            countLeft[num] = countLeft.getOrDefault(num, 0) + 1
        }

        return tripletCount

    }


}