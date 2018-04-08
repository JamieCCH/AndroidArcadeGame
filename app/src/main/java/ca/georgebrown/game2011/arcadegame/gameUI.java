package ca.georgebrown.game2011.arcadegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by jamie on 08/04/2018.
 */

class gameUI extends View {
    Bitmap bgr, scoreBgr, timerBgr, heartFull, heartEmpty, bombFull, bombEmpty;

    public gameUI(Context context) {
        super(context);
        bgr = BitmapFactory.decodeResource(getResources(),R.drawable.background_gameplay);
        scoreBgr = BitmapFactory.decodeResource(getResources(),R.drawable.hud_score);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawBitmap(bgr, 0, 0, null);
        canvas.drawBitmap(scoreBgr,10,10,null);
    }
}
