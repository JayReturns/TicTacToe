package com.github.jayreturns.tictactoe.grid

class RandomGridFiller {

  companion object {
    fun randomGrid(grid: Grid = Grid()): Grid {

      for (i in grid.grid.indices) {
        for (j in grid.grid[i].indices) {
          grid.grid[i][j] = getRandomState()
        }
      }

//      grid.grid.forEach { column ->
//        column.map { getRandomState() }
//      }
      return grid
    }

    private fun getRandomState(): Grid.State {
      val states = Grid.State.values()
      return states.toList().shuffled().take(1)[0]
    }
  }
}