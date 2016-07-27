package empowered;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Screen extends Application
{
    public static int width_min = 1200; // retrieve data from a configure class?
    public static int height_min = 3*width_min/4;
    public static double sliderScale = 1.5;
    
    private Game game;

    public static Stage stage;
    public static Stage info;
    
    public static Scene startScene;
    public static Scene gameScene;
    public static Scene optionsScene;
    public static Scene classScene;
    
    private static VBox startButtons;
    private static VBox statusButtons;
    private static HBox choiceButtons;
    
    private static Text startTitle;

    static void start(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)// throws Exception 
    {
        makeAllElements();
        stage = primaryStage;
        
        startTitle = new Text("Empowered");
        BorderPane startLayout = new BorderPane(
                getStartButtons(),getStartTitle(),null,null,null);
        BorderPane.setAlignment(startTitle, Pos.CENTER);
        
        startScene = new Scene(startLayout,width_min,height_min);
        startScene.getStylesheets().addAll(this.getClass().getResource(
                "/empowered/resources/graphics/StartMenu.css").toExternalForm());
        startTitle.setId("TitleMainMenu");
        
        stage.setScene(startScene);
        stage.show();
   
    }
    
    public void makeStartButtons()
    {
        // make buttons and the container
        Button newGame = new Button("New game");
        Button loadGame = new Button("Load game");
        Button infoGame = new Button("Info");
        Button optionsGame = new Button("Options");
        Button exitGame = new Button("Exit game");
        startButtons = new VBox(
                20,newGame,loadGame,infoGame,optionsGame,exitGame);   
        startButtons.setAlignment(Pos.CENTER);
        
        // button events
        newGame.setOnAction(e -> {}); // goto ingame screen and make a class
        loadGame.setOnAction(e -> {}); // save/load system, unknown for now
        infoGame.setOnAction(e -> info.show()); // requires formatting
        optionsGame.setOnAction(e -> {}); //config class(static)
        exitGame.setOnAction(e -> Empowered.close(getStage()));        
    }
    
    public void makeStatusButtons()
    {
        // make buttons and the container
        Button skills = new Button("placeH");
        Button stats = new Button("placeH");
        Button items = new Button("placeH");
        Button something = new Button("placeH");
        
        statusButtons = new VBox(20,skills,stats,items,something);
        statusButtons.setAlignment(Pos.CENTER);
        
        //button events
        skills.setOnAction(e -> {});
        stats.setOnAction(e -> {});
        items.setOnAction(e -> {});
        something.setOnAction(e -> {});
        
    }

    public void makeChoiceButtons()
    {
        //make buttons and the container
        Button explore = new Button("Explore");
        Button visit = new Button("Visit");
        Button hunt = new Button("Hunt");
        Button items = new Button("Items");
        Button rest = new Button("Rest");
        choiceButtons = new HBox(10,explore,visit,hunt,items,rest);
        
        //button events
        explore.setOnAction(e -> {});
        visit.setOnAction(e -> {});
        hunt.setOnAction(e -> {});
        items.setOnAction(e -> {});
        rest.setOnAction(e -> {});
    }
    
    public void makeInfoScreen()
    {
        info = new Stage();
        Text infoText = new Text("hello");
        Button infoClose = new Button("Close");
        BorderPane infoLayout = new BorderPane();
        Scene infoScene = new Scene(infoLayout);
        info.setScene(infoScene);
        infoLayout.setCenter(infoText);
        infoLayout.setBottom(infoClose);
        BorderPane.setAlignment(infoClose, Pos.CENTER);
        BorderPane.setAlignment(infoText, Pos.CENTER);
        infoClose.setOnAction(e -> Empowered.close(info));
    }

    
    
    
    
    public static int getWidth_min(){return width_min;}
    public static int getHeight_min(){return height_min;}
    public static double getSliderScale(){return sliderScale;}
    public static Stage getStage(){return stage;}
    public static Stage getInfoScreen(){return info;}
    public static Text getStartTitle(){return startTitle;}
    public static VBox getStartButtons(){return startButtons;}
    public static VBox getStatusButtons(){return statusButtons;}
    public static HBox getChoiceButtons(){return choiceButtons;}
    

    private void makeAllElements() 
    {
        makeStartButtons();
        makeStatusButtons();
        makeChoiceButtons();
        makeInfoScreen();
    }
}
