package com.github.jayreturns.tictactoe.input

import com.github.jayreturns.tictactoe.grid.Grid
import com.github.jayreturns.tictactoe.grid.Point

interface InputProvider {

  /**
   * Reads input, parses it and returns it
   */
  fun readInput(): Point

  /**
   * Checks if point is inside the grid boundaries
   */
  fun isInputValid(point: Point): Boolean {
    return point.row > 0 && point.row <= Grid.GRID_SIZE && point.column > 0 && point.column <= Grid.GRID_SIZE
  }

}