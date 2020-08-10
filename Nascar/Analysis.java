

import java.util.*;

public class Analysis{
    String group[];
    HashMap<String, Racer> racers;

    Analysis(String group[], HashMap<String, Racer> racers){
      this.group = group;
      this.racers = racers;
      ShowStats();
    }


    void ShowStats(){

      for(String val : group){
        Racer tmp = racers.get(val);
        System.out.print(tmp.pos);
        System.out.println();

      }


    }


}
