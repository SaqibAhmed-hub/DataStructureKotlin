package recursion

import java.math.BigInteger

class RecursionClass {

    /**
     *  What is a recursion?
     *  a recursion is a function that call itself.
     */

    fun printNumber(n: Int) {
        println(n)
        if (n == RECURSION_NUMBER) return else printNumber(n + 1)
    }

    /**
     * complexity simple
     * Time Complexity: O(n)
     * to find the factorial of a number
     * fact(n) = n * fact(n-1)
     */
    fun factorialNumber(n: Int): Long {
        return if (n == 0) 1.toLong() else n * factorialNumber(n - 1)
    }

    /**
     * tailrec Recursion
     */
    tailrec fun tailRecFactorial(n: Int,semiResult: Long = 0 ): BigInteger {
        return if (n<=0) semiResult.toBigInteger() else tailRecFactorial((n-1),n+semiResult)
    }

    /**
     * find the fibonacci number using recursion
     * e.g. 1,1,2,3,5,8,13,21,34
     * fibo(n) = fibo(n-1) + fibo(n-2)
     */
    fun findFibonacciNumber(n: Int): Int{
        return if (n < 2) n else findFibonacciNumber(n-1) + findFibonacciNumber(n-2)
    }

    /**
     * a companion object is final static variable and object
     *  similar to public static keyword in java
     *  i can access below variable without initaling the class.
     *  like, RecursionClass.RECURSION_NUMBER
     */
    companion object {
        const val RECURSION_NUMBER = 5

        fun dummyFunction() {
            println("Hello dummy text.")
        }

    }


}