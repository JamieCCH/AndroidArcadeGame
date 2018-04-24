package ca.georgebrown.game2011.arcadegame.GameModels;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by jamie on 08/04/2018.
 */

public class Enemy {

    protected Position enemyPosition;
    protected Bitmap enemyImage;
    protected Rect enemyRect;

    public int enemyHeight = 120;
    public int enemyWidth = 150;
    public int enemySpeed = 25;

    public Enemy(Bitmap enemyImage, Position position,int enemySpeed){
        this.enemyImage = enemyImage;
        this.enemyPosition = position;
        this.enemySpeed = enemySpeed;
        setEnemyRect();

    }

    protected void setEnemyRect() {
        int playerLeft = enemyPosition.getLeftPosition();
        int playerTop = enemyPosition.getTopPosition();
        int playerRight = playerLeft + enemyWidth;
        int playerBottom = playerTop + enemyHeight;
        enemyRect = new Rect(playerLeft,playerTop,playerRight,playerBottom);
    }

    public void drawEnemyOnCanvas(Canvas canvas){
        canvas.drawBitmap(enemyImage, null, enemyRect, null);
    }

    public void moveEnemy(){
        int playerLeft = enemyRect.left - enemySpeed;
        int playerTop = enemyRect.top;
        int playerRight = enemyRect.right - enemySpeed;
        int playerBottom = enemyRect.bottom;
        enemyRect = new Rect(playerLeft,playerTop,playerRight,playerBottom);
    }

    public Rect getEnemyRect() {
        return enemyRect;
    }
}
