import java.util.*;
import java.io.*;


/*
  This is the Game class. It contains following member methods:

    1. void play ()
    2. boolean isInteger(String str)
    3. boolean validateRange(int num)
    4. void printBoard()
    5. void printInstr()
*/
public class Game {
  private final static String horizontalDiv = "\n -------";
  private final static String verticalDiv = "|"; 
  private final static String user1 = "X";
  private final static String user2 = "O";
  private final static String emptyCell = " ";
  private final static String instruction = "\nUSER %d! IT'S YOUR TURN.\n";
  private final static String whichRow = "Enter the row you want to put: ";
  private final static String whichCol = "Enter the column you want to put: ";
  private final static String colAndRowRange = "Please enter a number"+
                                                  " within range [1-3]";
  private final static String occupiedCell = "\nThis cell is occupied. "+ 
                                                "Please enter again!!\n";
  private final static String winnerStatement = "USER %d WON! \n";
  private final static String tieStatement = "TIE!!!";

  private static Board goodBoard;
  private static int turn = 1;
  

  public Game (Board board) {
    goodBoard = board;
    printBoard();
  }
  
  /*
    Method to prompt the user instructions and take inputs from the user.

    Args: None

    Returns: None
  */

  public void play() {
    while (!goodBoard.checkWin() && !goodBoard.checkTie()){
      printInstrc();
      System.out.print (whichRow);
      Scanner scr = new Scanner (System.in);
      String rowStr = scr.nextLine();

      if (!isInteger(rowStr))
        continue;

      int row = Integer.parseInt (rowStr);
      //check if row is in the range
      if (!validateRange (row))
        continue;
      
      System.out.print (whichCol);
      scr = new Scanner (System.in);
      String colStr = scr.nextLine();
      
      if (!isInteger(colStr))
        continue;

      int col = Integer.parseInt (colStr);
      //check if column is in the range
      if (!validateRange (col))
        continue;
      
      //check if this cell is occupied
      if (!goodBoard.isEmpty(row,col)) {
        System.out.println (occupiedCell);
        continue;
      }

      else {
        //make a draw
        goodBoard.put (row,col,turn);
        printBoard();

        if(turn == 1)
          //if it was user1 who was playing, now change it to user2
          turn = 2; 
        else
          //otherwise change it to user1
          turn = 1;
      }
    }

    if(goodBoard.checkWin()) 
      System.out.printf(winnerStatement, (turn == 1) ? 2 : 1); 
    else 
      System.out.println(tieStatement);
  }
  
  /*
    Method to check if a String is an integer.

    Args: 
      str (String): the string to check

    Returns:
      Boolean: whether this argument is integer
  */
  private boolean isInteger (String str) {
    int size = str.length();
    for (int i = 0; i < size; i++) {
      if(!Character.isDigit(str.charAt(i)))
        return false;
    }

    return size > 0;
  }

  /*
    Method to check if the integer is within range from 1 to 3
    
    Args: 
      num (int)

    Returns: 
      Boolean: whether this num(int) is within the range
  */

  private boolean validateRange (int num) {
    if(num >= 1 && num <= 3)
      return true;

    return false;
  }
  
  /*
    Method to print out the entire Board includings draws, grids 
    and col/row number

    Args: 
      None

    Returns:
      None
  */
  
  private void printBoard() {
    int [][] printBoard = goodBoard.getBoard();
    System.out.print ("  1 2 3 ");
    System.out.println (horizontalDiv);

    for (int i = 0; i < goodBoard.size; i++) {
      System.out.print (i+1);
      System.out.print (verticalDiv);
      for (int j = 0; j < goodBoard.size; j++) {

        if (printBoard[i][j] == -1)
          System.out.print (emptyCell);

        else if (printBoard[i][j] == 0)
          System.out.print (user2);

        else if (printBoard[i][j] == 1)
          System.out.print (user1);
       
        System.out.print (verticalDiv);
      }
      System.out.println (horizontalDiv);

    }

  }
  /*
    Method to print out the instructions
    Args:
      None

    Returns:
      None
  */
  private void printInstrc() {
    System.out.printf (instruction, turn);
    System.out.println (colAndRowRange);
  }
}
