package com.gilorroristore.jetpackcompose2026

fun main() {
    println("Ingresa el numero")
    val n = readln().trim().toInt()

    for (i in 1..n) {

        if (i % 3 == 0 && i % 5 == 0) {
            println("FizzBuzz")
        } else if (i % 3 == 0) {
            println("Fizz")
        } else if (i % 5 == 0) {
            println("Buzz")
        } else {
            println("$i")
        }
    }
}