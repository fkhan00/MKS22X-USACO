import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class USACO{
  public int[][] lake;
  public ArrayList<ArrayList<Integer>> instructions;
  public void info(String name) throws FileNotFoundException{
    File file = new File(name);
    Scanner text = new Scanner(file);
    String output = text.nextLine();
    lake = new int[Integer.parseInt(output.substring(0, 1))][Integer.parseInt(output.substring(2, 3))];
    int counter = 0;
    while(counter < lake.length){
      for(int i = 0; i < lake[0].length; i++){
        lake[counter][i] = text.nextInt();}
      counter ++;
    }}
  public String toString(){
    String output = "";
    for(int i = 0; i < lake.length; i++){
      for(int j = 0; j < lake[0].length; j++){
        output += lake[i][j] + " ";
      }
      output += "\n";
    }
  return output;
  }

}
