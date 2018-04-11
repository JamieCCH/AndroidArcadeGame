package ca.georgebrown.game2011.arcadegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by jamie on 08/04/2018.
 */

class gameUI extends View {

    Bitmap bgr, scoreBgr, timerBgr, heartFull, heartEmpty, bombFull, bombEmpty, bombButton, pauseButton;

    public gameUI(Context context) {
        super(context);
        bgr = BitmapFactory.decodeResource(getResources(),R.mipmap.background_gameplay);
        scoreBgr = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_score);
        bombButton = BitmapFactory.decodeResource(getResources(),R.mipmap.button_bomb);
        timerBgr = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_timer);
        pauseButton = BitmapFactory.decodeResource(getResources(),R.mipmap.button_pause);
        heartFull = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_fullheart);
        heartEmpty = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_emptyheart);
        bombFull = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_fullbomb);
        bombEmpty = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_emptybomb);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawBitmap(bgr, 0, 0, null);
        canvas.drawBitmap(scoreBgr,10,10,null);
        canvas.drawBitmap(bombButton, 400, 20,null);
        canvas.drawBitmap(timerBgr, 500, 25, null);
        canvas.drawBitmap(pauseButton, 500, 20, null);

        //make an array later
        canvas.drawBitmap(heartFull, 15, 100, null);
        canvas.drawBitmap(heartFull, 60, 100, null);
        canvas.drawBitmap(heartEmpty, 105, 100, null);

        //make an array as well
        canvas.drawBitmap(bombFull, 180, 90, null);
        canvas.drawBitmap(bombFull, 220, 90, null);
        canvas.drawBitmap(bombEmpty, 260, 90, null);
        canvas.drawBitmap(bombEmpty, 300, 90, null);
        canvas.drawBitmap(bombEmpty, 340, 90, null);
    }
}
