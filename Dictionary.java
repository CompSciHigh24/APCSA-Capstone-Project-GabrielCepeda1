import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;
import java.util.*;

// DICTIONARY CLASS: The dictionary for the game; uses every word in the English dictionary
public class Dictionary {
  public static ArrayList<String[]> words = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    System.out.println("Hello world!");
  }

  public static void dictSetup() {
    String folder = "./WordLists";
    File fold = new File(folder);
    ArrayList<String[]> data = new ArrayList<>();

    if(fold.isDirectory()){
      File[] files = fold.listFiles();

      if (files != null){
        for(File file : files){
          if (file.isFile()){
            try{
              List<String> lines = Files.readAllLines(file.toPath());
              for (String line : lines){
                String[] values = line.split(",");
                data.add(values);
              }
            } catch (IOException e){
              System.out.print("");
            }
          }
        }
      }
    }
    words = data;

  }

  public static ArrayList<String[]> getDict(){
    return words;
  }
}