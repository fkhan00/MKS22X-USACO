public class USACO{
  public int[][] lake;
  public ArrayList<ArrayList<Integer>> instructions;
  public void info(String name){
    File file = new File(name);
    Scanner text = new Scanner(file);
    String output = text.nextLine();
    lake = new int[Integer.parseInt(output.substring(0, 1))][Integer.parseInt(output.substring(1, 2))];
    int counter = 0;
    while(counter < lake.length){
      output = text.nextLine();
      for(int i = 0; i < output.length; i++){
        lake[counter][i] = Integer.parseInt(output.substring(i, i + 1));}
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
