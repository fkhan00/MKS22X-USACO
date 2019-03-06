import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collections;
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
    int counter = 0;
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        herd.add(lake[instructions.get(ins).get(0) + i - 1][instructions.get(ins).get(1) + j - 1]);}}
    Collections.sort(herd);
    herd.set(herd.size() - 1, herd.get(herd.size() - 1) - instructions.get(ins).get(2));
    System.out.println(herd.toString());
    for(int i = 0; i < herd.size(); i++){
      System.out.println(herd.toString());
      if(herd.get(i) >= herd.get(herd.size() - 1)){
        herd.set(i, herd.get(herd.size() - 1));}}}

      }
