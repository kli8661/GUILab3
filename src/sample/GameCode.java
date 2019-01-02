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

    public void setGameRunning(boolean gameRunning)
    {
        this.gameRunning = gameRunning;
    }

    public GameCode()
    {
        index = 0;
        sequence = new ArrayList<String>();
        setGameRunning(false);
    }

    public void startGame()
    {
        sequence.clear();
        generateSequence();
        setGameRunning(true);
        index = 0;
    }

    public void endGame()
    {
        index = 0;
        sequence.clear();
        setGameRunning(false);
    }

    public void generateSequence()
    {
        for(int i = 0; i < STARTTURN; i++)
        {
            sequence.add(randomColor());
        }
    }

    public boolean checkUserInput(String color)
    {
        if((sequence.get(index)).equals(color))
        {
            if(index == sequence.size() - 1)
            {
                addSequence();
                index = 0;
                return true;
            }
            index++;
            return true;
        }
        else
        {
            endGame();
            return false;
        }
    }

    public void addSequence()
    {
        sequence.add(randomColor());
    }

    private String randomColor()
    {
        return COLOR[(int)(Math.random()*4)];
    }

    public boolean isGameRunning()
    {
        return gameRunning;
    }
}
