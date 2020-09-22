package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.Iterator;

public class Main extends Application {
    Stage primaryStage;
    Scene chooseScreen, showAnalysis;
    ImageView lHalf;
    ImageView rHalf;
    int LIndex = 0;
    int RIndex = 0;
    Image imgs[];
    TextArea LeftStats, RightStats;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;

        VBox root = new VBox();
        String url = getClass().getResource("/resources/icons/rootBackground.png").toString();
        root.setStyle("-fx-background-image: url(" + url + "); -fx-background-repeat: stretch;" +
                "  -fx-background-size: cover");


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
        catch(URISyntaxException e){} //fill the imgs array
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


        TopRow.setAlignment(Pos.TOP_CENTER);
        TopRow.setSpacing(230);
        TopRow.getChildren().addAll(lCol,rCol);

        MatchUp.getChildren().addAll(lHalf,rHalf);
        MatchUp.setAlignment(Pos.CENTER);

        lCol_bot.getChildren().add(downLeft);
        rCol_bot.getChildren().add(downRight);
        rCol_bot.getChildren().add(next);
        next.setPrefSize(50,30);
        HBox.setMargin(next,new Insets(60,60,0,0));
        BottomRow.getChildren().addAll(lCol_bot,rCol_bot);
        BottomRow.setSpacing(230);
        BottomRow.setAlignment(Pos.BOTTOM_CENTER);


        HBox.setMargin(upLeft,new Insets(5,5,5,200));
        HBox.setMargin(upRight,new Insets(5,100,5,5));
        HBox.setMargin(downLeft,new Insets(5,5,5,200));
        HBox.setMargin(downRight,new Insets(5,100,5,5));



        upRight.setOnMouseClicked(e->{++RIndex; changeRightImage();});
        downRight.setOnMouseClicked(e->{--RIndex; changeRightImage();});
        upLeft.setOnMouseClicked(e->{++LIndex; changeLeftImage();});
        downLeft.setOnMouseClicked(e->{--LIndex; changeLeftImage();});


        next.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e){
                showAnalysis = new Scene(nextScene(lHalf.getImage().getUrl().toString(),rHalf.getImage().getUrl().toString()),600,600);
                showAnalysis.getStylesheets().add(getClass().getResource("/sample/stylesheets/myStyle.css").toExternalForm());
                NFL_Eval n = new NFL_Eval(LIndex, RIndex, LeftStats, RightStats);
                LeftStats.positionCaret(0);
                RightStats.positionCaret(0);
                primaryStage.setScene(showAnalysis);
                primaryStage.setFullScreen(true);
            }
        });


        setButtonStyles(downLeft,downRight,upLeft,upRight, next);

        chooseScreen = new Scene(root,600,600);

        primaryStage.setScene(chooseScreen);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    HBox nextScene(String teamA, String teamB){
        HBox root = new HBox();
        VBox lHalf = new VBox();
        VBox rHalf = new VBox();

        lHalf.setFillWidth(true);
        rHalf.setFillWidth(true);

        lHalf.setPrefWidth(650);
        rHalf.setPrefWidth(650);
        lHalf.setMaxWidth(650);
        rHalf.setMaxWidth(650);
        lHalf.setMinWidth(650);
        rHalf.setMinWidth(650);


        lHalf.setStyle("-fx-background-image: url(" + teamA + "); -fx-background-repeat: stretch;" +
                "  -fx-background-size: cover");
        rHalf.setStyle("-fx-background-image: url(" + teamB + "); -fx-background-repeat: stretch;" +
                "  -fx-background-size: cover");

        LeftStats = new TextArea();
        RightStats = new TextArea();
        LeftStats.setEditable(false);
        RightStats.setEditable(false);

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


        lHalf.getChildren().add(LeftStats);
        lHalf.getChildren().add(returnButton);
        returnButton.setAlignment(Pos.BOTTOM_LEFT);
        returnButton.setOnMouseEntered(e-> returnButton.setStyle("-fx-background-color: green;" +
                "-fx-border-color: blue;"));
        returnButton.setOnMouseExited(e-> returnButton.setStyle(null));
        VBox.setMargin(returnButton,new Insets(50));

        rHalf.getChildren().add(RightStats);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(lHalf,rHalf);

        return root;
    }


    void fillImage() throws URISyntaxException{
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
        }



    }

    void changeLeftImage(){

        if(LIndex> 31)
            LIndex = 0;
        else if(LIndex < 0)
            LIndex = 31;

        lHalf.setImage(imgs[LIndex]);
    }

    void changeRightImage(){
        if(RIndex> 31)
            RIndex = 0;
        else if(RIndex < 0)
            RIndex = 31;
        rHalf.setImage(imgs[RIndex]);
    }

    void setButtonStyles(Button bottomLeft,Button bottomRight,Button topLeft, Button topRight, Button next){
        //final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;";
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

    }

    public static void main(String[] args) {
        launch(args);
    }


}
