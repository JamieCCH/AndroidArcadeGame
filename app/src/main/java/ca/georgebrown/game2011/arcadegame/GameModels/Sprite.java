package ca.georgebrown.game2011.arcadegame.GameModels;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by singh on 2018-04-22.
 */

public class Sprite {

    protected Bitmap iconImage;
    protected Position iconPosition;
    protected Rect iconRect;

    protected int iconHeight;
    protected int iconWidth;

    public Sprite(Bitmap iconImage, Position iconPosition, int iconHeight, int iconWidth) {
        this.iconImage = iconImage;
        this.iconPosition = iconPosition;
        this.iconHeight = iconHeight;
        this.iconWidth = iconWidth;

        this.setIconRect();
    }

    protected void setIconRect() {

        int left = iconPosition.getLeftPosition();
        int top = iconPosition.getTopPosition();
        int right = left + iconWidth;
        int bottom = top + iconHeight;
        this.iconRect = new Rect(left,top,right,bottom);

    }

    public void setIconImage(Bitmap iconImage) {
        this.iconImage = iconImage;
    }

    public void drawIconOnCanvas(Canvas canvas){
        canvas.drawBitmap(iconImage,null,iconRect,null);
    }

}
