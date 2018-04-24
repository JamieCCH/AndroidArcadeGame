package ca.georgebrown.game2011.arcadegame.Activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import ca.georgebrown.game2011.arcadegame.GameView.GameCanvasView;
import ca.georgebrown.game2011.arcadegame.R;

/**
 * Created by jamie on 08/04/2018.
 */

public class GamePlayActivity extends Activity {

    GameCanvasView gameCanvas;
    LinearLayout pauseMenuView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        gameCanvas = findViewById(R.id.gameCanvas);
        pauseMenuView = findViewById(R.id.pause_menu_view);
        pauseMenuView.setVisibility(View.INVISIBLE);

        gameCanvas.pauseMenuView = this.pauseMenuView;
//        gameCanvas.resume();
    }

    public void onResumeGameButtonClicked(View view){
        pauseMenuView.setVisibility(View.INVISIBLE);
        gameCanvas.resume();
    }

    public void onExitGameButtonClicked(View view){
        finish();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
