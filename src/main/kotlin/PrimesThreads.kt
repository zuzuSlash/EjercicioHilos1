package org.example

import java.util.Scanner


fun isPrime(n: Int): Boolean {
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}



fun main() {
    val scanner = Scanner(System.`in`)
    println("Introduce un numero: ")
    val num = scanner.nextInt()

    val mid = num / 2
    val primes1 = mutableListOf<Int>()
    val primes2 = mutableListOf<Int>()

    val thread1 = Thread {
        for (i in 2..mid) {
            if (isPrime(i)) {
                primes1.add(i)
            }
        }
    }
    val thread2 = Thread {
        for (i in (mid + 1) .. num) {
            if (isPrime(i)) {
                primes1.add(i)
            }
        }
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()

    println("Numeros de $num,  2 al $mid => $primes1")


}