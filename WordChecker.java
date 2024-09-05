import java.util.ArrayList;
import java.util.regex.Pattern;

public class WordChecker{
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  // This array will hold all the words that have ALREADY been guessed
  public static String[] currWords = {};

  public static String[] getWords(){
    return currWords;
  }

  public static void indexSort(ArrayList<Integer> array){
    int temp;
    for(int x = 0; x < array.size() -1; x++){
      if (array.get(x) > array.get(x+1)){
        temp = array.get(x);
        array.set(x, array.get(x+1));
        array.set(x+1, temp);
        x = -1;
      }
    }
  }

  public static String stylingCheck(String thing){
    String regex = "\\u001B\\[[;\\d]*[ -/]*[@-~]";
    // Use Pattern to find and remove the escape codes
    Pattern pattern = Pattern.compile(regex);
    String newthing = pattern.matcher(thing).replaceAll("");
    //System.out.println("styling check newthing is " + newthing);
    return newthing;
  }

  public static void wordCheck(ArrayList<Integer> r, ArrayList<Integer> c){ 
    //  aaaaaaaaaaa
    //System.out.println("word check");
    //  aaaaaaaaaaa
    String word = "";
    int wordval = 0;
    int wordmulti = 1;
    String[][] vals = Board.getBV();
    if(r.get(0) == r.get(1)){
      indexSort(c);
      for(int x = 0; x < r.size(); x++){
        //  aaaaaaaaaaa
        // System.out.println("r");
        //  aaaaaaaaaaa
        String multi = Board.checkforMultiplier(r.get(x), c.get(x));
        //System.out.println("multi: " + multi);
        if (multi.indexOf("l") > -1){
          System.out.println("THE VALUE OF THE TILE IS " + Tile.findVal(vals[r.get(x)][c.get(x)]));
          wordval += Integer.parseInt(multi.replace("l", "")) * Tile.findVal(vals[r.get(x)][c.get(x)]);
        }
        else{
          //System.out.println("checking " + stylingCheck(vals[r.get(x)][c.get(x)]));
          //System.out.println("value is " + Tile.findVal(vals[r.get(x)][c.get(x)]));
          wordval += Tile.findVal(stylingCheck(vals[r.get(x)][c.get(x)]));
        }
        if (multi.indexOf("w") > -1){
          wordmulti += Integer.parseInt(multi.replace("w", "")) - 1;
        }
        word = stylingCheck(word);
        word += Board.getBV()[r.get(x)][c.get(x)].replace(" ", "");
      }
      wordval *= wordmulti;
      //System.out.println("word " + word);
    }
    else if(c.get(0) == c.get(1)){
      indexSort(r);
      for(int x = 0; x < c.size(); x++){
        //  aaaaaaaaaaa
        System.out.println("c");
        //  aaaaaaaaaaa
        String multi = Board.checkforMultiplier(r.get(x), c.get(x));
        if (multi.indexOf("l") > -1){
          System.out.println("THE VALUE OF THE TILE IS " + Tile.findVal(vals[r.get(x)][c.get(x)]));
          wordval += Integer.parseInt(multi.replace("l", "")) * Tile.findVal(vals[r.get(x)][c.get(x)]);
        }
        if (multi.indexOf("w") > -1){
          wordmulti += Integer.parseInt(multi.replace("w", "")) - 1;
        }
        word = stylingCheck(word);
        word += Board.getBV()[r.get(x)][c.get(x)].replace(" ", "");
      }
      wordval *= wordmulti;  
      //System.out.println("word " + word);
    }
   // System.out.println("val is " + wordval);

    boolean t = false;
    ArrayList<String[]> dictionary = Dictionary.getDict();
    for(String[] w : dictionary){
      for(String ww : w){
        System.out.print(ww + " " + word);
        if (ww.trim().equalsIgnoreCase(word.trim())){
          System.out.println("word match");
          System.out.println("\nNice! You got " + wordval + " points!\n");
          Player.addToScore(wordval);
          t = true;
          break;
        }
      }
    }
    if (!t){
      System.out.println("No matches in the dictionary, turn skipped!\n");
    }
  }
  
}