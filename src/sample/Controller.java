package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
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
            displaySequence(sequence);
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
            if(e.getSource() == redBtn) {
                if (simonsays.checkUserInput("r"))
                {
                    redBtn.setEffect(new Glow(0.8));
                }
                else
                    gameOver();
            }

            if(e.getSource() == greenBtn) {
                if (simonsays.checkUserInput("g"))
                {
                    greenBtn.setEffect(new Glow(0.8));
                }
                else
                    gameOver();
            }

            if(e.getSource() == blueBtn) {
                if (simonsays.checkUserInput("b"))
                {
                    blueBtn.setEffect(new Glow(0.8));
                }
                else
                    gameOver();
            }

            if(e.getSource() == yellowBtn) {
                if (simonsays.checkUserInput("y"))
                {
                    yellowBtn.setEffect(new Glow(0.8));
                }
                else
                    gameOver();
            }

            if(simonsays.getIndex() == 0) {
                displaySequence(sequence);
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
        Alert gameOver = new Alert(AlertType.ERROR);
        gameOver.setTitle("GameEndWindow");
        gameOver.setHeaderText("Game Over!");
        gameOver.setContentText("You scored: " + roundNumber + " rounds.");
        gameOver.show();
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
                    FadeTransition redTransition = new FadeTransition(Duration.millis(250), redBtn);
                    redTransition.setAutoReverse(true);
                    redTransition.setFromValue(1.0);
                    redTransition.setToValue(0.1);
                    redTransition.setCycleCount(2);
                    s.getChildren().add(redTransition);
                    break;

                case "g":
                    FadeTransition greenTransition = new FadeTransition(Duration.millis(250), greenBtn);
                    greenTransition.setAutoReverse(true);
                    greenTransition.setFromValue(1.0);
                    greenTransition.setToValue(0.1);
                    greenTransition.setCycleCount(2);
                    s.getChildren().add(greenTransition);
                    break;

                case "b":
                    FadeTransition blueTransition = new FadeTransition(Duration.millis(250), blueBtn);
                    blueTransition.setAutoReverse(true);
                    blueTransition.setFromValue(1.0);
                    blueTransition.setToValue(0.1);
                    blueTransition.setCycleCount(2);
                    s.getChildren().add(blueTransition);
                    break;

                case "y":
                    FadeTransition yellowTransition = new FadeTransition(Duration.millis(250), yellowBtn);
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
