/*
      This is Board class. It contains the following methods:

      1. boolean isEmpty(int row, int col)
      2. void put(int row, int col, int turn)
      3. int[][] getBoard(int row, int col)
      4. boolean checkWin()
      5. boolean checkTie()
*/


public class Board {
  private int [][] board;
  private int numOfEmptyCells;

  public final static int size = 3;
  public final static int USER_1_TURN = 1;
  public final static int USER_2_TURN = 2;

  public Board() {
    board = new int [size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = -1;
      }
    }
    numOfEmptyCells = size * size;
  }
  
  /*
    Method to check if the certain cell is already occupied

    Args:
      row (int): row number of the cell
      col (int): col number of the cell

    Returns:
      Boolean: true if the cell is occupied; false otherwise
  */
  public boolean isEmpty(int row, int col){
    if (board[row-1][col-1] == -1)
      return true;

    return false;
  }
  
  /*
    Method to set certain cell of the board to a certain draw.
  
    Args:
      row(int): row number of the cell
      col(int): col number of the cell
      turn(int): user turn

    Returns:
      None
  */
  public void put(int row, int col, int turn){
      board[row-1][col-1] = (turn == USER_1_TURN)? 1 : 0;
      numOfEmptyCells--;
  }

  /*
    Method to access the internal matrix.
    
    Args:
      None

    Returns:
      int[][]
  */
  public int[][] getBoard() {
    return board;
  }
  
  /*
    Method to check if the game is tied.

    Args: 
      None

    Returns:
      Boolean: true if there's a tie; false otherwise
  */
  public boolean checkTie() {
    if (numOfEmptyCells == 0)
      return !checkWin();

    return false;
  }

  /*
    Method to check if there's a winner in the board. 
    
    Args: 
      None

    Returns:
      boolean: true if there's a winner; false otherwise

   */
  public boolean checkWin() {

    //check winning vertically and horizontally
    for (int i = 0; i < size; i++) {
      if (board[i][0] == board[i][1] && board[i][0] == board[i][2]
                                     && board[i][0] != -1)
        return true;

      if (board[0][i] == board[1][i] && board[0][i] == board [2][i]
                                     && board[0][i] != -1)
        return true;
    }

    //check winning diagonally
    if (board[0][0] == board [1][1] && board[0][0] == board[2][2]
                                    && board[0][0] != -1)
      return true;

    if (board[0][2] == board [1][1] && board[0][2] == board[2][0]
                                    && board[0][2] != -1)
      return true;

    return false;
  }
  
}
