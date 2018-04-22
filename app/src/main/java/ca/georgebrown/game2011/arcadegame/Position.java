package ca.georgebrown.game2011.arcadegame;

/**
 * Created by singh on 2018-04-22.
 */

public class Position {

    private int leftPosition;
    private int topPosition;

    public Position(int left,int top){
        this.leftPosition = left;
        this.topPosition = top;
    }

    public int getLeftPosition() {
        return leftPosition;
    }

    public void setLeftPosition(int leftPosition) {
        this.leftPosition = leftPosition;
    }

    public int getTopPosition() {
        return topPosition;
    }

    public void setTopPosition(int topPosition) {
        this.topPosition = topPosition;
    }
}
