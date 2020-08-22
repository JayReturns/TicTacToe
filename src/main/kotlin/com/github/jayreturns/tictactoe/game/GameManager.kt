package com.github.jayreturns.tictactoe.game

import com.github.jayreturns.tictactoe.grid.Grid

class GameManager {

  companion object {

    fun isGameOver(): Boolean {
      GameState.grid.grid.forEach { column ->
        column.forEach { row ->
          if (row == Grid.State.NONE)
            return false
        }

      }
      return true
    }

  }

}