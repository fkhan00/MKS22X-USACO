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
    start[0] = scan.nextInt() - 1;
    start[1] = scan.nextInt() - 1;
    end[0] = scan.nextInt() - 1;
    end[1] = scan.nextInt() - 1;}

  public void expand(int n){
    if(n == 0){
      ways[start[0]][start[1]] = 1;
      return;
    }
    if (n == 1){
      try{
      ways[start[0]][start[1]] = 0;}
      catch(IndexOutOfBoundsException e){}
      try{
      ways[start[0] + 1][start[1]] = 1;}
      catch(IndexOutOfBoundsException e){}
      try{
      ways[start[0]][start[1] + 1] = 1;}
      catch(IndexOutOfBoundsException e){}
      try{
      ways[start[0] - 1][start[1]] = 1;}
      catch(IndexOutOfBoundsException e){}
      try{
      ways[start[0]][start[1] - 1] = 1;}
      catch(IndexOutOfBoundsException e){}}
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
        newWay[start[0] + n][start[1]] = 1;}
        catch(IndexOutOfBoundsException e){}
        try{
        newWay[start[0]][start[1] + n] = 1;}
        catch(IndexOutOfBoundsException e){}
        try{
        newWay[start[0] - n][start[1]] = 1;}
        catch(IndexOutOfBoundsException e){}
        try{
        newWay[start[0]][start[1] - n] = 1;}
        catch(IndexOutOfBoundsException e){}
        if(n % 2 == 1){
          newWay[start[0]] [start[1]] = 0;}
        if(n % 2 == 1){
          newWay[start[0]][start[1]] = ways[start[0] + 1][start[1]] * 4;}
        for(int i = 0; i < ways.length; i++){
          for(int j = 0; j < ways[0].length; j++){
            if(field[i][j].equals(".")){
            ways[i][j] = newWay[i][j];}
            else{
              ways[i][j] = 0;
            }
          }}}}

    public int silver(String text) throws FileNotFoundException{
      info(text);
      for(int i = 0; i < time; i++){
        expand(i);}
      System.out.println(toString());
      return ways[end[0]][end[1]];
    }
  public String toString(){
    String output = "";
    for(int i = 0; i < ways.length; i++){
      for(int j = 0; j < ways[0].length; j++){
        output += ways[i][j] + " ";}
      output += "\n";}
  return output;}

}
