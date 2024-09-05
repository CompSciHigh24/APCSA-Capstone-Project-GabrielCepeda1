// BOARD CLASS: Handles anything to do with the board (Setup, Styling of the board/tiles, values of each tile and what letter is on each one.)
public class Board{
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  // initialization of the board and the values of each slot on the board. I separated the board into a string (which is used to actually display the board) and a 2D String array (to hold the values/letters of each tile within them)
  public static String board = " ";
  public static String[][] boardValues = new String[15][15];

  // sets blank values for all spots on the board
  public static void setupVals(){
    for(int a = 0; a < 15; a++){
      for(int b = 0; b < 15; b ++){
        boardValues[a][b] = " - ";
      }
    }
  }

  public static String[][] getBV(){
    return boardValues;
  }

  public static void setBV(String[][] bv){
    boardValues = bv;
  }

  public static String getB(){
    return board;
  }

  // checks the current space on the board to see if there is a multiplier and returns a string which will be taken in to see what is multiplied (w -> word multiplier & l -> letter multiplier)
  public static String checkforMultiplier(int a, int b){
    if(a == 7 && b == 7){
      return "";
    }
    if (boardValues[a][b].indexOf(Styling.BACKRED) > -1){
      return "w3";
    }
    if (boardValues[a][b].indexOf(Styling.BACKBRIGHTRED) > -1){
      return "w2";
    }
    if (boardValues[a][b].indexOf(Styling.BACKBLUE) > -1){
      return "l3";
    }
    if (boardValues[a][b].indexOf(Styling.BACKBRIGHTBLUE) > -1){
      return "l2";
    } 
    return ""; 
  }

  // ADDING TILE COLORS + VALUES TO BOARD -- THIS WILL BE USED FOR MULTIPLIERS THROUGH INDEXOF()
  public static void setupTiles(){
    boardValues[0][0] = Styling.BACKRED + boardValues[0][0] + Styling.BACKBLACK;
    boardValues[0][7] = Styling.BACKRED + boardValues[0][7] + Styling.BACKBLACK;
    boardValues[0][14] = Styling.BACKRED + boardValues[0][14] + Styling.BACKBLACK;
    boardValues[7][0] = Styling.BACKRED + boardValues[7][0] + Styling.BACKBLACK;
    boardValues[14][0] = Styling.BACKRED + boardValues[14][0] + Styling.BACKBLACK;
    boardValues[14][7] = Styling.BACKRED + boardValues[14][7] + Styling.BACKBLACK;
    boardValues[14][14] = Styling.BACKRED + boardValues[14][14] + Styling.BACKBLACK;
    boardValues[7][7] = Styling.BACKRED + boardValues[7][7] + Styling.BACKBLACK;
    boardValues[7][14] = Styling.BACKRED + boardValues[7][14] + Styling.BACKBLACK;
    boardValues[1][1] = Styling.BACKBRIGHTRED + boardValues[1][1] + Styling.BACKBLACK;
    boardValues[2][2] = Styling.BACKBRIGHTRED + boardValues[2][2] + Styling.BACKBLACK;
    boardValues[3][3] = Styling.BACKBRIGHTRED + boardValues[3][3] + Styling.BACKBLACK;
    boardValues[4][4] = Styling.BACKBRIGHTRED + boardValues[4][4] + Styling.BACKBLACK;
    boardValues[13][1] = Styling.BACKBRIGHTRED + boardValues[13][1] + Styling.BACKBLACK;
    boardValues[12][2] = Styling.BACKBRIGHTRED + boardValues[12][2] + Styling.BACKBLACK;
    boardValues[11][3] = Styling.BACKBRIGHTRED + boardValues[11][3] + Styling.BACKBLACK;
    boardValues[10][4] = Styling.BACKBRIGHTRED + boardValues[10][4] + Styling.BACKBLACK;
    boardValues[10][10] = Styling.BACKBRIGHTRED + boardValues[10][10] + Styling.BACKBLACK;
    boardValues[11][11] = Styling.BACKBRIGHTRED + boardValues[11][11] + Styling.BACKBLACK;
    boardValues[12][12] = Styling.BACKBRIGHTRED + boardValues[12][12] + Styling.BACKBLACK;
    boardValues[13][13] = Styling.BACKBRIGHTRED + boardValues[13][13] + Styling.BACKBLACK;
    boardValues[4][10] = Styling.BACKBRIGHTRED + boardValues[4][10] + Styling.BACKBLACK;
    boardValues[3][11] = Styling.BACKBRIGHTRED + boardValues[3][11] + Styling.BACKBLACK;
    boardValues[2][12] = Styling.BACKBRIGHTRED + boardValues[2][12] + Styling.BACKBLACK;
    boardValues[1][13] = Styling.BACKBRIGHTRED + boardValues[1][13] + Styling.BACKBLACK;
    boardValues[5][5] = Styling.BACKBLUE + boardValues[5][5] + Styling.BACKBLACK;
    boardValues[9][5] = Styling.BACKBLUE + boardValues[9][5] + Styling.BACKBLACK;
    boardValues[9][9] = Styling.BACKBLUE + boardValues[9][9] + Styling.BACKBLACK;
    boardValues[5][9] = Styling.BACKBLUE + boardValues[5][9] + Styling.BACKBLACK;
    boardValues[1][5] = Styling.BACKBLUE + boardValues[1][5] + Styling.BACKBLACK;
    boardValues[1][9] = Styling.BACKBLUE + boardValues[1][9] + Styling.BACKBLACK;
    boardValues[13][5] = Styling.BACKBLUE + boardValues[13][5] + Styling.BACKBLACK;
    boardValues[13][9] = Styling.BACKBLUE + boardValues[13][9] + Styling.BACKBLACK;
    boardValues[5][1] = Styling.BACKBLUE + boardValues[5][1] + Styling.BACKBLACK;
    boardValues[5][13] = Styling.BACKBLUE + boardValues[5][13] + Styling.BACKBLACK;
    boardValues[9][1] = Styling.BACKBLUE + boardValues[9][1] + Styling.BACKBLACK;
    boardValues[9][13] = Styling.BACKBLUE + boardValues[9][13] + Styling.BACKBLACK;
    boardValues[6][6] = Styling.BACKBRIGHTBLUE + boardValues[6][6] + Styling.BACKBLACK;
    boardValues[6][8] = Styling.BACKBRIGHTBLUE + boardValues[6][8] + Styling.BACKBLACK;
    boardValues[8][6] = Styling.BACKBRIGHTBLUE + boardValues[8][6] + Styling.BACKBLACK;
    boardValues[8][8] = Styling.BACKBRIGHTBLUE + boardValues[8][8] + Styling.BACKBLACK;
    boardValues[14][3] = Styling.BACKBRIGHTBLUE + boardValues[14][3] + Styling.BACKBLACK;
    boardValues[14][11] = Styling.BACKBRIGHTBLUE + boardValues[14][11] + Styling.BACKBLACK;
    boardValues[12][6] = Styling.BACKBRIGHTBLUE + boardValues[12][6] + Styling.BACKBLACK;
    boardValues[12][8] = Styling.BACKBRIGHTBLUE + boardValues[12][8] + Styling.BACKBLACK;
    boardValues[11][7] = Styling.BACKBRIGHTBLUE + boardValues[11][7] + Styling.BACKBLACK;
    boardValues[2][6] = Styling.BACKBRIGHTBLUE + boardValues[2][6] + Styling.BACKBLACK;
    boardValues[2][8] = Styling.BACKBRIGHTBLUE + boardValues[2][8] + Styling.BACKBLACK;
    boardValues[3][7] = Styling.BACKBRIGHTBLUE + boardValues[3][7] + Styling.BACKBLACK;
    boardValues[0][3] = Styling.BACKBRIGHTBLUE + boardValues[0][3] + Styling.BACKBLACK;
    boardValues[0][11] = Styling.BACKBRIGHTBLUE + boardValues[0][11] + Styling.BACKBLACK;
    boardValues[3][0] = Styling.BACKBRIGHTBLUE + boardValues[3][0] + Styling.BACKBLACK;
    boardValues[11][0] = Styling.BACKBRIGHTBLUE + boardValues[11][0] + Styling.BACKBLACK;
    boardValues[3][14] = Styling.BACKBRIGHTBLUE + boardValues[3][14] + Styling.BACKBLACK;
    boardValues[11][14] = Styling.BACKBRIGHTBLUE + boardValues[11][14] + Styling.BACKBLACK;
    boardValues[6][2] = Styling.BACKBRIGHTBLUE + boardValues[6][2] + Styling.BACKBLACK;
    boardValues[8][2] = Styling.BACKBRIGHTBLUE + boardValues[8][2] + Styling.BACKBLACK;
    boardValues[7][3] = Styling.BACKBRIGHTBLUE + boardValues[7][3] + Styling.BACKBLACK;
    boardValues[6][12] = Styling.BACKBRIGHTBLUE + boardValues[6][12] + Styling.BACKBLACK;
    boardValues[8][12] = Styling.BACKBRIGHTBLUE + boardValues[8][12] + Styling.BACKBLACK;
    boardValues[7][11] = Styling.BACKBRIGHTBLUE + boardValues[7][11] + Styling.BACKBLACK;
    boardValues[11][14] = Styling.BACKBRIGHTBLUE + boardValues[11][14] + Styling.BACKBLACK;
  }

  // full setup of the board
  
  public static void setup(){
    setupVals();
    setupTiles();
    int a = 0;
    for (int x = 0; x < 15; x++){
      if (a == 0){
        board += " " + Styling.UNDERLINE + "  ";
        for(int y = 0; y < 15; y++){
          if (y <= 8){
            board += (y + 1) + "    ";
          }
          else{
            board += (y + 1) + "   ";
          }  
        }
        board = board.substring(0, board.length() - 2);
        a = 1;
      }
      if (x <= 8){
        board += "\n" + Styling.RESET + (x + 1) + " ";
      }
      else{
         board += "\n" + (x + 1);
      }
      board += Styling.UNDERLINE;
      board += "|" + boardValues[x][0] + "|";
      board += "|" + boardValues[x][1] + "|";
      board += "|" + boardValues[x][2] + "|";
      board += "|" + boardValues[x][3] + "|";
      board += "|" + boardValues[x][4] + "|";
      board += "|" + boardValues[x][5] + "|";
      board += "|" + boardValues[x][6] + "|";
      board += "|" + boardValues[x][7] + "|";
      board += "|" + boardValues[x][8] + "|";
      board += "|" + boardValues[x][9] + "|";
      board += "|" + boardValues[x][10] + "|";
      board += "|" + boardValues[x][11] + "|";
      board += "|" + boardValues[x][12] + "|";
      board += "|" + boardValues[x][13] + "|";
      board += "|" + boardValues[x][14] + "|";
      board += Styling.RESET;
    }
  }

  public static void setBoard(){
    int a = 0;
    board = "";
    for (int x = 0; x < 15; x++){
      if (a == 0){
        board += " " + Styling.UNDERLINE + "  ";
        for(int y = 0; y < 15; y++){
          if (y <= 8){
            board += (y + 1) + "    ";
          }
          else{
            board += (y + 1) + "   ";
          }  
        }
        board = board.substring(0, board.length() - 2);
        a = 1;
      }
      if (x <= 8){
        board += "\n" + Styling.RESET + (x + 1) + " ";
      }
      else{
         board += "\n" + (x + 1);
      }
      board += Styling.UNDERLINE;
      board += "|" + boardValues[x][0] + "|";
      board += "|" + boardValues[x][1] + "|";
      board += "|" + boardValues[x][2] + "|";
      board += "|" + boardValues[x][3] + "|";
      board += "|" + boardValues[x][4] + "|";
      board += "|" + boardValues[x][5] + "|";
      board += "|" + boardValues[x][6] + "|";
      board += "|" + boardValues[x][7] + "|";
      board += "|" + boardValues[x][8] + "|";
      board += "|" + boardValues[x][9] + "|";
      board += "|" + boardValues[x][10] + "|";
      board += "|" + boardValues[x][11] + "|";
      board += "|" + boardValues[x][12] + "|";
      board += "|" + boardValues[x][13] + "|";
      board += "|" + boardValues[x][14] + "|";
      board += Styling.RESET;
    }
  }
  public static void showBoard(){
    System.out.println(board);
  }
}