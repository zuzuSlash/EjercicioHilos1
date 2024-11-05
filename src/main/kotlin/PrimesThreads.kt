package org.example


class PrimesThreads (private val n: Int) : Runnable {
    private var _num = 0
    val num: Int get() = _num

    override fun run(){

    }
}

fun isPrime(n: Int): Boolean {
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}



fun main(args: Array<String>) {
    val mid = args[0].toInt() / 2
    val primes1 = mutableListOf<Int>()
    val primes2 = mutableListOf<Int>()

    val task1 = PrimesThreads(2)
    val task2 = PrimesThreads(0)

    val thread1 = Thread {
        for (i in 2..mid) {
            if (isPrime(i)) {
                primes1.add(i)
            }
        }
    }
    val thread2 = Thread {
        for (i in (mid + 1) .. args[0].toInt()) {
            if (isPrime(i)) {
                primes2.add(i)
            }
        }
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()

    println(primes1)
    println(primes2)


}