package ca.georgebrown.game2011.arcadegame.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import ca.georgebrown.game2011.arcadegame.R;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton play = findViewById(R.id.startButton);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startPlay();
            }
        });

        ImageButton tutor = findViewById(R.id.tutorialButton);
        tutor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tutorial();
            }
        });

        ImageButton credit = findViewById(R.id.creditButton);
        credit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                credit();
            }
        });

        ImageButton quit = findViewById(R.id.exitButton);
        quit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void startPlay() {

        Intent intent = new Intent(this, GamePlayActivity.class);
        startActivity(intent);
    }

    private void tutorial() {

        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }


    private void credit() {

        Intent intent = new Intent(this, Credit.class);
        startActivity(intent);
    }


}
