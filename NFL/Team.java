import java.io.*;
import java.util.*;
import java.util.ArrayList;

//Class Team has two nested classes Offense and Defense.
//Classes Offense and Defense each have two nested classes, Passing and Rushing.
//Each enclosing and nested class carry the relevant information to itself.

class Team {

  String name;
  Defense def;
  Offense off;

  Team(String Name){
    this.name = Name;

    def = new Defense();
    off = new Offense();
  }


class Defense{

  Rushing rush;
  Passing pass;

  String yrdsPerPlay;
  String TakeAways;
  String fumbles;
  String fst_Total;
  String pen;
  String fstByPen;
  String tdDrives_percentage;
  String turnOverDrives_percentage;

  Defense(){
    this.rush = new Rushing();
    this.pass = new Passing();
  }
  public void e_Defense_Overview(){
    System.out.println("Average yards per play given up.");
    System.out.println("Total defense Takeaways");
    System.out.println("Fumbles Recovered");
    System.out.println("Total First downs given up");
    System.out.println("Total penalties taken");
    System.out.println("Total firsts given up by penalities.");
    System.out.println("Percentage of drives ending in a td.");
    System.out.println("Percentage of drives ending in a turnover.");

  }

  public void setRushAndPass(String yrdsPerPlay, String TakeAways, String fumbles, String fst_Total,
                              String fst_run, String fst_pass, String pen, String fstByPen, String tdDrives_percentage, String turnOverDrives_percentage){

        this.yrdsPerPlay = yrdsPerPlay;
        this.TakeAways = TakeAways;
        this.fumbles = fumbles;
        this.fst_Total = fst_Total;
        rush.fst_run = fst_run;
        pass.fst_pass = fst_pass;
        this.pen = pen;
        this.fstByPen = fstByPen;
        this.tdDrives_percentage = tdDrives_percentage;
        this.turnOverDrives_percentage = turnOverDrives_percentage;
  }



  class Rushing{
    String td;
    String yrdsPer_A;
    String yrdsPer_G;
    String fst_run;

    public void setRushDef(String TD, String yrdsPer_A, String yrdsPer_G){
      this.td = TD;
      this.yrdsPer_A = yrdsPer_A;
      this.yrdsPer_G = yrdsPer_G;
    }

    public void e_Defense_Rushing(){
      System.out.println("Total Rushing TDS given up.");
      System.out.println("Average yards per attempt given up.");
      System.out.println("Average yards per game given up.");

    }

  }

  class Passing{

    String Att;
    String Cmp_Percentage;
    String Yds;
    String TD;
    String TD_percentage;
    String Int;
    String Int_percentage;
    String yrdsPer_A;
    String yrdsPer_C;
    String yrdsPer_G;
    String qbRating;
    String Sk;
    String QBHits;
    String TFL;
    String yardsGainedPerAttempt;
    String sackPercentage;
    String fst_pass;

    public void setPassDef(String Att,String Cmp_Percentage,String Yds,String TD,
                           String TD_percentage, String Int, String Int_percentage,
                           String yrdsPer_A, String yrdsPer_C, String yrdsPer_G,
                           String qbRating, String Sk, String QBHits, String TFL,
                           String yardsGainedPerAttempt, String sackPercentage){


      this.Att = Att;
      this.Cmp_Percentage = Cmp_Percentage;
      this.Yds = Yds;
      this.TD = TD;
      this.TD_percentage = TD_percentage;
      this.Int = Int;
      this.Int_percentage = Int_percentage;
      this.yrdsPer_A = yrdsPer_A;
      this.yrdsPer_C = yrdsPer_C;
      this.yrdsPer_G = yrdsPer_G;
      this.qbRating = qbRating;
      this.Sk = Sk;
      this.QBHits = QBHits;
      this.TFL = TFL;
      this.yardsGainedPerAttempt = yardsGainedPerAttempt;
      this.sackPercentage = sackPercentage;


    }

  }


}

class Offense{

Passing pass;
Rushing rush;
ArrayList<Passing> passers;
// ----------------------------------//
String yardsPerPlay;
String turnOvers;
String fumbleslost;
String fstDtotal;
String passesAttempt;
String passingYrds;
String passingTD;
String passingINT;
String fstDbypass;
String rushingattempt;
String rushingyrds;
String td_rushing;
String fstdwnbyrun;
String penalties;
String fstbyPenalty;
String percentofscorebyoffense;
String percentageofdrivesendingturnover;

  Offense(){
    passers = new ArrayList<Passing>();
    this.rush = new Rushing();
  }

  public void setRushAndPass(String yardsPerPlay, String takeAways, String fumbleslost, String fstDtotal,
  String passesAttempt,String passingYrds, String passingTD, String passingINT, String fstDbypass,
  String rushingattempt, String rushingyrds, String td_rushing, String fstdwnbyrun,
  String penalties, String fstbyPenalty, String percentofscorebyoffense, String percentageofdrivesendingturnover){


    this.yardsPerPlay = yardsPerPlay;
    this.turnOvers = takeAways;
    this.fumbleslost = fumbleslost;
    this.fstDtotal = fstDtotal;
    this.passesAttempt = passesAttempt;
    this.passingYrds = passingYrds;
    this.passingTD = passingTD;
    this.passingINT = passingINT;
    this.fstDbypass = fstDbypass;
    this.rushingattempt = rushingattempt;
    this.rushingyrds = rushingyrds;
    this.td_rushing = td_rushing;
    this.fstdwnbyrun = fstdwnbyrun;
    this.penalties = penalties;
    this.fstbyPenalty = fstbyPenalty;
    this.percentofscorebyoffense = percentofscorebyoffense;
    this.percentageofdrivesendingturnover = percentageofdrivesendingturnover;
  }

  public void initPasser(){
    this.pass = new Passing();
  }


  class Rushing{
    String yrds;
    String TD;
    String yrdsPer_A;
    String yrdsPer_G;
    String fmb;

    public void setRushOff(String yrds, String TD, String yrdsPer_A, String yrdsPer_G, String fmb){
      this.yrds = yrds;
      this.TD = TD;
      this.yrdsPer_A = yrdsPer_A;
      this.yrdsPer_G = yrdsPer_G;
      this.fmb = fmb;

    }


  }

  class Passing{
    String Name;
    String comp_Percentage;
    String yards;
    String td;
    String td_Percentage;
    String INT;
    String intPercentage;
    String Lng;
    String yardsPerAttempt;
    String yardsPerCompletion;
    String yardsPerGame;
    String qbr;
    String sacks;
    String comeBacks;
    String GWD;


    public void setPasser(String Name, String comp_Percentage, String yards, String td,
                          String td_Percentage, String INT, String intPercentage, String Lng,
                          String yardsPerAttempt, String yardsPerCompletion, String yardsPerGame,
                          String qbr, String sacks, String comeBacks, String GWD){
      this.Name = Name;
      this.comp_Percentage = comp_Percentage;
      this.yards = yards;
      this.td = td;
      this.td_Percentage = td_Percentage;
      this.INT = INT;
      this.intPercentage = intPercentage;
      this.Lng = Lng;
      this.yardsPerAttempt = yardsPerAttempt;
      this.yardsPerCompletion = yardsPerCompletion;
      this.yardsPerGame = yardsPerGame;
      this.qbr = qbr;
      this.sacks = sacks;
      this.comeBacks = comeBacks;
      this.GWD = GWD;

      passers.add(this);

    }


  }


}



}
