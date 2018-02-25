import java.util.*;
/*
                    Tic Tac Toe

  This is a terminal game for two users. User need to input row number and
  column number to make a draw. Both are within range [1-3]

  When the game starts, it's user1's turn,

     1  2  3
    ----------
  1 |  |  |  |
    ----------
  2 |  |  |  |
    ----------
  3 |  |  |  |
    ----------

  User1 can input row number:2 and column number:3 
                              to make a draw as following
     1  2  3
    ----------
  1 |  |  |  |
    ----------
  2 |  |  | X|
    ----------
  3 |  |  |  |
    ----------
    
  Now it come to user2's turn. For another example, if user2 wants to make
  a draw at row:3 and column:1, the board will be changed as following:

     1  2  3
    ----------
  1 |  |  |  |
    ----------
  2 |  |  | X|
    ----------
  3 | O|  |  |
    ----------


  Several warnings:
  
  1. Users can't make a draw at the cell where it is already occupied
  2. Users must enter a number within range 1 to 3. Any other characters
     such as ./#$%^&FGZsefef will reprompt the instructions.
  


*/
public class TicTacToe{
    private final static String gameStatement= "(N)ew Game (Q)uit";


    public static void main(String []args){
      Board myBoard = new Board();
      Game myGame = new Game(myBoard);
      myGame.play();
      gameOver();
    }
    

    /*
      Method to handle the case when the game is over (Either a Tie
      or there's a winner). The user can choose either quit the 
      game or start a new game.

      Args: None

      Returns: None

    */
    public static void gameOver() {
      while (true) {
        System.out.println(gameStatement);
        Scanner scr = new Scanner (System.in);
        String userInstr= scr.nextLine();

        if(userInstr.equals("N")) {
          Game newGame = new Game(new Board());
          newGame.play();
        }
        else if (userInstr.equals("Q")) {
          System.exit(0);
        }
      }
      
    }
}

