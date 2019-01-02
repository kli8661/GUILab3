package sample;

import java.lang.Math;
import java.util.ArrayList;

public class GameCode {

    private int index;
    private final int STARTTURN = 3;
    private ArrayList<String> sequence;
    private final String[] COLOR = {"g", "r", "y", "b"};
    private boolean gameRunning;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<String> getSequence() {
        return sequence;
    }

    public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
