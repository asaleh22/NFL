package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main extends Application {

    TextField[] racers;
    GridPane grid;
    HashMap<Integer, Racer> H_racers;
    Builder builder;
    Text handler;
    Text texts[];
    TextField err = new TextField();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Enter racers by group");
        grid = new GridPane();
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setVgap(20);
        grid.setHgap(20);

        racers = new TextField[30];
        texts = new Text[6];
        setRacers(0,0,false);    //define racer textfields.

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 5, 6);
        grid.getChildren().add(submit);


        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e){
                HandleSubmit();
            }
        });

        handler = new Text("Enter racers by jersey number per group");
        handler.setStyle("-fx-border-color: coral;");
        GridPane.setConstraints(handler,3,6);
        grid.getChildren().add(handler);

        H_racers = new HashMap<>();
        builder = new Builder(H_racers);

        setText(0);
        setLegend();
        myThread m = new myThread(); //Gate keeping mechanism, forcing user to input fiv
        m.start();

        grid.setStyle("-fx-background-image: url(" + "/sample/flag.jpg" + "); -fx-background-repeat: stretch;" +
                "  -fx-background-size: cover");


        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


    public void HandleSubmit(){
        err.setStyle(null); //if textfield had an error in prev click, reset it for this next click

        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0; //in case of an error, which textfield is throwing the error
        try {
            for (; i < racers.length; ++i) {
                if(!racers[i].getText().equals(""))
                    arr.add(Integer.valueOf(racers[i].getText()));
            }
        }
        catch(NumberFormatException e){
            err = racers[i];
            err.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
            handler.setText("Racer's number required.");
        }
            if(arr.size() % 5 != 0){
                handler.setText("Must process at least one group of five");
            }
            else{ //success
                //access the right text and send it and the group of people(5)
                int size = arr.size();
                while(size >= 5) {
                    ArrayList<Integer> tmp = new ArrayList<>(arr.subList(size - 5, size));
                    int currIndex = (size/5) - 1;
                    size -= 5;
                    Analysis analysis = new Analysis(tmp, H_racers, texts[currIndex]);
                    analysis.ShowStats();
                    /*
                        Store the Texts in an array. Calculate which to use based on the index
                        available in this ArrayList arr

                     */

                }
            }
    }


    public void setRacers(int col, int index, boolean isDisabled){

        if(col == 6)
            return;

        TextField Racer1 = new TextField();
        Racer1.setPromptText("Racer One");
        Racer1.setPrefColumnCount(10);
        GridPane.setConstraints(Racer1, col, 0);
        grid.getChildren().add(Racer1);
        Racer1.setDisable(isDisabled);
        Racer1.setStyle("-fx-background-color: grey; -fx-text-fill: blue;");


        TextField Racer2 = new TextField();
        Racer2.setPromptText("Racer Two.");
        Racer2.setPrefColumnCount(10);
        GridPane.setConstraints(Racer2, col, 1);
        grid.getChildren().add(Racer2);
        Racer2.setDisable(isDisabled);
        Racer2.setStyle("-fx-background-color: grey; -fx-text-fill: blue;");

        TextField Racer3 = new TextField();
        Racer3.setPromptText("Racer Three.");
        Racer3.setPrefColumnCount(10);
        GridPane.setConstraints(Racer3, col, 2);
        grid.getChildren().add(Racer3);
        Racer3.setDisable(isDisabled);
        Racer3.setStyle("-fx-background-color: grey; -fx-text-fill: blue;");

        TextField Racer4 = new TextField();
        Racer4.setPromptText("Racer Four.");
        Racer4.setPrefColumnCount(10);
        GridPane.setConstraints(Racer4, col, 3);
        grid.getChildren().add(Racer4);
        Racer4.setDisable(isDisabled);
        Racer4.setStyle("-fx-background-color: grey; -fx-text-fill: blue;");

        TextField Racer5 = new TextField();
        Racer5.setPromptText("Racer Five.");
        Racer5.setPrefColumnCount(10);
        GridPane.setConstraints(Racer5, col, 4);
        grid.getChildren().add(Racer5);
        Racer5.setDisable(isDisabled);
        Racer5.setStyle("-fx-background-color: grey; -fx-text-fill: blue;");

        racers[index++] = Racer1;
        racers[index++] = Racer2;
        racers[index++] = Racer3;
        racers[index++] = Racer4;
        racers[index++] = Racer5;

        setRacers(++col, index, true);
    }


    public void setText(int i){

        if(i == 6)
            return;

        Text t = new Text();

        t.setText("Group " + (i+1) + ": ");

        texts[i] = t;
        t.setStyle("-fx-border-color: red;");
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(t);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefWidth(400);
        scrollPane.setPrefHeight(180);

        GridPane.setConstraints(scrollPane,i,9);
        grid.getChildren().add(scrollPane);
        setText(++i);
    }

    public void setLegend(){

        String textString = "";
        int col = 0;
        int i = 0;
        for (Map.Entry<Integer, Racer> pair: H_racers.entrySet()) {
            String num = pair.getValue().num;
            String pos[] = pair.getValue().pos.split(" ");
            textString += pos[1] + ": " + num + "\n";
            ++i;

            if(i == 6){
                Text text = new Text(textString);
                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(text);
                scrollPane.setFitToWidth(true);
                scrollPane.setPrefWidth(400);
                scrollPane.setPrefHeight(180);

                GridPane.setConstraints(scrollPane,col,10);
                grid.getChildren().add(scrollPane);

                ++col;
                i = 0;
                textString = "";
            }
            if(col == 6)
                    return;
        }

    }

    //INNER CLASS THREAD

    class myThread extends Thread{
        TextField group1[],group2[],group3[],group4[],group5[],group6[];
        myThread(){
            group1 = new TextField[5];
            group2 = new TextField[5];
            group3 = new TextField[5];
            group4 = new TextField[5];
            group5 = new TextField[5];
            group6 = new TextField[5];
            System.arraycopy(racers, 0, group1, 0, 5);
            System.arraycopy(racers, 5, group2, 0, 5);
            System.arraycopy(racers, 10, group3, 0, 5);
            System.arraycopy(racers, 15, group4, 0, 5);
            System.arraycopy(racers, 20, group5, 0, 5);
            System.arraycopy(racers, 25, group6, 0, 5);
        }

        boolean groupFull(TextField group[]){

            for(TextField v : group){
                if(v.getText().equals("")) {
                    return false;
                }
            }
            return true;
        }

        void setActive(TextField group[], boolean setActive){
            boolean setDisable = setActive == true ? false : true;
            for(TextField v : group)
                v.setDisable(setDisable);
        }


        @Override
        public void run() {
            while(true){
                setActive(group2, groupFull(group1));
                setActive(group3,groupFull(group2) && !group2[0].isDisable());
                setActive(group4,groupFull(group3) && !group3[0].isDisable());
                setActive(group5,groupFull(group4) && !group4[0].isDisable());
                setActive(group6,groupFull(group5) && !group5[0].isDisable());
            }
        }
    }

}
