package empowered;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Empowered
{
    
    public static void main(String[] args)
    {
        Screen.start(args);   
    }

    
    public static void close(Stage stage)
    {
        stage.close();
    }
    
    public static Parent format(Parent node)
    {
        return new HBox();
    }
    
    
}
