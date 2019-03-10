import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
public class USACO{
  public class bronze{
  public int[][] lake;
  public ArrayList<ArrayList<Integer>> instructions;
  public int finalDep;
  public int multiplier;
  public void info(String name) throws FileNotFoundException{
    File file = new File(name);
    Scanner text = new Scanner(file);
    String output = text.nextLine();
    lake = new int[Integer.parseInt(output.substring(0, 1))][Integer.parseInt(output.substring(2, 3))];
    finalDep = Integer.parseInt(output.substring(4, 6));
    multiplier = Integer.parseInt(output.substring(7, 8));
    int counter = 0;
    while(counter < lake.length){
      for(int i = 0; i < lake[0].length; i++){
        lake[counter][i] = text.nextInt();}
      counter ++;
    }
    instructions = new ArrayList<ArrayList<Integer>>();
    while(text.hasNextInt()){
      instructions.add(new ArrayList<Integer>());
      for(int i = 0; i < 3; i++){
        instructions.get(instructions.size() - 1).add(text.nextInt());}}
  }
  public String toString(){
    String output = "";
    for(int i = 0; i < lake.length; i++){
      for(int j = 0; j < lake[0].length; j++){
        output += lake[i][j] + " ";}
      output += "\n";}
  return output;}

  public void stomp(int ins){
    ArrayList<Integer> herd = new ArrayList<Integer>();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        herd.add(lake[instructions.get(ins).get(0) + i - 1][instructions.get(ins).get(1) + j - 1]);}}
    int max = Collections.max(herd);
    herd.set(herd.indexOf(max), max - instructions.get(ins).get(2));
    for(int i = 0; i < herd.size(); i++){
      if(herd.get(i) >= herd.get(herd.indexOf(max - instructions.get(ins).get(2))))
      {
        herd.set(i, herd.get(herd.indexOf(max - instructions.get(ins).get(2))));}}
    int counter = 0;
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        lake[instructions.get(ins).get(0) + i - 1][instructions.get(ins).get(1) + j - 1] = herd.get(counter);
        counter ++;}}}
    public int bronze(String text)throws FileNotFoundException{
      info(text);
      for(int i = 0; i < instructions.size(); i++){
        stomp(i);}
      int sum = 0;
      for(int i = 0; i < lake.length; i++){
        for(int j = 0; j < lake[0].length; j++){
          if(lake[i][j] < finalDep){
            sum += finalDep - lake[i][j];}}}
      return sum * 36 * 36 * multiplier * multiplier;}}
  public class silver{
        public int[][] ways;
        public String[][] field;
        public int time;
        public int[] start = new int[2];
        public int[] end = new int[2];
        public int movesX[] = {1, -1, 0, 0};
        public int movesY[] = {0, 0, -1, 1 };
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
            return;}
          int[][] newWay = new int[ways.length][ways[0].length];
          for(int i = 0; i < ways.length; i++){
            for(int j = 0; j < ways[0].length; j++){
              if(ways[i][j] != 0){
                for(int k = 0; k < movesX.length; k++){
                  try{
                  if(field[i + movesX[k]][j + movesY[k]].equals(".")){
                    newWay[i + movesX[k]][j + movesY[k]] += ways[i][j];}}
                  catch(IndexOutOfBoundsException e){}
                  }}}}
          for(int i = 0 ;i < ways.length; i++){
            for(int j = 0; j < ways[0].length; j++){
              ways[i][j] = newWay[i][j];}}}

          public int silver(String text) throws FileNotFoundException{
            info(text);
            for(int i = 0; i < time + 1; i++){
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


}
