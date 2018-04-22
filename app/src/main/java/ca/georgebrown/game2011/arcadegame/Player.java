package ca.georgebrown.game2011.arcadegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by jamie on 08/04/2018.
 */

public class Player {

    private Position playerPosition;
    private Bitmap playerImage;
    private Bitmap playerMinionImage;

    private int playerHeight = 120;
    private int playerWidth = 150;

    private int minionHeight = 30;
    private int minionWidth = 45;

    private Rect playerRect;
    private Rect topMinionRect;
    private Rect bottomMinionRect;

    Player(Bitmap playerImage,Position position,Bitmap playerMinionImage){
        this.playerImage = playerImage;
        this.playerMinionImage = playerMinionImage;
        this.playerPosition = position;
        setPlayerRect();
        setTopMinionRect();
        setBottomMinionRect();
    }

    private void setPlayerRect() {
        int playerLeft = playerPosition.getLeftPosition();
        int playerTop = playerPosition.getTopPosition();
        int playerRight = playerLeft + playerWidth;
        int playerBottom = playerTop + playerHeight;
        playerRect = new Rect(playerLeft,playerTop,playerRight,playerBottom);

    }

    private void setBottomMinionRect() {
        int minionLeft = playerRect.left;
        int minionTop = playerRect.bottom + 10;
        int minionRight = minionLeft + minionWidth;
        int minionBottom = minionTop + minionHeight;
        bottomMinionRect = new Rect(minionLeft,minionTop,minionRight,minionBottom);
    }

    private void setTopMinionRect() {
        int minionLeft = playerRect.left;
        int minionTop = playerRect.top - minionHeight - 10;
        int minionRight = minionLeft + minionWidth;
        int minionBottom = minionTop + minionHeight;
        topMinionRect = new Rect(minionLeft,minionTop,minionRight,minionBottom);
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void drawPlayerOnCanvas(Canvas canvas){
        canvas.drawBitmap(playerImage, null, playerRect, null);
        canvas.drawBitmap(playerMinionImage, null, topMinionRect, null);
        canvas.drawBitmap(playerMinionImage, null, bottomMinionRect, null);
    }


}
