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
    }
    instructions = new ArrayList<ArrayList<Integer>>();
    while(text.hasNextInt()){
      instructions.add(new ArrayList<Integer>());
      for(int i = 0; i < 3; i++){
        instructions.get(instructions.size() - 1).add(text.nextInt());}}
  }
  public String toString(){
    String output = "";
    for(int i = 0; i < instructions.size(); i++){
      for(int j = 0; j < instructions.get(0).size(); j++){
        output += instructions.get(i).get(j) + " ";}
      output += "\n";}
  return output;}

  public void stomp(int ins){
    int[] herd = new int[9];
    int counter = 0;
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        herd[counter] = lake[instructions.get(ins).get(0)][instructions.get(ins).get(0)];}}
    Collections.sort(herd);
    herd[0] -= instructions.get(ins).get(2);
    for(int i = 0; i < herd.length; i++){
      if(herd[i] >= herd[0]){
        herd[i] = herd[0];}}}

}
