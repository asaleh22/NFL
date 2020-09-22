package sample;

import javafx.scene.text.Text;

import java.util.*;

public class Analysis{
    HashMap<Integer, Racer> racers;
    Integer WrongNumber;
    ArrayList<Integer> group;
    Text text;
    Analysis(ArrayList<Integer> group, HashMap<Integer, Racer> racers, Text text){

        this.group = group;
        this.racers = racers;
        this.text = text;
    }

    public void ShowStats(){

        if(!determineValid()) {
            System.out.println("Error: " + WrongNumber + " does not match a player");
            return;
        }

        text.setText("");
        for(Integer val : group){
            Racer tmp = racers.get(val);
            text.setText(text.getText() + "\n" + tmp.pos);
        }
    }

    boolean determineValid(){

        for(Integer val : group){
            if(!racers.containsKey(val)){
                WrongNumber = val;
                return false;
            }
        }

        return true;
    }


}
