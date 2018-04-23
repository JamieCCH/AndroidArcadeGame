package ca.georgebrown.game2011.arcadegame.Activities;


import android.app.Activity;
import android.os.Bundle;

import ca.georgebrown.game2011.arcadegame.GameView.GameCanvasView;
import ca.georgebrown.game2011.arcadegame.R;

/**
 * Created by jamie on 08/04/2018.
 */

public class GamePlayActivity extends Activity {

    GameCanvasView gameCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        gameCanvas = findViewById(R.id.gameCanvas);
//        gameCanvas.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameCanvas.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameCanvas.resume();
    }
}
