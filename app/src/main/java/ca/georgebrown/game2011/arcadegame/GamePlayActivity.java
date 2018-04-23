package ca.georgebrown.game2011.arcadegame;


import android.app.Activity;
import android.os.Bundle;

/**
 * Created by jamie on 08/04/2018.
 */

public class GamePlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        GameCanvasView gameCanvas = findViewById(R.id.gameCanvas);
        gameCanvas.resume();
//        setContentView(new GameCanvasView(this));
    }

}
