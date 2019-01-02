package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller implements Initializable {
    private GameCode simonsays = new GameCode();
    private ArrayList<String> sequence = simonsays.getSequence();
    @FXML
    private Button startBtn;

    @FXML
    private Rectangle greenBtn;

    @FXML
    private Rectangle redBtn;

    @FXML
    private Rectangle yellowBtn;

    @FXML
    private Rectangle blueBtn;

    @FXML
    private void buttonAction(ActionEvent e)
    {
        if(e.getSource() == startBtn)
        {
            simonsays.startGame();
            displaySequence(simonsays.getSequence());
        }
    }

    @FXML
    private void userClick(MouseEvent e)
    {
        if(simonsays.isGameRunning())
        {
            if(e.getSource() == redBtn)
                if(!simonsays.checkUserInput("r"))
                    gameOver();

            if(e.getSource() == greenBtn)
                if(!simonsays.checkUserInput("g"))
                    gameOver();

            if(e.getSource() == blueBtn)
                if(!simonsays.checkUserInput("b"))
                    gameOver();

            if(e.getSource() == yellowBtn)
                if(!simonsays.checkUserInput("y"))
                    gameOver();

            if(simonsays.getIndex() == 0)
            {
                displaySequence(simonsays.getSequence());
            }
        }
        else
        {
            Alert start = new Alert(AlertType.INFORMATION);
            start.setTitle("Click start to begin.");
            start.show();
        }
    }

    private void gameOver()
    {
        Alert gameover = new Alert(AlertType.ERROR);
        gameover.setTitle("Game over!");
        gameover.setHeaderText("Game over!");
        gameover.show();
    }

    public void displaySequence(ArrayList<String> sequence)
    {
        SequentialTransition s = new SequentialTransition();
        s.setCycleCount(1);
        s.setAutoReverse(false);
        for(int i = 0; i < sequence.size(); i++)
        {
            switch(sequence.get(i))
            {
                case "r":
                    FadeTransition redft = new FadeTransition(Duration.millis(300), redBtn);
                    redft.setAutoReverse(true);
                    redft.setFromValue(1.0);
                    redft.setToValue(0.1);
                    redft.setCycleCount(2);
                    s.getChildren().add(redft);
                    break;

                case "g":
                    FadeTransition greenft = new FadeTransition(Duration.millis(300), greenBtn);
                    greenft.setAutoReverse(true);
                    greenft.setFromValue(1.0);
                    greenft.setToValue(0.1);
                    greenft.setCycleCount(2);
                    s.getChildren().add(greenft);
                    break;

                case "b":
                    FadeTransition blueft = new FadeTransition(Duration.millis(300), blueBtn);
                    blueft.setAutoReverse(true);
                    blueft.setFromValue(1.0);
                    blueft.setToValue(0.1);
                    blueft.setCycleCount(2);
                    s.getChildren().add(blueft);
                    break;

                case "y":
                    FadeTransition yellowft = new FadeTransition(Duration.millis(300), yellowBtn);
                    yellowft.setAutoReverse(true);
                    yellowft.setFromValue(1.0);
                    yellowft.setToValue(0.1);
                    yellowft.setCycleCount(2);
                    s.getChildren().add(yellowft);
            }
        }
        s.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
