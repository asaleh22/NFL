

import java.util.*;

public class Analysis{
    String group[];
    HashMap<String, Racer> racers;
    String WrongNumber;

    Analysis(String group[], HashMap<String, Racer> racers){
      this.group = group;
      this.racers = racers;
    }

    String getWrongNumber() {return WrongNumber;}


    void ShowStats(){

    for(String val : group){

      Racer tmp = racers.get(val);
      System.out.println(tmp.pos);
    }

  }

    boolean determineValid(){

      for(String val : group){
        if(!racers.containsKey(val)){
          WrongNumber = val;
          return false;
        }
      }

      return true;
    }


}
