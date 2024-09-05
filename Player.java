import java.util.*;

// PLAYER CLASS: Handles anything to do with the player/player input (score, turn logic, tile placement, end conditions, etc.)
public class Player {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  // Score related methods/variables
  public static int score = 0;

  public static int showScore() {
    return score;
  }

  public static void addToScore(int val) {
    score += val;
  }

  // Prints out final score of the player
  public static void finalScore() {
    int totalScore = showScore();
    System.out.println("\n\n||SCORE: " + score);
    for (int x = 0; x < Tile.getRack().size(); x++) {
      Tile currTile = Tile.getRack().get(x);
      System.out.println("| TILE: " + currTile.getLetter() + " / VALUE: " + currTile.findVal(currTile.getLetter()));
      score -= currTile.findVal(currTile.getLetter());
    }
    System.out.println("\n||FINAL SCORE: " + score);
  }

  // Game over method
  public static void gameOver(String condition) {
    if (condition.equals("escape")) {
      System.out.println("Game over! Your score was " + showScore() + ", and you had a total of "
          + Tile.getRack().size()
          + " tiles left in your rack, so this is your final score (total sum of your tiles is subtracted from your score):");
      finalScore();
      System.exit(0);
    } else if (condition.equals("tiles")) {
      System.out.println("Game over! You've used all the tiles in the bag! Your score was: " + showScore()
          + ", and you had a total of " + WordChecker.getWords() + " words!");
    }
  }

  // Checks for validity of the tile placement
  public static boolean checkIfValid(String check) {
    String[][] vals = Board.getBV();
    if (check.equals("turn1")) {
      if (Main.currTurns() == 10) {
        if (vals[7][7].indexOf("-") != -1) {
          return false;
        } else {
          return true;
        }
      }
    }
    return true;
  }

  // checks if a move if valid or not similar to the method above but following the first turn
  public static boolean checkIfValid(String check, int row, int col) {
    String[][] vals = Board.getBV();
    if (check.equals("tile")) {
      if (vals[row][col].indexOf("-") != -1) {
        return false;
      } else {
        return true;
      }
    }
    return true;
  }

  // Contains all the logic of taking a turn
  public static void takeTurn(int turns) {
    System.out.println("TURN " + (11 - turns));
    System.out.print("Score: " + showScore() + "\n");
    if (turns == 10) {
      System.out.println("(THE FIRST WORD MUST USE THE CENTER TILE!)");
    }
    Board.showBoard();
    Tile.fillRack();
    String[][] temp = Board.getBV();
    String tempb = Board.getB();

    final String[][] ogBV = new String[15][15];
    for(int x = 0; x < Board.getBV().length; x++){
      for(int y = 0; y < Board.getBV()[0].length; y++){
        ogBV[x][y] = Board.getBV()[x][y];
      }
      
    }
    final String ogB = Board.getB();

    ArrayList<Integer> rIndexes = new ArrayList<Integer>();
    ArrayList<Integer> cIndexes = new ArrayList<Integer>();

    boolean wordPicked = false;
    Scanner userInput = new Scanner(System.in);

    // loop while the player hasn't selected a word yet
    int lettersPicked = 0;
    final ArrayList<Tile> rack = Tile.getRack();
    while (wordPicked == false) {
      ArrayList<Tile> temprack = new ArrayList<>(Tile.getRack());
      Tile.showRack();
      if (lettersPicked == 0) {
        System.out.println(
            "\n\nChoose a tile to use, type 'refresh' to refresh your tile(s), or end the game by typing 'ESC' (1 - "
                + temprack.size() + ").");
      } else if (lettersPicked > 0) {
        if (lettersPicked > 2) {
          System.out.println(
              "\n\nChoose a tile to use, type 'r' to reset to board and get your tiles back, type 'refresh' to refresh your tile(s), submit your word by typing 'enter' or end the game by typing 'ESC' (1 - "
                  + temprack.size() + ").");
        } else {
          System.out.println(
              "\n\nChoose a tile to use, type 'r' to reset to board and get your tiles back, type 'refresh' to refresh your tile(s), or end the game by typing 'ESC' (1 - "
                  + temprack.size() + ").");
        }
      }
      String input = userInput.nextLine();
      int pickedTile = -1;

      while (input.replace(" ", "").length() < 1){
        System.out.println("Invalid response, try again.");
        input = userInput.nextLine();
      }
      // User input handling (ending game, refresh, index selection)
      if (input.toLowerCase().equals("esc")) {
        gameOver("escape");
      } else if (input.toLowerCase().equals("refresh")) {
        System.out.println("\n\nWhich tile(s) do you want to refresh? Separate them with commas. (ex. 1, 6)");
        String tiles = userInput.nextLine();
        String indexes = tiles.replace(", ", "");
        int[] indexList = new int[indexes.length()];
        for (int x = 0; x < indexes.length(); x++) {
          indexList[x] = Integer.parseInt(indexes.substring(x, x + 1));
        }
        Tile.refreshTiles(indexList);
        wordPicked = true;
        continue;
      } else if (input.toLowerCase().equals("enter")) {
        wordPicked = true;
        WordChecker.wordCheck(rIndexes, cIndexes);
        continue;
      } else if (input.toLowerCase().equals("r")) {
        if (lettersPicked > 0) {
          // System.out.println("RESET RAN");
          lettersPicked = 0;
          // for (Tile r : rack){
          //   System.out.println("OG TILE: " + r.getLetter());
          // }
          Tile.setRack(rack);
          Board.setBV(ogBV);
          Board.setupTiles();
          Board.setBoard();
          rIndexes = new ArrayList<Integer>();
          cIndexes = new ArrayList<Integer>();
          System.out.println("\n");
          temp = Board.getBV();
          Board.showBoard();
          continue;
        }
      } else {
        boolean found = false;
        String[] alphabet = Tile.getAlph();
        String first = input.substring(0, 1).toLowerCase();
        for (int x = 0; x < alphabet.length; x++) {
          if ((alphabet[x]).equals(first)) {
            System.out.println("Not a number, try again.");
            found = true;
          }
        }
        if (!found) {
          pickedTile = (Integer.parseInt(input)) - 1;
        }
      }
      // Player cannot select a number out of the range
      while ((pickedTile > temprack.size() || pickedTile < 0) || (pickedTile == -1)) {
        System.out.println("\nThe number you picked is out of range. Try again.");
        pickedTile = (Integer.parseInt(userInput.nextLine())) - 1;
      }
      if (pickedTile != -1) {
        Tile chosenTile = temprack.get(pickedTile);

        System.out.println("\nChoose a row to place the tile. (1 - 15).");
        int pickedRow = (Integer.parseInt(userInput.nextLine())) - 1;
        rIndexes.add(pickedRow);

        System.out.println("\nChoose a column to place the tile. (1 - 15).");
        int pickedCol = (Integer.parseInt(userInput.nextLine())) - 1;
        cIndexes.add(pickedCol);

        temp[pickedRow][pickedCol] = " " + chosenTile.getLetter() + " ";
        temprack.remove(pickedTile);
        if (checkIfValid("turn1") || checkIfValid("tile", pickedRow, pickedCol)) {
          Tile.setRack(temprack);
          Board.setBV(temp);
          Board.setupTiles();
          Board.setBoard();
          System.out.println("\n");
          Board.showBoard();
          lettersPicked++;
        } else {
          System.out.println("invalid");
        }
      }
    }
  }
}