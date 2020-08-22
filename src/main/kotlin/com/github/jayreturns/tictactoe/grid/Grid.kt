package com.github.jayreturns.tictactoe.grid

import com.github.jayreturns.tictactoe.exception.WrongInputException
import java.util.concurrent.ThreadLocalRandom

class Grid {

  var grid = Array(3) { Array(3) { State.NONE } }
    private set
  var currentPlayer = Player.PLAYER_ONE
    private set

  companion object {
    const val GRID_SIZE = 3
  }

  fun set(row: Int, column: Int, player: State) {
    grid[row][column] = player
  }

  fun insertInput(point: Point) {
    validatePoint(point)

    grid[point.row][point.column] = currentPlayer.state

    switchPlayerForNextMove()
  }

  private fun switchPlayerForNextMove() {
    currentPlayer = when (currentPlayer) {
      Player.PLAYER_ONE -> Player.PLAYER_TWO
      Player.PLAYER_TWO -> Player.PLAYER_ONE
    }
  }

  private fun validatePoint(point: Point) {
    if (point.column > GRID_SIZE - 1) {
      throw WrongInputException(point.column)
    } else if (point.row > GRID_SIZE - 1) {
      throw WrongInputException(point.row)
    }
  }

  fun copy(): Grid {
    val newGrid = Grid()
    newGrid.grid = this.grid
    newGrid.currentPlayer = this.currentPlayer
    return newGrid
  }

  enum class State(val symbol: String) {
    X("X"),
    O("O"),
    NONE(" ");

    override fun toString(): String {
      return "State(symbol='$symbol')"
    }
  }

  enum class Player(val symbol: String, val state: State) {
    PLAYER_ONE(State.X.symbol, State.X),
    PLAYER_TWO(State.O.symbol, State.O);

    companion object {
      internal fun randomPlayer(): Player {
        return if (ThreadLocalRandom.current().nextBoolean()) {
          PLAYER_ONE
        } else {
          PLAYER_TWO
        }
      }
    }

    fun numericValue(): Int {
      return when (this) {
        PLAYER_ONE -> 1
        PLAYER_TWO -> 2
      }
    }
  }

}