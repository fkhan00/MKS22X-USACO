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
    System.out.println(" " + lake.length + " " + lake[0].length);
    int counter = 0;
    while(counter < lake.length){
      output = text.nextLine();
      for(int i = 0; i < output.length(); i++){
        try{
        lake[counter][i / 2] = Integer.parseInt(output.substring(i, i + 1));}
        catch(NumberFormatException e){}}
      counter ++;}
    instructions = new ArrayList<ArrayList<Integer>>();
    counter = 0;
    while(text.hasNextLine()){
      output = text.nextLine();
      instructions.add(new ArrayList<Integer>());
      counter ++;
      for(int i = 0; i < 3; i++){
        instructions.get(counter).add(Integer.parseInt(output.substring(i, i + 1)));}}}

}
