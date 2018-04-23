package ca.georgebrown.game2011.arcadegame.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import ca.georgebrown.game2011.arcadegame.R;

public class Tutorial extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

//        ImageButton play = findViewById(R.id.startButton);
//        play.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startPlay();
//            }
//        });

        ImageButton back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                menu();
            }
        });
    }
//
//    private void startPlay() {
//
//        Intent intent = new Intent(this, GamePlayActivity.class);
//        startActivity(intent);
//    }

    private void menu() {

        onBackPressed();
    }

}
