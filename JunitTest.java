import static org.junit.Assert.*;
import org.junit.Test;

public class JunitTest{
  //Test from 1 to 4 check if put works fine for user1
  @Test
  public void test1() {
    int [][] expectedBoard = {{ 1,-1,-1},
                              {-1,-1,-1},
                              {-1,-1,-1}};
    Board board1 = new Board();
    board1.put(1,1,1);
    assertArrayEquals(board1.getBoard(),expectedBoard); 
  }
  @Test
  public void test2() {
    int [][] expectedBoard = {{-1, 1,-1},
                              {-1,-1,-1},
                              {-1,-1,-1}};
    Board board2 = new Board();
    board2.put(1,2,1);
    assertArrayEquals(board2.getBoard(),expectedBoard); 
  }
  @Test
  public void test3() {
    int [][] expectedBoard = {{-1,-1, 1},
                              {-1,-1,-1},
                              {-1,-1,-1}};
    Board board3 = new Board();
    board3.put(1,3,1);
    assertArrayEquals(board3.getBoard(),expectedBoard); 
  }

  @Test
  public void test4() {
    int [][] expectedBoard = {{-1,-1,-1},
                              { 1,-1,-1},
                              {-1,-1,-1}};
    Board board4 = new Board();
    board4.put(2,1,1);
    assertArrayEquals(board4.getBoard(),expectedBoard); 
  }

  //Test from 5 to 8 check if put works fine for user2
  @Test
  public void test5() {
    int [][] expectedBoard = {{-1,-1,-1},
                              {-1, 0,-1},
                              {-1,-1,-1}};
    Board board5 = new Board();
    board5.put(2,2,2);
    assertArrayEquals(board5.getBoard(),expectedBoard); 
  }
  @Test
  public void test6() {
    int [][] expectedBoard = {{-1,-1,-1},
                              {-1,-1, 0},
                              {-1,-1,-1}};
    Board board6 = new Board();
    board6.put(2,3,2);
    assertArrayEquals(board6.getBoard(),expectedBoard); 
  }
  @Test
  public void test7() {
    int [][] expectedBoard = {{-1,-1,-1},
                              {-1,-1,-1},
                              { 0,-1,-1}};
    Board board7 = new Board();
    board7.put(3,1,2);
    assertArrayEquals(board7.getBoard(),expectedBoard); 
  }
  @Test
  public void test8() {
    int [][] expectedBoard = {{-1,-1,-1},
                              {-1,-1,-1},
                              {-1, 0,-1}};
    Board board8 = new Board();
    board8.put(3,2,2);
    assertArrayEquals(board8.getBoard(),expectedBoard); 
  }

  //Test to check if checkWin() returns true if
  //there's three consecutives horizontally
  @Test
  public void test9() {  
    Board board9 = new Board();
    board9.put(1,1,2);
    board9.put(1,2,2);
    board9.put(1,3,2);
    assertTrue(board9.checkWin());
  }

  //Test to check if checkWin() returns true if
  //there's three consecutives diagonally
  @Test
  public void test10() {  
    Board board10 = new Board();
    board10.put(1,1,2);
    board10.put(2,2,2);
    board10.put(3,3,2);
    assertTrue(board10.checkWin());
  }
  
  //Test to check if checkWin() returns true if
  //there's three consecutives vertically
  @Test
  public void test11() {  
    Board board11 = new Board();
    board11.put(1,3,1);
    board11.put(2,3,1);
    board11.put(3,3,1);
    assertTrue(board11.checkWin());
  }


  //Test to check if putting only one element in the grid will 
  //cause checkWin() to return false
  @Test
  public void test12() {  
    Board board12 = new Board();
    board12.put(1,3,1);
   
    assertFalse(board12.checkWin());
  }
  
  //Test to check if checkTie returns true when the board is
  //full but no winner
  @Test
  public void test13() {  
    Board board13 = new Board();
    board13.put(1,1,1); 
    board13.put(1,2,1);
    board13.put(1,3,2);
    board13.put(2,1,2);
    board13.put(2,2,2);
    board13.put(2,3,1);
    board13.put(3,1,1);
    board13.put(3,2,1);
    board13.put(3,3,2);
    assertTrue(board13.checkTie());
  }
  
  //Test to check if checkTie returns false when there's a winner 
  @Test
  public void test14() {  
    Board board14 = new Board();
    board14.put(1,1,1); 
    board14.put(1,2,1);
    board14.put(1,3,1);
    board14.put(2,1,2);
    board14.put(2,2,2);
    board14.put(2,3,1);
    board14.put(3,1,1);
    board14.put(3,2,1);
    board14.put(3,3,2);
    assertFalse(board14.checkTie());
  }
  
  //Test to check if isEmpty works fine
  @Test
  public void test15() {  
    Board board15 = new Board();
    board15.put(1,3,1);
   
    assertFalse(board15.isEmpty(1,3));
  }
  
}

