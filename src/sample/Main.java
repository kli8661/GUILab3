package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage){
       try {
           this.primaryStage = primaryStage;
           primaryStage.setTitle("Simon Says");
           rootLayout = (AnchorPane) FXMLLoader.load(Main.class.getResource("../sample.fxml"));
           Scene scene = new Scene(rootLayout);
           primaryStage.setScene(scene);
           primaryStage.show();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
