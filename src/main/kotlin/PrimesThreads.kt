package org.example

class PrimesThreads(private val start: Int, private val end: Int, private val result: MutableList<Int>) : Runnable {

    override fun run() {
        for (i in start..end) {
            if (isPrime(i)) {
                result.add(i)
            }
        }
    }
}

fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    val num = args[0].toInt()
    val mid = num / 2
    val primes1 = mutableListOf<Int>()
    val primes2 = mutableListOf<Int>()

    val task1 = PrimesThreads(2, mid, primes1)
    val task2 = PrimesThreads(mid + 1, num, primes2)

    val thread1 = Thread(task1)
    val thread2 = Thread(task2)

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()

    println("Primos de 2 a $mid: $primes1")
    println("Primos de ${mid + 1} a $num: $primes2")
}
