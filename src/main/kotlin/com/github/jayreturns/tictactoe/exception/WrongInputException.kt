package com.github.jayreturns.tictactoe.exception

import com.github.jayreturns.tictactoe.grid.Grid

class WrongInputException(index: Number) : IndexOutOfBoundsException("Wrong input! Max expected ${Grid.GRID_SIZE} but found $index")