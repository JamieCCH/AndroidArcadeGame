package ca.georgebrown.game2011.arcadegame.Activities;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ca.georgebrown.game2011.arcadegame.GameView.GameCanvasView;
import ca.georgebrown.game2011.arcadegame.R;

/**
 * Created by jamie on 08/04/2018.
 */

public class GamePlayActivity extends Activity {

    GameCanvasView gameCanvas;
    LinearLayout pauseMenuView;
    TextView gamePauseTextView;

    boolean didPlayerExitGame = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        gameCanvas = findViewById(R.id.gameCanvas);
        pauseMenuView = findViewById(R.id.pause_menu_view);
        gamePauseTextView = findViewById(R.id.game_pause_text);

        pauseMenuView.setVisibility(View.INVISIBLE);
        gameCanvas.pauseMenuView = this.pauseMenuView;

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/anabelle_script_light.otf");
        gamePauseTextView.setTypeface(tf);
//        gameCanvas.resume();
    }

    public void onResumeGameButtonClicked(View view){
        pauseMenuView.setVisibility(View.INVISIBLE);
        gameCanvas.resume();
    }

    public void onExitGameButtonClicked(View view){
        didPlayerExitGame = true;
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
        if (didPlayerExitGame){
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}
