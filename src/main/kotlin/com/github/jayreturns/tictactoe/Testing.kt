package com.github.jayreturns.tictactoe

import kotlin.Exception

fun main() {
  var a: String = "-1"; var b: String = "-1"
  try {
    val read = readLine()!!.split(" ")
    a = read.component1()
    b = read.component2()

    println(a.toByte() + b.toInt())
    // Input: "a b" -> NumberFormatException
    // Input "12" -> IndexOutOfBoundsException
  } catch (e: Exception) {
    println("a: ${a}")
    println("b: $b")
    e.printStackTrace()
  }
}