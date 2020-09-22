package sample;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
public class Builder{

    HashMap<Integer, Racer> racers;

    Builder(HashMap<Integer, Racer> racers){
        this.racers = racers;
        build("C:\\cygwin64\\home\\Desktop\\Practice\\JavaFX\\src\\sample\\Data.txt");
    }


    void build(String csv){
        BufferedReader br = null;
        String line = "";
        String csvSplit = ",";
        String[] races;

        try {
            br = new BufferedReader(new FileReader(csv));


            while ((line = br.readLine()) != null) {
                races = line.split(csvSplit);
                Racer tmp = new Racer(races[0], races[1]);
                racers.put(Integer.valueOf(tmp.num),tmp);

            }
        }
        catch (IOException io) {
            System.out.println("Error: " + io);
        }



    }


}
