package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
<<<<<<< HEAD
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    TextField[] racers;
    GridPane grid;
    HashMap<Integer, String> H_Racers;
    Builder builder;
    Text handler;
    Text texts[];
    TextField err = new TextField();
    Analysis analysis = new Analysis();
    static int errorNumber;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Enter racers by group");
        grid = new GridPane();
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setVgap(15);
        grid.setHgap(20);

        racers = new TextField[30];
        texts = new Text[6];
        setRacers(0,0,false);    //define racer textfields.

        Button submit = new Button("Submit");
        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e){
                HandleSubmit();
            }
        });

        handler = new Text("Enter racer number in groups of five. Legend below.");
        handler.getStyleClass().add("custom");
        VBox vb = new VBox();
        vb.setPrefSize(180,100);
        vb.setMaxSize(100,100);
        vb.setMinSize(180,100);
        handler.setTextAlignment(TextAlignment.CENTER);
        handler.setWrappingWidth(180);
        vb.getChildren().add(handler);
        vb.setStyle("-fx-background-color:black");
        vb.setAlignment(Pos.CENTER);

        GridPane.setConstraints(vb,3,6);
        grid.getChildren().add(vb);

        H_Racers = new HashMap<>();
        builder = new Builder(H_Racers);

        setText(0);
        setLegend();

        myThread m = new myThread(); //Gate keeping mechanism, forcing user to input fiv
        m.start();
        String url = getClass().getResource("/resources/images/flag.jpg").toString();
        grid.setStyle("-fx-background-image: url(" + url + "); -fx-background-repeat: stretch; -fx-background-size: cover;");

        Button exit = new Button();
        GridPane.setConstraints(exit,6,5);
        HBox tmp = new HBox();
        tmp.getChildren().addAll(submit,exit);
        GridPane.setConstraints(tmp, 5, 6);
        tmp.setSpacing(50);
        grid.getChildren().add(tmp);
        url = getClass().getResource("/resources/images/exit.png").toString();
        exit.setGraphic(new ImageView(new Image(url,25 ,25, true, true)));

        exit.prefHeight(20);
        exit.prefWidth(20);
        exit.setMaxHeight(20);
        exit.setMaxWidth(20);
        exit.setMinHeight(20);
        exit.setMinWidth(20);
        exit.setOnMouseEntered(e-> {exit.setStyle(
                          "-fx-background-color:red;" +
                          "-fx-scale-x: 1.5;" +
                          "-fx-scale-y: 1.5;" +
                          "-fx-scale-z: 1.5;");
        });
        exit.setOnMouseExited(e ->  exit.setStyle(null));
        exit.setOnMouseClicked(e->  System.exit(0));

        Scene scene = new Scene(grid, 300, 275);
        scene.getStylesheets().add(getClass().getResource("/resources/stylesheets/styles.css").toExternalForm());
        primaryStage.setScene(scene);
=======
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;


public class Main extends Application {
    private Stage primaryStage;
    private Scene chooseScreen, showAnalysis;
    private ImageView lHalf;
    private ImageView rHalf;
    private int LIndex = 0;
    private int RIndex = 0;
    private Image imgs[];
    private TextArea LeftStats, RightStats;
    private NFL_Eval Evaluator;
    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        VBox root = new VBox();
        String url = getClass().getResource("/resources/icons/rootBackground.png").toString();
        root.setStyle("-fx-background-image: url(" + url + "); -fx-background-repeat: stretch;" +
                      "-fx-background-size: cover");

        HBox TopRow = new HBox(); //top row
        HBox lCol = new HBox();
        HBox rCol = new HBox();

        HBox MatchUp = new HBox(); //middle row where images are placed

        HBox BottomRow = new HBox(); //bottom row
        HBox lCol_bot = new HBox();
        HBox rCol_bot = new HBox();

        root.setSpacing(20);
        root.getChildren().addAll(TopRow, MatchUp, BottomRow);
        root.setAlignment(Pos.CENTER);

        lHalf = new ImageView();
        rHalf = new ImageView();
        lHalf.setFitWidth(600);
        lHalf.setFitHeight(445);
        rHalf.setFitWidth(600);
        rHalf.setFitHeight(445);

        imgs = new Image[32];
        try{fillImage();}
        catch(URISyntaxException e){System.out.println(e);} //fill the imgs array
        lHalf.setImage(imgs[0]);
        rHalf.setImage(imgs[0]);
        Button upLeft = new Button();
        Button upRight = new Button();
        Button downLeft = new Button();
        Button downRight = new Button();
        Button next = new Button();

        downLeft.setPrefSize(350,35);
        downRight.setPrefSize(350,35);
        upLeft.setPrefSize(350,35);
        upRight.setPrefSize(350,35);

        downLeft.setMinSize(350,35);
        downRight.setMinSize(350,35);
        upLeft.setMinSize(350,35);
        upRight.setMinSize(350,35);

        downLeft.setMaxSize(350,35);
        downRight.setMaxSize(350,35);
        upLeft.setMaxSize(350,35);
        upRight.setMaxSize(350,35);

        lCol.getChildren().add(upLeft);
        rCol.getChildren().add(upRight);

        Button exitButton = new Button();

        TopRow.setAlignment(Pos.TOP_CENTER);
        TopRow.setSpacing(40);
        TopRow.getChildren().addAll(lCol,rCol, exitButton);

        MatchUp.getChildren().addAll(lHalf,rHalf);
        MatchUp.setAlignment(Pos.CENTER);

        lCol_bot.getChildren().add(downLeft);
        rCol_bot.getChildren().add(downRight);
        rCol_bot.getChildren().add(next);
        next.setPrefSize(50,30);
        HBox.setMargin(next,new Insets(60,60,0,0));
        BottomRow.getChildren().addAll(lCol_bot,rCol_bot);
        BottomRow.setSpacing(30);
        BottomRow.setAlignment(Pos.BOTTOM_CENTER);


        HBox.setMargin(upLeft,new Insets(5,5,5,200));
        HBox.setMargin(upRight,new Insets(5,100,5,5));
        HBox.setMargin(downLeft,new Insets(5,5,5,200));
        HBox.setMargin(downRight,new Insets(5,100,5,5));

        upRight.setOnMouseClicked(e   ->{++RIndex; changeRightImage();});
        downRight.setOnMouseClicked(e ->{--RIndex; changeRightImage();});
        upLeft.setOnMouseClicked(e    ->{++LIndex; changeLeftImage();});
        downLeft.setOnMouseClicked(e  ->{--LIndex; changeLeftImage();});

        //Sets the Teams hashmap in the object for repeated use
        Evaluator = new NFL_Eval();
        try{
            Evaluator.setData();
        }catch(URISyntaxException e){ System.out.println(e);}


        next.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<>() {
            @Override public void handle(MouseEvent e){
                showAnalysis = new Scene(nextScene(lHalf.getImage().getUrl().toString(),rHalf.getImage().getUrl().toString()),600,600);
                showAnalysis.getStylesheets().add(getClass().getResource("/sample/stylesheets/myStyle.css").toExternalForm());
                Evaluator.start(LIndex, RIndex, LeftStats, RightStats);
                LeftStats.positionCaret(0);
                RightStats.positionCaret(0);
                primaryStage.setScene(showAnalysis);
                primaryStage.setFullScreen(true);
            }
        });
        setButtonStyles(downLeft,downRight,upLeft,upRight, next, exitButton);

        chooseScreen = new Scene(root,600,600); //creates the next scene

        primaryStage.setScene(chooseScreen);
>>>>>>> repo-NFL/master
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

<<<<<<< HEAD
    /*After user hits submit, process the input.*/
    public void HandleSubmit(){
        //if textfield had an error in prev click, reset it for this next click
        handler.setText("Enter racer number in groups of five. Legend below.");
        err.setStyle(null);

        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0; //in case of an error, which textfield is throwing the error
        try {
            /*ensures user is entering integer values*/
            for (; i < racers.length; ++i) {
                if(!racers[i].getText().equals(""))
                    arr.add(Integer.valueOf(racers[i].getText()));
            }
        }
        catch(NumberFormatException e){ //user entered a letter
            err = racers[i];
            err.setStyle("-fx-background-color: red");
            handler.setText("Racer's number required.");
        }
            if(arr.size() % 5 != 0){
                handler.setText("Must enter groups of five.");
            }
            else{ //success
                //access the right text and send it and the group of people(5)
                int size = arr.size();
                while(size >= 5){
                    ArrayList<Integer> tmp = new ArrayList<>(arr.subList(size - 5, size));
                    int currIndex = (size/5) - 1;
                    size -= 5;
                    analysis.setForAnalysis(tmp, H_Racers, texts[currIndex]);

                    // if user enters a non existing number the static int is changed above
                    boolean found = analysis.ShowStats();
                    if(!found){
                        handler.setText("Error: " + this.errorNumber + " does not match a player");
                        //find the textfield that contains the wrong number
                        for(int b = 0; b < racers.length; ++b){
                            if(racers[b].getText().equals(String.valueOf(this.errorNumber))){
                                err = racers[b];
                                err.setStyle("-fx-background-color: red");
                            }
                        }
                    }
                }
            }
    }
    /*Recursively creates 6 rows of 5 Textfields to enter jersey numbers
    The first two is enabled the rest disabled*/
    public void setRacers(int col, int index, boolean isDisabled){
        if(col == 6)
            return;

        TextField Racer1 = new TextField();
        Racer1.setPromptText("Racer One");
        Racer1.setPrefColumnCount(10);
        GridPane.setConstraints(Racer1, col, 0);
        grid.getChildren().add(Racer1);
        Racer1.setDisable(isDisabled);


        TextField Racer2 = new TextField();
        Racer2.setPromptText("Racer Two.");
        Racer2.setPrefColumnCount(10);
        GridPane.setConstraints(Racer2, col, 1);
        grid.getChildren().add(Racer2);
        Racer2.setDisable(isDisabled);

        TextField Racer3 = new TextField();
        Racer3.setPromptText("Racer Three.");
        Racer3.setPrefColumnCount(10);
        GridPane.setConstraints(Racer3, col, 2);
        grid.getChildren().add(Racer3);
        Racer3.setDisable(isDisabled);

        TextField Racer4 = new TextField();
        Racer4.setPromptText("Racer Four.");
        Racer4.setPrefColumnCount(10);
        GridPane.setConstraints(Racer4, col, 3);
        grid.getChildren().add(Racer4);
        Racer4.setDisable(isDisabled);

        TextField Racer5 = new TextField();
        Racer5.setPromptText("Racer Five.");
        Racer5.setPrefColumnCount(10);
        GridPane.setConstraints(Racer5, col, 4);
        grid.getChildren().add(Racer5);
        Racer5.setDisable(isDisabled);

        racers[index++] = Racer1;
        racers[index++] = Racer2;
        racers[index++] = Racer3;
        racers[index++] = Racer4;
        racers[index++] = Racer5;

        setRacers(++col, index, true);
    }


    /*Recursively creates 6 Text objects to store race information*/
    public void setText(int i){
        if(i == 6)
            return;
        Text t = new Text();
        t.setText("Group " + (i+1) + ": ");

        texts[i] = t;
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(t);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefWidth(180);
        scrollPane.setPrefHeight(140);
        scrollPane.setMaxWidth(180);
        scrollPane.setMaxHeight(140);
        scrollPane.setMinWidth(180);
        scrollPane.setMinHeight(140);
        GridPane.setConstraints(scrollPane,i,9);
        grid.getChildren().add(scrollPane);
        setText(++i);
    }

    //A legend linking jersey numbers with the correct racers
    public void setLegend(){
        String textString = "";
        int col = 0;
        int i = 0;
        //changed from H_racers.entryset
        for (Map.Entry<Integer, String> pair: H_Racers.entrySet()) {
            int num = pair.getKey();
            String pos[] = pair.getValue().split(" ");
            textString += pos[1] + ":" + num + "\n";
            ++i;
            if(i == 6){
                Text text = new Text(textString);
                text.setStyle("-fx-fill: red;");
                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(text);
                scrollPane.setFitToWidth(false);
                scrollPane.setPrefWidth(180);
                scrollPane.setPrefHeight(180);
                scrollPane.setMaxWidth(180);
                scrollPane.setMaxHeight(180);
                scrollPane.setMinWidth(180);
                scrollPane.setMinHeight(180);

                GridPane.setConstraints(scrollPane,col,10);
                grid.getChildren().add(scrollPane);

                ++col;
                i = 0;
                textString = "";
            }
            if(col == 6)
                return;
=======
    //Match Up screen
    HBox nextScene(String teamA, String teamB){
        HBox root = new HBox();
        VBox lHalf = new VBox();
        VBox rHalf = new VBox();

        lHalf.setFillWidth(true);
        lHalf.setMaxWidth(650);
        lHalf.setMinWidth(650);
        lHalf.setPrefWidth(650);

        rHalf.setFillWidth(true);
        rHalf.setPrefWidth(650);
        rHalf.setMaxWidth(650);
        rHalf.setMinWidth(650);

        LeftStats = new TextArea();
        RightStats = new TextArea();
        LeftStats.setEditable(false);
        RightStats.setEditable(false);

        LeftStats.setTextFormatter(createTextFormatter());
        RightStats.setTextFormatter(createTextFormatter());

        lHalf.getChildren().add(LeftStats);
        rHalf.getChildren().add(RightStats);

        lHalf.setStyle("-fx-background-image: url(" + teamA + "); -fx-background-repeat: stretch;" +
                       "-fx-background-size: cover");
        rHalf.setStyle("-fx-background-image: url(" + teamB + "); -fx-background-repeat: stretch;" +
                       "-fx-background-size: cover");

        LeftStats.setPrefSize(300,500);
        RightStats.setPrefSize(300,500);

        VBox.setMargin(LeftStats, new Insets(50));
        VBox.setMargin(RightStats,new Insets(50));

        Button returnButton = new Button();
        String url = getClass().getResource("/resources/icons/back.png").toString();
        returnButton.setGraphic(new ImageView(new Image(url,20,20,true,true)));

        returnButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e){
                primaryStage.setScene(chooseScreen);
                primaryStage.setFullScreen(true);
            }
        });
        returnButton.setAlignment(Pos.BOTTOM_LEFT);
        returnButton.setOnMouseEntered(e-> returnButton.setStyle("-fx-background-color: green;" +
                                                                 "-fx-border-color: blue;"));
        returnButton.setOnMouseExited(e-> returnButton.setStyle(null));
        VBox.setMargin(returnButton,new Insets(50));
        lHalf.getChildren().add(returnButton);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lHalf,rHalf);
        return root;
    }

    //reads the teams folder and stores all images in an images array
    private void fillImage() throws URISyntaxException{
        int i = 0;
        Path dir = Paths.get(getClass().getResource("/resources/teams").toURI());

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
            for (Path entry: stream) {
                imgs[i] = new Image(getClass().getResource("/resources/teams/" + entry.getFileName().toString()).toString());
                ++i;
            }
        }catch(NotDirectoryException e) {
            System.out.println("NotDirectory: " + e.getCause());
        }
        catch(IOException e) {
            System.out.println("IOException: " + e.getCause());
        }
        catch(SecurityException e) {
            System.out.println("SecurityException: " + e.getCause());
        }
        catch(DirectoryIteratorException e) {
            System.out.println("IteratorException: " + e.getCause());
>>>>>>> repo-NFL/master
        }

    }

<<<<<<< HEAD
    //INNER CLASS THREAD
    //Makes sure user can only enter one group of 5 before moving on.
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

       private boolean groupFull(TextField group[]){

            for(TextField v : group){
                if(v.getText().equals("")) {
                    return false;
                }
            }
            return true;
        }

       private void setActive(TextField group[], boolean setActive){
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
=======
    //Changes image in imageview and loops the array.
    private void changeLeftImage(){
        if(LIndex > 31)
            LIndex = 0;
        else if(LIndex < 0)
            LIndex = 31;
        lHalf.setImage(imgs[LIndex]);
    }

    //Changes image in imageview and loops the array.
    private void changeRightImage(){
        if(RIndex> 31)
            RIndex = 0;
        else if(RIndex < 0)
            RIndex = 31;
        rHalf.setImage(imgs[RIndex]);
    }

    private void setButtonStyles(Button bottomLeft,Button bottomRight,Button topLeft, Button topRight, Button next, Button exit){
        final String HOVERED_BUTTON_STYLE = "-fx-background-color: yellow; -fx-border-color: blue;";

        String url = getClass().getResource("/resources/icons/down.png").toString();
        Image down = new Image(url,40,40,true,true);

        bottomLeft.setGraphic(new ImageView(down));

        bottomLeft.setOnMouseEntered(e-> bottomLeft.setStyle(HOVERED_BUTTON_STYLE));
        bottomLeft.setOnMouseExited(e-> bottomLeft.setStyle(null));

        //button two
        bottomRight.setGraphic(new ImageView(down));

        bottomRight.setOnMouseEntered(e-> bottomRight.setStyle(HOVERED_BUTTON_STYLE));
        bottomRight.setOnMouseExited(e-> bottomRight.setStyle(null));
        //button three

        ImageView up = new ImageView();
        up.setImage(down);
        up.setRotate(up.getRotate() + 180);
        topLeft.setGraphic(up);

        topLeft.setOnMouseEntered(e-> topLeft.setStyle(HOVERED_BUTTON_STYLE));
        topLeft.setOnMouseExited(e-> topLeft.setStyle(null));
        //button four

        up = new ImageView();
        up.setImage(down);
        up.setRotate(up.getRotate() + 180);
        topRight.setGraphic(up);

        topRight.setOnMouseEntered(e-> topRight.setStyle(HOVERED_BUTTON_STYLE));
        topRight.setOnMouseExited(e-> topRight.setStyle(null));

        //button next
        url = getClass().getResource("/resources/icons/next.png").toString();
        next.setGraphic(new ImageView(new Image(url,20 ,20, true, true)));
        next.setOnMouseEntered(e-> next.setStyle("-fx-background-color: green;" +
                                                 "-fx-border-color: blue;"));
        next.setOnMouseExited(e-> next.setStyle(null));

        //button exit
        url = getClass().getResource("/resources/icons/exit.png").toString();
        exit.setGraphic(new ImageView(new Image(url,20 ,20, true, true)));
        exit.setOnMouseEntered(e-> exit.setStyle("-fx-background-color: red;" +
                                                 "-fx-border-color: blue;"));
        exit.setOnMouseExited(e-> exit.setStyle(null));
        exit.setOnMouseClicked(e-> System.exit(0));
    }

    private static <T> TextFormatter<T> createTextFormatter() {

        //if a new line contains too many characters, cut it down to a readable end
        return new TextFormatter<>(change -> {
            if (change.isAdded()) {
                if (change.getText().indexOf('\n') > -1) { //if /n is found
                    if(change.getText().length() > 40)
                        change.setText(change.getText().substring(0,36) + change.getText().substring(change.getText().length()-4, change.getText().length()));
                }
            }
            return change;
        });
>>>>>>> repo-NFL/master
    }

    public static void main(String[] args) {
        launch(args);
    }
<<<<<<< HEAD
=======


>>>>>>> repo-NFL/master
}
