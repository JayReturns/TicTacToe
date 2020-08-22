package com.github.jayreturns.tictactoe.grid

class SimpleGridPrinter : GridPrinter {

  val LINE_BREAK = "\u2015".repeat(10)

  override fun printGrid(grid: Grid) {
    grid.grid.forEachIndexed { i, column ->
      var formattedColumn = ""
      column.forEachIndexed { j, row ->
        formattedColumn += row.symbol
        if (j != 2)
          formattedColumn += " | "
      }
      println(formattedColumn)
      if (i != 2)
        println(LINE_BREAK)
    }
  }

}