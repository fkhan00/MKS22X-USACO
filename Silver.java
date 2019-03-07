import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
public class Silver{
  public String[][] field;
  public int time;
  public int[] start = new int[2];
  public int[] end = new int[2];
  public void info(String text) throws FileNotFoundException{
    File file = new File(text);
    Scanner scan = new Scanner(file);
    field = new String[scan.nextInt()][scan.nextInt()];
    time = scan.nextInt();
    scan.nextLine();
    String output = "";
    for(int i = 0; i < field.length; i++){
      output = scan.nextLine();
      for(int j = 0; j < field[0].length; j++){
        field[i][j] = output.substring(j, j + 1);}}
    start[0] = scan.nextInt();
    start[1] = scan.nextInt();
    end[0] = scan.nextInt();
    end[1] = scan.nextInt();}

  public String toString(){
    String output = "";
    for(int i = 0; i < field.length; i++){
      for(int j = 0; j < field[0].length; j++){
        output += field[i][j] + " ";}
      output += "\n";}
  return output;}
}
