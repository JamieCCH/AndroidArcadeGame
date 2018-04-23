package ca.georgebrown.game2011.arcadegame.GameModels;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * Created by singh on 2018-04-22.
 */

public class Bullet extends Sprite {

    public String bulletId;
    public int bulletSpeed = 30;

    public Bullet(Bitmap iconImage, Position iconPosition, int iconHeight, int iconWidth) {
        super(iconImage, iconPosition, iconHeight, iconWidth);
    }

    public Rect getIconRect(){
        return this.iconRect;
    }

    public void moveForward(){
        int left = iconRect.left+bulletSpeed;
        int top = iconRect.top;
        int right = iconRect.right+bulletSpeed;
        int bottom = iconRect.bottom;
        this.iconRect = new Rect(left,top,right,bottom);
    }

}
