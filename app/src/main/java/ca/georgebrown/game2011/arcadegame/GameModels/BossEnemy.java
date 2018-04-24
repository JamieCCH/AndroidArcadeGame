package ca.georgebrown.game2011.arcadegame.GameModels;

import android.graphics.Bitmap;

/**
 * Created by singh on 2018-04-23.
 */

public class BossEnemy extends Enemy {

    public int health = 1000;

    public BossEnemy(Bitmap enemyImage, Position position) {
        super(enemyImage, position, 5);
        enemyHeight = 450;
        enemyWidth = 450;
        setEnemyRect();
    }

}
