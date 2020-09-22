package sample;


import javafx.scene.control.TextArea;

public class Run_Analysis{

    //Prints everything to the command line side by side for analysis.
    //pairs the right information: Team A offense compared to Team B defense and vice versa.
    TextArea lhs;
    TextArea rhs;

    Run_Analysis(Team A, Team B, TextArea L, TextArea R){

        lhs = L;
        rhs = R;

        overviewOFF(A,lhs);
        overviewDEF(B,rhs);

        addLine(lhs,"-------------------------------------------------");
        addLine(rhs,"-------------------------------------------------");

        overviewOFF(B,rhs);
        overviewDEF(A,lhs);

        addLine(lhs,"-------------------------------------------------");
        addLine(rhs,"-------------------------------------------------");

        runGameOFF(A, lhs);
        runGameDEF(B, rhs);

        addLine(lhs,"-------------------------------------------------");
        addLine(rhs,"-------------------------------------------------");

        runGameOFF(B, rhs);
        runGameDEF(A, lhs);

        addLine(lhs,"-------------------------------------------------");
        addLine(rhs,"-------------------------------------------------");

        passQBs(A, lhs);
        passDefense(B,rhs);

        addLine(lhs,"-------------------------------------------------");
        addLine(rhs,"-------------------------------------------------");

        passQBs(B, rhs);
        passDefense(A,lhs);


    }

    void addLine(TextArea t, String print){
        t.appendText("\n" + print);

    }


    public void overviewOFF(Team A, TextArea t){
        addLine(t, A.name + " Offense Overview: ");
        addLine(t,"     AVG yards per play: "           + A.off.yardsPerPlay);
        addLine(t, "     Total turnovers:    "          + A.off.turnOvers);
        addLine(t,"     Total Fumbles Lost: "           + A.off.fumbleslost);
        addLine(t,"     Total First Downs:  "           + A.off.fstDtotal);
        addLine(t,"     Penalities Taken: "             + A.off.penalties);
        addLine(t,"     Firsts by Penalty:  "           + A.off.fstbyPenalty);
        addLine(t,"     Avg Drives ending in a score: " + A.off.percentofscorebyoffense);
        addLine(t,"     Drives ending in a Turnover:  " + A.off.percentageofdrivesendingturnover);
    }

    public void overviewDEF(Team B, TextArea t){
        addLine(t, B.name + " Defense Overview:     ");
        addLine(t,"     AVG yards given up per play: "  + B.def.yrdsPerPlay);
        addLine(t, "     Total TakeAways:    "          + B.off.yardsPerPlay);
        addLine(t,"     Total Forced Fumbled: "         + B.def.fumbles);
        addLine(t,"     First Downs Given Up: "         + B.def.fst_Total);
        addLine(t,"     Penalities Forced: "            + B.def.pen);
        addLine(t,"     Firsts given up by penalty:  "  + B.def.fstByPen);
        addLine(t,"     AVG drives ending in a TD: "    + B.def.tdDrives_percentage);
        addLine(t,"     Drives ending in a Takeaway:  " + B.def.turnOverDrives_percentage );
    }

    public void runGameOFF(Team A, TextArea area){

        addLine(area,A.name + " Run Offense ");
        addLine(area, "     Rushing TDS Scored: "   + A.off.rush.TD);
        addLine(area, "     Rush Yrds Per Att: "    + A.off.rush.yrdsPer_A);
        addLine(area,"     Rush Yrds Per Gme:  "    + A.off.rush.yrdsPer_G);
        addLine(area,"     Rushing Fst: "           + A.off.fstdwnbyrun);
        addLine(area,"     Rush Yrds Total: "       + A.off.rush.yrds);
    }

    public void runGameDEF(Team B, TextArea area){


        addLine(area,B.name + " Run Defense ");
        addLine(area, "     Rushing TDs given up: "         + B.def.rush.td);
        addLine(area, "     Rush Yrds given up per Att: "   + B.def.rush.yrdsPer_A);
        addLine(area,"     Rush Yrds given up per Gme: "    + B.def.rush.yrdsPer_G);
        addLine(area,"     Rush Fst given up: "             + B.def.rush.fst_run);

    }

    public void passQBs(Team A, TextArea t){


        for(Team.Offense.Passing p : A.off.passers){


            addLine(t, "Name: "                             + p.Name);
            addLine(t, "     Comp Percantage: "             + p.comp_Percentage);
            addLine(t, "     Passing Yards: "               + p.yards);
            addLine(t, "     Passing yrds per Attempt "     + p.yardsPerAttempt);
            addLine(t, "     Passing yrds per Complete "    + p.yardsPerCompletion);
            addLine(t,"     Passing TDS: "                  + p.td);
            addLine(t, "     Passing td-percentage: "       + p.td_Percentage);
            addLine(t,"     Passing INT: "                  + p.INT );
            addLine(t, "     Int percentage:  "             + p.intPercentage);

            addLine(t,"     QBR: " + p.qbr + " sacks " + p.sacks + " longest Pass " + p.Lng );
            addLine(t,"     ComeBacks: " + p.comeBacks + " GWD " + p.GWD);
        }



    }

    public void passDefense(Team A, TextArea t){
        addLine(t, "Pass Defense");
        addLine(t, "     Attempts faced: "          + A.def.pass.Att);
        addLine(t,"     CMP_Percentage:       "     + A.def.pass.Cmp_Percentage);
        addLine(t,"     Yards faced:        "       + A.def.pass.Yds);
        addLine(t, "     Pass.TD given up: "        + A.def.pass.TD);
        addLine(t, "     Pass-TD percentage:   "    + A.def.pass.TD_percentage);
        addLine(t, "     INTS caught:        "      + A.def.pass.Int);
        addLine(t,"     INTS percentage:  "         + A.def.pass.Int_percentage );
        addLine(t,"     Yards Per ATT.: "           + A.def.pass.yrdsPer_A);
        addLine(t, "     Yards Per CMP.: "          + A.def.pass.yrdsPer_C);
        addLine(t,"     Yards Per GMS.: "           + A.def.pass.yrdsPer_G);
        addLine(t,"     QB rating.:     "           + A.def.pass.qbRating);
        addLine(t,"     QB HITS.:       "           + A.def.pass.QBHits );
        addLine(t,"     QB Sacks.:      "           + A.def.pass.Sk );
        addLine(t, "     TKL for Loss.:  "          + A.def.pass.TFL);
        addLine(t,"     Yards Gained Per ATT.: "    + A.def.pass.yardsGainedPerAttempt);
        addLine(t,"     Sack Percentage:   "        + A.def.pass.sackPercentage);
        addLine(t, "     Sack Percentage:   "       + A.def.pass.sackPercentage);
    }

}
