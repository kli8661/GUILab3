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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller implements Initializable {

    public Label roundNum;

    private int roundNumber = 1;

    private GameCode simonsays = new GameCode();

    private ArrayList<String> sequence = simonsays.getSequence();

    @FXML
    private Button startBtn;

    @FXML
    private Button greenBtn;

    @FXML
    private Button redBtn;

    @FXML
    private Button yellowBtn;

    @FXML
    private Button blueBtn;


    @FXML
    private void buttonAction(ActionEvent e)
    {
        if(e.getSource() == startBtn)
        {
            simonsays.startGame();
            roundNumber = 1;
            roundNum.setText("Round: " + roundNumber);
            displaySequence(simonsays.getSequence());
        }
        redBtn.setStyle("-fx-background-color: #f74840");
        greenBtn.setStyle("-fx-background-color: #61f44e");
        blueBtn.setStyle("-fx-background-color: #8293ed");
        yellowBtn.setStyle("-fx-background-color: #f1fa33");
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
                roundNumber++;
                roundNum.setText("Round: " + roundNumber);
            }
        }
        else
        {
            Alert start = new Alert(AlertType.INFORMATION);
            start.setTitle("BeginGameWindow.");
            start.setHeaderText(":D");
            start.setContentText("Start by clicking the start button!");
            start.show();
        }
    }

    private void gameOver()
    {
        Alert gameover = new Alert(AlertType.ERROR);
        gameover.setTitle("GameEndWindow");
        gameover.setHeaderText("Game Over!");
        gameover.setContentText("You scored: " + roundNumber + " rounds.");
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
                    FadeTransition redTransition = new FadeTransition(Duration.millis(300), redBtn);
                    redTransition.setAutoReverse(true);
                    redTransition.setFromValue(1.0);
                    redTransition.setToValue(0.1);
                    redTransition.setCycleCount(2);
                    s.getChildren().add(redTransition);
                    break;

                case "g":
                    FadeTransition greenTransition = new FadeTransition(Duration.millis(300), greenBtn);
                    greenTransition.setAutoReverse(true);
                    greenTransition.setFromValue(1.0);
                    greenTransition.setToValue(0.1);
                    greenTransition.setCycleCount(2);
                    s.getChildren().add(greenTransition);
                    break;

                case "b":
                    FadeTransition blueTransition = new FadeTransition(Duration.millis(300), blueBtn);
                    blueTransition.setAutoReverse(true);
                    blueTransition.setFromValue(1.0);
                    blueTransition.setToValue(0.1);
                    blueTransition.setCycleCount(2);
                    s.getChildren().add(blueTransition);
                    break;

                case "y":
                    FadeTransition yellowTransition = new FadeTransition(Duration.millis(300), yellowBtn);
                    yellowTransition.setAutoReverse(true);
                    yellowTransition.setFromValue(1.0);
                    yellowTransition.setToValue(0.1);
                    yellowTransition.setCycleCount(2);
                    s.getChildren().add(yellowTransition);
            }
        }
        s.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
