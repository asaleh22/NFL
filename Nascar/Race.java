
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Race{

  public static void main(String[] args) {


    HashMap<String, Racer> racers = new HashMap<String,Racer>();
    //build it.


    Builder b = new Builder(racers);
    int count = 0;

    System.out.println("Five Racers to Compare:");

    Scanner in = new Scanner(System.in);
while(count != 6){
    String group[] = new String[5];
    int groupCount = 0;
    while(groupCount != 5){
      group[groupCount] = in.nextLine();
      ++groupCount;

    }
    Analysis finalAnal = new Analysis(group, racers);
    System.out.println("----------------------------------------------------------");
    System.out.println("----------------------------------------------------------");
    ++count;
}

  }

}

class Builder{

  HashMap<String, Racer> racers;

  Builder(HashMap<String, Racer> racers){
    this.racers = racers;
    build("Data.csv");
  }


  void build(String csv){
    BufferedReader br = null;
    String line = "";
    String csvSplit = ",";
    String[] races = new String[0];

    try {
        br = new BufferedReader(new FileReader(csv));


        while ((line = br.readLine()) != null) {
          races = line.split(csvSplit);
          Racer tmp = new Racer(races[0], races[1]);
          racers.put(tmp.name,tmp);
}
    }
    catch (IOException io) {
        System.out.println(io);
    }



  }


}
