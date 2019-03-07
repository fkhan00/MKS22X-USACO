import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
public class Silver{
  public int[][] ways;
  public String[][] field;
  public int time;
  public int[] start = new int[2];
  public int[] end = new int[2];
  public void info(String text) throws FileNotFoundException{
    File file = new File(text);
    Scanner scan = new Scanner(file);
    field = new String[scan.nextInt()][scan.nextInt()];
    ways = new int[field.length][field[0].length];
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

  public void expand(int n){
    if(n == 1){
      ways[start[0]][start[1]] = 1;}
    if (n == 2){
      ways[start[0]][start[1]] = 0;
      ways[start[0] + 1][start[1]] = 1;
      ways[start[0]][start[1] + 1] = 1;
      ways[start[0] - 1][start[1]] = 1;
      ways[start[0]][start[1] - 1] = 1;}
    else{
      int[][] newWay = new int[ways.length][ways[0].length];
      for(int i = 0; i < ways.length; i++){
        for(int j = 0; j < ways[0].length; j++){
          try{
          if(ways[i - 1][j] != 0 && ways[i][j - 1] != 0){
            newWay[i][j] = ways[i - 1][j] + ways[i][j - 1];}}
          catch(IndexOutOfBoundsException e){}
          try{
          if(ways[i][j + 1] != 0 && ways[i - 1][j] != 0){
            newWay[i][j] = ways[i][j + 1] + ways[i - 1][j];}}
          catch(IndexOutOfBoundsException e){}
          try{
          if(ways[i + 1][j] != 0 && ways[i][j + 1] != 0){
            newWay[i][j] = ways[i + 1][j] + ways[i][j + 1];}}
          catch(IndexOutOfBoundsException e){}
          try{
          if(ways[i + 1][j] != 0 && ways[i][j - 1] != 0){
            newWay[i][j] = ways[i + 1][j] + ways[i][j - 1];}}
          catch(IndexOutOfBoundsException e){}}}
        try{
        newWay[start[0] + n][start[1]] = 1;
        newWay[start[0]][start[1] + n] = 1;
        newWay[start[0] - n][start[1]] = 1;
        newWay[start[0]][start[1] - n] = 1;}
        catch(IndexOutOfBoundsException e){}
        for(int i = 0; i < ways.length; i++){
          for(int j = 0; j < ways[0].length; j++){
            ways[i][j] = newWay[i][j];}}}

  }
  public String toString(){
    String output = "";
    for(int i = 0; i < field.length; i++){
      for(int j = 0; j < field[0].length; j++){
        output += field[i][j] + " ";}
      output += "\n";}
  return output;}

}
