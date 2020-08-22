package com.github.jayreturns.tictactoe.input

import com.github.jayreturns.tictactoe.game.GameState
import com.github.jayreturns.tictactoe.grid.Grid
import com.github.jayreturns.tictactoe.grid.Point

class ConsoleInputProvider : InputProvider {

  override fun readInput(): Point {
//    print("Player " + GameState.grid.currentPlayer.symbol + "'s move: ")
//    var rawInput = readLine()
//    while (rawInput == null) {
//      print("Please insert a valid point! (Row, Column): ")
//      rawInput = readLine()
//    }

    var row: Int; var column: Int
    var splitted: List<String>

    while (true) {
      try {
        splitted = readValidatedConsoleInput().replace(" ", "").split(',')
        row = splitted.component1().toInt()
        column = splitted.component2().toInt()
        break
      } catch (ex: Exception) {
        when (ex) {
          is NumberFormatException -> println("Only input two numbers separated by a comma")
          is IndexOutOfBoundsException -> println("Only input two numbers separated by a comma")
          else -> throw ex
        }
      }
    }

    val result = Point(row, column)

    return if (isInputValid(result)) result else {
      print("The entered number is to big! Grid size: ${Grid.GRID_SIZE}")
      readInput()
    }
  }

  private fun readValidatedConsoleInput(): String {
    print("Player " + GameState.grid.currentPlayer.symbol + "'s move: ")
    var rawInput = readLine()
    while (rawInput == null) {
      print("Please insert a valid point! (Row, Column): ")
      rawInput = readLine()
    }
    return rawInput
  }

}