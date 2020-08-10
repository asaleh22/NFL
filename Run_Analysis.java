

class Run_Analysis{

  //Prints everything to the command line side by side for analysis.
  //pairs the right information: Team A offense compared to Team B defense and vice versa. 

  Run_Analysis(Team A, Team B){

    overview(A,B);
    overview(B,A);

    runGame(A,B);
    runGame(B,A);

    passQBs(A);
    passQBs(B);

    passDefense(A,B);
  }

  public void overview(Team A, Team B){

    //Total Offense vs Total Defense.
    System.out.println("         " + A.name + " vs " + B.name + "\n");
    System.out.println("       " + A.name + " Offense " +  " vs " + B.name + " Defense");
    System.out.println("--------------------------------------------");
    System.out.print("|AVG yards per play: " + A.off.yardsPerPlay);
    System.out.print("    ||  AVG yards given up per play: " + B.def.yrdsPerPlay + "|\n");

    System.out.print("|Total turnovers:    " + A.off.turnOvers);
    System.out.print("    ||  Total TakeAways:             " + B.def.TakeAways + "|\n");

    System.out.print("|Total Fumbles Lost: " + A.off.fumbleslost);
    System.out.print("    ||  Total Forced Fumbled:        " + B.def.fumbles + "|\n");

    System.out.print("|Total First Downs:  " + A.off.fstDtotal);
    System.out.print("    ||  First Downs Given Up:        " + B.def.fst_Total + "|\n");

    System.out.print("|Penalities Taken:   " + A.off.penalties);
    System.out.print("    ||  Penalities Forced:           " + B.def.pen + "|\n");

    System.out.print("|Firsts by Penalty:  " + A.off.fstbyPenalty);
    System.out.print("    ||  Firsts given up by penalty:  " + B.def.fstByPen + "|\n");

    System.out.print("|Avg Drives n score: " + A.off.percentofscorebyoffense);
    System.out.print("    ||  AVG drives n TD:             " + B.def.tdDrives_percentage + "|\n");

    System.out.print("|D. ending n Tover:  " + A.off.percentageofdrivesendingturnover);
    System.out.print("    ||  D. ending n Takeaway:        " + B.def.turnOverDrives_percentage + "|\n");

  System.out.println("|Total Pass Att:     " + A.off.passesAttempt + "    ||");
  System.out.println("|Total Pass Yrd:     " + A.off.passingYrds + "    ||");
  System.out.println("|Total Pass Tds:     " + A.off.passingTD + "    ||");
  System.out.println("|Total Pass Int:     " + A.off.passingINT + "    ||");
  System.out.println("|Total fst-pass:     " + A.off.fstDbypass + "    ||");
  System.out.println("|Total rush Att:     " + A.off.rushingattempt + "    ||");
  System.out.println("|Total rush Yrd:     " + A.off.rushingyrds + "    ||");
  System.out.println("|Total Pass Att:     " + A.off.passesAttempt + "    ||");
  System.out.println("|Total rush TDS:     " + A.off.td_rushing + "    ||");

    System.out.println("--------------------------------------------");

}

public void runGame(Team A, Team B){

      System.out.println("         " + A.name + " vs " + B.name + "\n");
      System.out.println("       " + A.name + " Run Offense " +  " vs " + B.name + " Run Defense ");
      System.out.println("--------------------------------------------");

      System.out.print("|Rushing TDs scored: " + A.off.rush.TD);
      System.out.print("    ||  Rushing TDs given up:        " + B.def.rush.td + "|\n");

      System.out.print("|Rush Yrds Per Att:  " + A.off.rush.yrdsPer_A);
      System.out.print("    ||  Rush Yrds given up per Att:  " + B.def.rush.yrdsPer_A + "|\n");

      System.out.print("|Rush Yrds Per Gme:  " + A.off.rush.yrdsPer_G);
      System.out.print("    ||  Rush Yrds given up per Gme:  " + B.def.rush.yrdsPer_G + "|\n");

      System.out.print("|Rushing Fst:        " + A.off.fstdwnbyrun);
      System.out.print("    ||  Rush Fst given up:           " + B.def.rush.fst_run + "|\n");

      System.out.println("|Rush Yrds Total:    " + A.off.rush.yrds + "    ||");

      System.out.println("--------------------------------------------");




  }



public void passQBs(Team A){


  System.out.println("--------------------------------------------");

for(Team.Offense.Passing p : A.off.passers){

  System.out.println("Name:   " + p.Name);
  System.out.print("|Comp Percentage: " + p.comp_Percentage + "  ");
  System.out.print("|Passing Yards: " + p.yards + "  ");

  System.out.print("|Passing yrds per Attempt " + p.yardsPerAttempt + "  ");
  System.out.print("|Passing yrds per Complete " + p.yardsPerCompletion + "|\n");

  System.out.print("|Passing TDS: " + p.td + "  ");
  System.out.print("|Passing td-percentage: " + p.td_Percentage + "|\n");
  System.out.print("|Passing INT: " + p.INT + "  ");
  System.out.print("|Int percentage:  " + p.intPercentage + " |\n");

  System.out.print("|QBR: " + p.qbr + " sacks " + p.sacks + " longest Pass " + p.Lng + "|\n");

  System.out.print("|comeBacks: " + p.comeBacks + " GWD " + p.GWD + "|\n");

}

System.out.println("--------------------------------------------");


  }

public void passDefense(Team A, Team B){

  String sackPercentage;
  String fst_pass;


  System.out.println("         " + A.name + " vs " + B.name + "\n");
  System.out.println("       " + A.name + " Pass Defense " +  " vs " + B.name + " Pass Defense ");
  System.out.println("--------------------------------------------");

      System.out.print("|Attempts faced:         " + A.def.pass.Att);
      System.out.print("    ||  vs. :          " + B.def.pass.Att + "|\n");

      System.out.print("|CMP_Percentage:       " + A.def.pass.Cmp_Percentage);
      System.out.print("    ||  vs. :        " + B.def.pass.Cmp_Percentage + "|\n");


      System.out.print("|Yards faced:        " + A.def.pass.Yds);
      System.out.print("    ||  vs. :        " + B.def.pass.Yds + "|\n");


      System.out.print("|Pass.TD given up: " + A.def.pass.TD);
      System.out.print("    ||  vs. :        " + B.def.pass.TD + "|\n");


      System.out.print("|pass-TD percentage:   " + A.def.pass.TD_percentage);
      System.out.print("    ||  vs. :        " + B.def.pass.TD_percentage + "|\n");


      System.out.print("|INTS caught:        " + A.def.pass.Int);
      System.out.print("    ||  vs. :        " + B.def.pass.Int + "|\n");


      System.out.print("|INTS percentage:  " + A.def.pass.Int_percentage);
      System.out.print("    ||  vs. :        " + B.def.pass.Int_percentage + "|\n");


      System.out.print("|Yards Per ATT.: " + A.def.pass.yrdsPer_A);
      System.out.print("    ||  vs. :      " + B.def.pass.yrdsPer_A + "|\n");


      System.out.print("|Yards Per CMP.: " + A.def.pass.yrdsPer_C);
      System.out.print("    ||  vs. :      " + B.def.pass.yrdsPer_C + "|\n");

      System.out.print("|Yards Per GMS.: " + A.def.pass.yrdsPer_G);
      System.out.print("    ||  vs. :      " + B.def.pass.yrdsPer_G + "|\n");

      System.out.print("|QB rating.:     " + A.def.pass.qbRating);
      System.out.print("    ||  vs. :      " + B.def.pass.qbRating + "|\n");

      System.out.print("|QB HITS.:       " + A.def.pass.QBHits);
      System.out.print("    ||  vs. :      " + B.def.pass.QBHits + "|\n");

      System.out.print("|QB Sacks.:      " + A.def.pass.Sk);
      System.out.print("    ||  vs. :      " + B.def.pass.Sk + "|\n");


      System.out.print("|TKL for Loss.:  " + A.def.pass.TFL);
      System.out.print("    ||  vs. :      " + B.def.pass.TFL + "|\n");

      System.out.print("|Yards Gained Per ATT.: " + A.def.pass.yardsGainedPerAttempt);
      System.out.print("    ||  vs. :      " + B.def.pass.yardsGainedPerAttempt + "|\n");

      System.out.print("|Sack Percentage.:   " + A.def.pass.sackPercentage);
      System.out.print("    ||  vs. :      " + B.def.pass.sackPercentage + "|\n");

      System.out.print("|FST gained by pass.: " + A.def.pass.fst_pass);
      System.out.print("    ||  vs. :      " + B.def.pass.fst_pass + "|\n");


  System.out.println("--------------------------------------------");
}

}
