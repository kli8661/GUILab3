package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private GameCode simonsays = new GameCode();
    private ArrayList<String> sequence = simonsays.getSequence();

    @FXML
    private Rectangle greenBtn;

    @FXML
    private Rectangle redBtn;

    @FXML
    private Rectangle yellowbtn;

    @FXML
    private Rectangle blueBtn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
