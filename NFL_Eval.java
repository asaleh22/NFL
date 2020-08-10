import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class NFL_Eval {

  HashMap<String,Team> Teams;

    //Teams must be entered as they are in the CV: Chicago Bears... Detroit Lions...
    public static void main(String[] args) {
        NFL_Eval obj = new NFL_Eval();
        obj.run();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter matchup... \nFirst team: ");
        String teamA = in.nextLine();
        System.out.println("versus... ");
        String teamB = in.nextLine();

        obj.matchUpAnalysis(teamA, teamB);
    }

    //Builds the teams before the user enters the names.
    public void run() {

      Teams = buildTeams();

      String csv = "Rushing_Defense.csv";
      setRushingDefense(csv); //check
      csv = "Passing_Defense.csv";
      setPassingDefense(csv);//check

      csv = "Total_Defense.csv";
      setTotalDefense(csv);

      csv = "Passing_Offense.csv";
      setPassingOffense(csv);

      csv = "Rushing_Offense.csv";
      setRushingOffense(csv);

      csv = "Total_Offense.csv";
      setTotalOffense(csv);
    }


    //Gets the names and runs them through for an analysis
    public void matchUpAnalysis(String a, String b){
      Team A;
      Team B;
      if(Teams.containsKey(a)){ A = Teams.get(a);} else {System.out.println("Error, first team not recognized. Reboot."); return;}
      if(Teams.containsKey(b)){ B = Teams.get(b);} else {System.out.println("Error, second team not recognized. Reboot."); return;}

      Run_Analysis gameStats = new Run_Analysis(A,B);
    }


    //Enters the relevant information for this category.
    public void setTotalOffense(String csv){
      BufferedReader br = null;
      String line = "";
      String csvSplit = ",";
      String[] football = new String[0];

      try {
          br = new BufferedReader(new FileReader(csv));
          String headerLine = br.readLine();

          while ((line = br.readLine()) != null) {
            football = line.split(csvSplit);

            if(Teams.containsKey(football[1])){  //football[1] is the team name
            Team currTeam = Teams.get(football[1]);

            currTeam.off.setRushAndPass(football[6], football[7], football[8], //relevant info
                                  football[9], football[11], football[12],
                                  football[13], football[14], football[16],
                                  football[17], football[18], football[19], football[21], football[22], football[24], football[25], football[26]);
          }

  }
      }
      catch (IOException io) {
          System.out.println(io);
      }



    }

    //Enters the relevant information for this category.
    public void setRushingOffense(String csv){
      BufferedReader br = null;
      String line = "";
      String csvSplit = ",";
      String[] football = new String[0];

      try {
          br = new BufferedReader(new FileReader(csv));
          String headerLine = br.readLine();

          while ((line = br.readLine()) != null) {
            football = line.split(csvSplit);

            if(Teams.containsKey(football[1])){ //team name
            Team currTeam = Teams.get(football[1]);

            currTeam.off.rush.setRushOff(football[4], football[5], football[7], football[8], football[9]); //relevant info
          }

    }

  }
      catch (IOException io) {
          System.out.println(io);
      }

    }

    //Enters the relevant information for this category.
    public void setRushingDefense(String csv){

      BufferedReader br = null;
      String line = "";
      String csvSplit = ",";
      String[] football = new String[0];

      try {
          br = new BufferedReader(new FileReader(csv));
          String headerLine = br.readLine();

          while ((line = br.readLine()) != null) {
            football = line.split(csvSplit);

            if(Teams.containsKey(football[1])){
            Team currTeam = Teams.get(football[1]); //team name

            currTeam.def.rush.setRushDef(football[5], football[6], football[7]); //relevant info
          }

    }

  }
      catch (IOException io) {
          System.out.println(io);
      }

    }


    //Enters the relevant information for this category.
    public void setPassingDefense(String csv){
      BufferedReader br = null;
      String line = "";
      String csvSplit = ",";
      String[] football = new String[0];

      try {
          br = new BufferedReader(new FileReader(csv));
          String headerLine = br.readLine();

          while ((line = br.readLine()) != null) {
            football = line.split(csvSplit);

            if(Teams.containsKey(football[1])){
            Team currTeam = Teams.get(football[1]); //team name

            currTeam.def.pass.setPassDef(football[4], football[5], football[6], //relevant info
                                  football[7], football[8], football[9],
                                  football[11], football[12], football[14],
                                  football[15], football[16], football[17],
                                  football[19], football[20], football[21], football[23]);
          }

  }
      }
      catch (IOException io) {
          System.out.println(io);
      }

}

    //Enters the relevant information for this category.
    public void setTotalDefense(String csv){
      BufferedReader br = null;
      String line = "";
      String csvSplit = ",";
      String[] football = new String[0];

      try {
          br = new BufferedReader(new FileReader(csv));
          String headerLine = br.readLine();

          while ((line = br.readLine()) != null) {
            football = line.split(csvSplit);

            if(Teams.containsKey(football[1])){
            Team currTeam = Teams.get(football[1]); //team name

            currTeam.def.setRushAndPass(football[6], football[7], football[8], //relevant info
                                  football[9], football[16], football[21],
                                  football[22], football[24], football[25],
                                  football[26]);
          }

  }
      }
      catch (IOException io) {
          System.out.println(io);
      }


    }

    //Enters the relevant information for this category.
  public void setPassingOffense(String csv){
    BufferedReader br = null;
    String line = "";
    String csvSplit = ",";
    String[] football = new String[0];

    try {
        br = new BufferedReader(new FileReader(csv));
        String headerLine = br.readLine();

        while ((line = br.readLine()) != null) {
          football = line.split(csvSplit);
          String a = this.converter(football[2]); //converter needed for team abbreviations.Football[2] holds team abbreviations

          if(Teams.containsKey(a)){
          Team currTeam = Teams.get(a);

          currTeam.off.initPasser();
          currTeam.off.pass.setPasser(football[1], football[10], football[11], //relevant info
                                football[12], football[13], football[14],
                                football[15], football[16], football[17],
                                football[19], football[20], football[21],
                                football[23], football[27], football[28]);
        }

  }
    }
    catch (IOException io) {
        System.out.println(io);
    }




  }

    //Initial build for the teams hashmap.
    public HashMap<String, Team> buildTeams(){ //creates blank Team Objects.
      HashMap<String, Team> temp = new HashMap<>();

      temp.put("Chicago Bears", new Team("Bears"));
      temp.put("Cincinnati Bengals", new Team("Bengals"));
      temp.put("Tampa Bay Buccaneers", new Team("Buccaneers"));
      temp.put("New York Jets", new Team("Jets"));
      temp.put("Houston Texans", new Team("Texans"));
      temp.put("Philadelphia Eagles", new Team("Eagles"));
      temp.put("New Orleans Saints", new Team("Saints"));
      temp.put("Los Angeles Rams", new Team("Rams"));
      temp.put("Baltimore Ravens", new Team("Ravens"));
      temp.put("Oakland Raiders", new Team("Raiders"));
      temp.put("New England Patriots", new Team("Patriots"));
      temp.put("Minnesota Vikings", new Team("Vikings"));
      temp.put("Dallas Cowboys", new Team("Cowboys"));
      temp.put("Indianapolis Colts", new Team("Colts"));
      temp.put("Pittsburgh Steelers", new Team("Steelers"));
      temp.put("Denver Broncos", new Team("Broncos"));
      temp.put("Washington Redskins", new Team("Redskins"));
      temp.put("San Francisco 49ers", new Team("49ers"));
      temp.put("Atlanta Falcons", new Team("Falcons"));
      temp.put("Seattle Seahawks", new Team("Seahawks"));
      temp.put("Tennessee Titans", new Team("Titans"));
      temp.put("Buffalo Bills", new Team("Bills"));
      temp.put("Jacksonville Jaguars", new Team("Jaguars"));
      temp.put("Los Angeles Chargers", new Team("Chargers"));
      temp.put("Detroit Lions", new Team("Lions"));
      temp.put("Cleveland Browns", new Team("Browns"));
      temp.put("New York Giants", new Team("Giants"));
      temp.put("Carolina Panthers", new Team("Panthers"));
      temp.put("Arizona Cardinals", new Team("Cardinals"));
      temp.put("Green Bay Packers", new Team("Packers"));
      temp.put("Miami Dolphins", new Team("Dolphins"));
      temp.put("Kansas City Chiefs", new Team("Chiefs"));

      return temp;
    }

    //some CVs have abbreviations instead of team names.
    public String converter(String t_Name){
      switch(t_Name){
      case "CHI": return "Chicago Bears";
      case "CIN": return "Cincinnati Bengals";
      case "LAC": return "Los Angeles Chargers";
      case "ARI": return "Arizona Cardinals";
      case "NWE": return "New England Patriots";
      case "LAR": return "Los Angeles Rams";
      case "TAM": return "Tampa Bay Buccaneers";
      case "GNB": return "Green Bay Packers";
      case "SEA": return "Seattle Seahawks";
      case "ATL": return "Atlanta Falcons";
      case "DAL": return "Dallas Cowboys";
      case "CLE": return "Cleveland Browns";
      case "JAX": return "Jacksonville Jaguars";
      case "PHI": return "Philadelphia Eagles";
      case "HOU": return "Houston Texans";
      case "NYG": return "New York Giants";
      case "KAN": return "Kansas City Chiefs";
      case "DET": return "Detroit Lions";
      case "MIN": return "Minnesota Vikings";
      case "BUF": return "Buffalo Bills";
      case "OAK": return "Oakland Raiders";
      case "SFO": return "San Francisco 49ers";
      case "DEN": return "Denver Broncos";
      case "BAL": return "Baltimore Ravens";
      case "IND": return "Indianapolis Colts";
      case "CAR": return "Carolina Panthers";
      case "MIA": return "Miami Dolphins";
      case "NYJ": return "New York Jets";
      case "PIT": return "Pittsburgh Penguins";
      case "NOR": return "New Orleans Saints";
      case "TEN": return "Tennessee Titans";
      case "WAS": return "Washington Redskins";
      default: return "false";
}

    }
}
