package ca.georgebrown.game2011.arcadegame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by jamie on 08/04/2018.
 */

class GameCanvasView extends View {

    private Canvas canvas;
    private HUDElement scoreBgr, timerBgr, heartFull, heartEmpty, bombFull, bombEmpty, bombButton, pauseButton;
    private Player player;

    private int screenWidth;
    private int screenHeight;
    int hudAreaHeight;

    int livesLeft = 3;
    int bombsLeft = 5;

    ArrayList<HUDElement> lifeLeftIcons = new ArrayList<>();
    ArrayList<HUDElement> bombsLeftIcons = new ArrayList<>();

    public GameCanvasView(Context context, AttributeSet attrs){
        super(context,attrs);
        setupGameCanvasView();
    }

    private void setupGameCanvasView() {

        initializeScreenMeasurements();


        initializeBitmapVariables();
        initializeIconArrays();
        setupPlayer();

    }

    private void initializeScreenMeasurements(){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;

        hudAreaHeight = screenHeight/4;

    }

    private void initializeIconArrays() {

    }

    private void initializeBitmapVariables() {


        //Layer 1 HUD Elements
        Bitmap scoreBgrBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_score);
        Position scorePosition = new Position(10,10);
        scoreBgr = new HUDElement(scoreBgrBMP,scorePosition,hudAreaHeight/3 - 10,screenWidth/4);

        Bitmap timerBgrBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_timer);
        Position timerPosition = new Position(screenWidth/4 + 20,20);
        timerBgr = new HUDElement(timerBgrBMP,timerPosition,hudAreaHeight/3 - 10,3*screenWidth/4 - 40);


        //Layer 2 HUD Elements
        Bitmap heartFullBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_fullheart);

        for (int i = 0; i < livesLeft; i++){
            int lifeIconWidthHeight = hudAreaHeight/3;
            Position lifeIconPosition = new Position(scorePosition.getLeftPosition()+(i*lifeIconWidthHeight)+10,hudAreaHeight/3);
            HUDElement lifeIcon = new HUDElement(heartFullBMP,lifeIconPosition,lifeIconWidthHeight,lifeIconWidthHeight);
            lifeLeftIcons.add(lifeIcon);
        }

        Bitmap bombFullBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_fullbomb);

        for (int i = 0; i < bombsLeft; i++){
            int bombIconWidthHeight = hudAreaHeight/3;
            Position bombIconPosition = new Position((screenWidth/4)+(i*bombIconWidthHeight) + 30,hudAreaHeight/3);
            HUDElement bombIcon = new HUDElement(bombFullBMP,bombIconPosition,bombIconWidthHeight,bombIconWidthHeight);
            bombsLeftIcons.add(bombIcon);
        }

        //Layer 3 HUD Elements
        Bitmap pauseButtonBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.button_pause);
        Position pauseButtonPosition = new Position(20,2*hudAreaHeight/3);
        pauseButton = new HUDElement(pauseButtonBMP,pauseButtonPosition,hudAreaHeight/3,hudAreaHeight/3);

        Bitmap bombButtonBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.button_bomb);
        Position bombButtonPosition = new Position(hudAreaHeight/3+30,2*hudAreaHeight/3);
        bombButton = new HUDElement(bombButtonBMP,bombButtonPosition,hudAreaHeight/3,hudAreaHeight/3);

    }

    private void setupPlayer() {

        Bitmap playerMinionImage = BitmapFactory.decodeResource(getResources(),R.mipmap.player_helper);
        Bitmap playerImage = BitmapFactory.decodeResource(getResources(),R.mipmap.player);
        Position playerPosition = new Position(150,350);
        player = new Player(playerImage,playerPosition,playerMinionImage);

    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        this.canvas = canvas;
        this.draw();

    }

    private void draw(){
        scoreBgr.drawIconOnCanvas(canvas);
        timerBgr.drawIconOnCanvas(canvas);

        for (HUDElement icon : lifeLeftIcons){
            icon.drawIconOnCanvas(canvas);
        }

        for (HUDElement icon : bombsLeftIcons){
            icon.drawIconOnCanvas(canvas);
        }

        pauseButton.drawIconOnCanvas(canvas);
        bombButton.drawIconOnCanvas(canvas);

        player.drawPlayerOnCanvas(canvas);
    }
}
