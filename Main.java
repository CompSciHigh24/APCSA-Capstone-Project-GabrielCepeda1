class Main {
  public static int turns = 10;

  public static void main(String[] args) {
    // Sets up the game

    Main.description();
    Board.setup();
    Tile.setupBag();
    Tile.fillRack();
    Dictionary.dictSetup();

    // Continues to take turns while the player stil has turns left
    while (turns >= 0) {
      Player.takeTurn(turns);
      turns--;
    }

  }

  // Returns the number of the turns that are left
  public static int currTurns() {
    return turns;
  }

  public static void description() {
    System.out.println("-------------------------------------------");
    System.out.println(Styling.UNDERLINE + "Welcome to Scrabble!");
    System.out.println(Styling.RESET + "-------------------------------------------");
    System.out.println(
        "Scrabble is a fun and simple word game! You are given 7 tiles and must make a word that is 2 letters or longer each turn! When you use tiles, they are replenished from the tile bag. The game ends when the player chooses to end it or when the bag runs out of tiles. Tiles can provide multipliers depending on their color. For the multipliers, check the README file. \nThis project was fun to make, have fun!");
    System.out.println("-------------------------------------------");

  }
}