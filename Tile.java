import java.util.ArrayList;

public class Tile{
  private String letter;
  private int value;
  
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  public Tile(String l, int v){
    letter = l;
    value = v;
  }

  // Variables used for tiles/tile values
  public static String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
  public static int[] values = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
  
  public static ArrayList<Tile> tileBag = new ArrayList<Tile>();
  public static ArrayList<Tile> tileRack = new ArrayList<Tile>();

  // returns the index of the letter in the 'alphabet' array and then retrieves it so that it may be used for the 'values' array (get value)
  public static int findVal(String letter){
    for(int x = 0; x < values.length; x++){
      if (alphabet[x].equals(letter.replace(" ", ""))){
        return values[x];
      }
    }
    return -1;
  }

  public static String[] getAlph(){
    return alphabet;
  }

  public static int findIndex(String letter){
    for(int x = 0; x < values.length; x++){
      if (alphabet[x] == letter){
        return x;
      }
    }
    return -1;
  }

  // This method refreshes the number of tiles that the player wishes to refresh
  public static ArrayList<Tile> temporary = tileRack;
  public static void refreshTiles(int[] indexes){
    if (indexes.length < 1 || indexes.length > tileRack.size()){
      System.out.println("Invalid number!");
    }
    else{
      for(int x = 0; x < indexes.length; x++){
        Tile currTile = tileRack.get(indexes[x] - 1);
        tileRack.remove(indexes[x] - 1);
        tileBag.add(currTile);

        System.out.println("\nOLD TILE: " + currTile.getLetter().toUpperCase());
        
        int newIndex = (int) (Math.random() * tileBag.size());
        tileRack.add(indexes[x] - 1, tileBag.get(newIndex));
        tileBag.remove(newIndex);

        System.out.println("NEW TILE: " + tileRack.get(indexes[x] -1).getLetter().toUpperCase() + "\n");
      }
    }
  }

  public static void fillRack(){
    int size = tileRack.size();
    for(int x = 0; x < 7 - size; x++){
      int chosenIndex = (int) (Math.random() * tileBag.size());
      Tile chosenTile = tileBag.get(chosenIndex);
      Tile temp = chosenTile;
      tileBag.remove(chosenIndex);
      tileRack.add(temp);
    }
  }

  // Shows the rack of tiles to the player.
  public static void showRack(){
    System.out.println(Styling.UNDERLINE + "\nTILE RACK" + Styling.RESET) ;
    for(int x = 0; x < tileRack.size(); x++){
      System.out.print(tileRack.get(x).getLetter());
    }
  }

  public static ArrayList<Tile> getRack(){
    return tileRack;
  }

  public static ArrayList<Tile> getBag(){
    return tileBag;
  }

  public String getLetter(){
    return letter;
  }

   public static void setRack(ArrayList<Tile> newRack){
    tileRack = newRack;
  }

  public static void setupBag(){
    for(int x = 0; x < 9; x++){
      Tile a = new Tile("a", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 2; x++){
      Tile a = new Tile("b", values[1]);
      tileBag.add(a);
    }
    for(int x = 0; x < 2; x++){
      Tile a = new Tile("c", values[2]);
      tileBag.add(a);
    }
    for(int x = 0; x < 4; x++){
      Tile a = new Tile("d", values[3]);
      tileBag.add(a);
    }
    for(int x = 0; x < 12; x++){
      Tile a = new Tile("e", values[4]);
      tileBag.add(a);
    }
    for(int x = 0; x < 2; x++){
      Tile a = new Tile("f", values[5]);
      tileBag.add(a);
    }
    for(int x = 0; x < 3; x++){
      Tile a = new Tile("g", values[6]);
      tileBag.add(a);
    }
    for(int x = 0; x < 2; x++){
      Tile a = new Tile("h", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 9; x++){
      Tile a = new Tile("i", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 1; x++){
      Tile a = new Tile("j", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 1; x++){
      Tile a = new Tile("k", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 4; x++){
      Tile a = new Tile("l", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 2; x++){
      Tile a = new Tile("m", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 6; x++){
      Tile a = new Tile("n", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 8; x++){
      Tile a = new Tile("o", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 2; x++){
      Tile a = new Tile("p", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 1; x++){
      Tile a = new Tile("q", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 6; x++){
      Tile a = new Tile("r", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 4; x++){
      Tile a = new Tile("s", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 6; x++){
      Tile a = new Tile("t", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 4; x++){
      Tile a = new Tile("u", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 2; x++){
      Tile a = new Tile("v", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 2; x++){
      Tile a = new Tile("w", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 1; x++){
      Tile a = new Tile("x", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 2; x++){
      Tile a = new Tile("y", values[0]);
      tileBag.add(a);
    }
    for(int x = 0; x < 1; x++){
      Tile a = new Tile("z", values[0]);
      tileBag.add(a);
    }
    
  }
}