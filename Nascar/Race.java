
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Race{

  public static void main(String[] args) {

    Race r = new Race();
    HashMap<String, Racer> racers = new HashMap<String,Racer>();
    //build it.


    Builder b = new Builder(racers);
    int count = 0;

    System.out.println("Enter the jersey numbers of Five racers for each of the six groups to compare:");

    Scanner in = new Scanner(System.in);
    while(count != 6){
        r.printStatement(count);
        String group[] = new String[5];
        int groupCount = 0;

        while(groupCount != 5){
          group[groupCount] = in.nextLine();
          ++groupCount;
        }

        Analysis finalAnalysis = new Analysis(group, racers);
        if(!finalAnalysis.determineValid()){
          System.out.println("Unrecognized Number " + finalAnalysis.getWrongNumber() + ". Try Again.");
          continue;
        }
        else{
          finalAnalysis.ShowStats();
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        ++count;
    }

  }

  public void printStatement(int count){
    switch(count){
      case 0: System.out.println("First Group: ");
              break;
      case 1: System.out.println("Second Group: ");
              break;
      case 2: System.out.println("Third Group: ");
              break;
      case 3: System.out.println("Fourth Group: ");
              break;
      case 4: System.out.println("Fifth Group: ");
              break;
      case 5: System.out.println("Sixth Group: ");
              break;
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
