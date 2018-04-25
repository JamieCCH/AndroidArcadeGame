package ca.georgebrown.game2011.arcadegame.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ca.georgebrown.game2011.arcadegame.R;

public class GameFinishedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_finished);

        Bundle intentExtras = getIntent().getExtras();
        Boolean didPlayerWon = intentExtras.getBoolean("didWin",false);
        String score = intentExtras.getString("score","--");


        //Set background according to game win/lose status
        ImageView gameFinishedImageView = findViewById(R.id.game_finished_image_view);
        Bitmap imageBMP;
        if(didPlayerWon){
            imageBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.screen_win);
        }else{
            imageBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.screen_lose);
        }

        gameFinishedImageView.setImageBitmap(imageBMP);

        //Set score on score textview
        TextView scoreTextView = findViewById(R.id.score_text_view);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/anabelle_script_light.otf");
        scoreTextView.setTypeface(tf);
        scoreTextView.setText(score);
    }

    public void onPlayAgainClicked(View view){
        Intent mainMenu = new Intent(getApplicationContext(),MainActivity.class);
        mainMenu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainMenu);
    }

    public void onExitClicked(View view){
        finish();
    }


}
