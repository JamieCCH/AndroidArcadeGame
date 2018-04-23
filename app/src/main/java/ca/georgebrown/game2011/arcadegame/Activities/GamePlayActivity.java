package ca.georgebrown.game2011.arcadegame.Activities;


import android.app.Activity;
import android.os.Bundle;

import ca.georgebrown.game2011.arcadegame.GameView.GameCanvasView;
import ca.georgebrown.game2011.arcadegame.R;

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
