package com.github.jayreturns.tictactoe

import com.github.jayreturns.tictactoe.game.GameManager
import com.github.jayreturns.tictactoe.game.GameState
import com.github.jayreturns.tictactoe.grid.GridPrinter
import com.github.jayreturns.tictactoe.grid.SimpleGridPrinter
import com.github.jayreturns.tictactoe.input.ConsoleInputProvider
import com.github.jayreturns.tictactoe.input.InputProvider

fun main() {
  val gridPrinter: GridPrinter = SimpleGridPrinter()
  val grid = GameState.grid
  val inputProvider: InputProvider = ConsoleInputProvider()

  while (!GameManager.isGameOver()) {
    val input = inputProvider.readInput()
    grid.insertInput(input)
    gridPrinter.printGrid(grid)
  }
}