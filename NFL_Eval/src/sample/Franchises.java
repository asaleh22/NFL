package sample;

import javafx.scene.image.Image;

import java.net.URL;

public class Franchises { //change numbers to follow folder to right

    final static int _49ers     =  0;
    final static int Bears      =  1;
    final static int Bengals    =  2;
    final static int Bills      =  3;
    final static int Broncos    =  4;
    final static int Browns     =  5;
    final static int Buccaneers =  6;
    final static int Cardinals  =  7;
    final static int Chargers   =  8;
    final static int Chiefs     =  9;
    final static int Colts      =  10;
    final static int Cowboys    =  11;
    final static int Dolphins   =  12;
    final static int Eagles     =  13;
    final static int Falcons    =  14;
    final static int Giants     =  15;
    final static int Jaguars    =  16;
    final static int Jets       =  17;
    final static int Lions      =  18;
    final static int Packers    =  19;
    final static int Panthers   =  20;
    final static int Patriots   =  21;
    final static int Raiders    =  22;
    final static int Rams       =  23;
    final static int Ravens     =  24;
    final static int Saints     =  25;
    final static int Seahawks   =  26;
    final static int Steelers   =  27;
    final static int Texans     =  28;
    final static int Titans     =  29;
    final static int Vikings    =  30;
    final static int Washington =  31;



     public static String getTeam(int team){ //returns the team name, which is the Key to the tables that will be used
                                     // Must wrap the quarterbacks some how.
            //given a team determine which image to return
         switch(team){
             case Bears:        return "Chicago Bears";
             case Packers:      return "Green Bay Packers";
             case Lions:        return "Detroit Lions";
             case Vikings:      return "Minnesota Vikings";
             case _49ers:       return "San Francisco 49ers";
             case  Seahawks:    return "Seattle Seahawks";
             case  Rams:        return "Los Angeles Rams";
             case  Cardinals:   return "Arizona Cardinals";
             case  Saints:      return "New Orleans Saints";
             case  Panthers:    return "Carolina Panthers";
             case  Buccaneers:  return "Tampa Bay Buccaneers";
             case  Falcons:     return "Atlanta Falcons";
             case  Cowboys:     return "Dallas Cowboys";
             case  Eagles:      return "Philadelphia Eagles";
             case  Giants:      return "New York Giants";
             case  Washington:  return "Washington Football Team";
             case  Colts:       return "Indianapolis Colts";
             case  Texans:      return "Houston Texans";
             case  Jaguars:     return "Jacksonville Jaguars";
             case  Titans:      return "Tennessee Titans";
             case  Patriots:    return "New England Patriots";
             case  Bills:       return "Buffalo Bills";
             case  Dolphins:    return "Miami Dolphins";
             case  Jets:        return "New York Jets";
             case  Chiefs:      return "Kansas City Chiefs";
             case  Broncos:     return "Denver Broncos";
             case  Chargers:    return "Los Angeles Chargers";
             case  Raiders:     return "Las Vegas Raiders";
             case  Steelers:    return "Pittsburgh Steelers";
             case  Ravens:      return "Baltimore Ravens";
             case  Browns:      return "Cleveland Browns";
             case  Bengals:     return "Cincinnati Bengals";

         }

        // return "/resources/bears.png";
        return "null";
     }


    static String getTeam(URL team){

        return " sa";

    }

}


/*
 final static String Bears  "Bears";
        final static String Packers  "Packers";
        final static String Lions  "Lions";
        final static String Vikings  "Vikings";
        final static String _49ers  "49ers";
        final static String Seahawks  "Seahawks";
        final static String Rams  "Rams";
        final static String Cardinals  "Cardinals";
        final static String Saints  "Saints";
        final static String Panthers  "Panthers";
        final static String Buccaneers  "Buccaneers";
        final static String Falcons  "Falcons";
        final static String Cowboys  "Cowboys";
        final static String Eagles  "Eagles";
        final static String Giants  "Giants";
        final static String Washington  "Washington";
        final static String Colts  "Colts";
        final static String Texans  "Texans";
        final static String Jaguars  "Jaguars";
        final static String Titans  "Titans";
        final static String Patriots  "Patriots";
        final static String Bills  "Bills";
        final static String Dolphins  "Dolphins";
        final static String Jets  "Jets";
        final static String Chiefs  "Chiefs";
        final static String Broncos  "Broncos";
        final static String Chargers  "Chargers";
        final static String Raiders  "Raiders";
        final static String Steelers  "Steelers";
        final static String Ravens  "Ravens";
        final static String Browns  "Browns";
        final static String Bengals  "Bengals";


 */