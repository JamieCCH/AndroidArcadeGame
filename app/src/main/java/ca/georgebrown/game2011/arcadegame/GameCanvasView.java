package ca.georgebrown.game2011.arcadegame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by jamie on 08/04/2018.
 */

class GameCanvasView extends SurfaceView implements Runnable {

    Thread ourThread = null;
    SurfaceHolder ourHolder;
    boolean isGamePlaying;

    long lastFrameTime;
    int fps;

    private Canvas canvas;
    private HUDElement background, scoreBgr, timerBgr, heartFull, heartEmpty, bombFull, bombEmpty, bombButton, pauseButton;
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

    public GameCanvasView(Context context){
        super(context);
        setupGameCanvasView();
    }

    private void setupGameCanvasView() {

        ourHolder = getHolder();
        initializeScreenMeasurements();
        initializeHUDElementsVariables();
        setupPlayer();

    }

    private void initializeScreenMeasurements(){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;

        hudAreaHeight = screenHeight/4;

    }


    private void initializeHUDElementsVariables() {

        //Background
        Bitmap backgroundBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.background_gameplay);
        Position backgroundPosition = new Position(0,0);
        background = new HUDElement(backgroundBMP,backgroundPosition,screenHeight,screenWidth);

        //Layer 1 HUD Elements
        Bitmap scoreBgrBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_score);
        Position scorePosition = new Position(10,10);
        scoreBgr = new HUDElement(scoreBgrBMP,scorePosition,hudAreaHeight/3 - 10,screenWidth/4);

        Bitmap timerBgrBMP = BitmapFactory.decodeResource(getResources(),R.mipmap.hud_timer);
        Position timerPosition = new Position(screenWidth/4 + 20,20);
        timerBgr = new HUDElement(timerBgrBMP,timerPosition,hudAreaHeight/3 - 20,3*screenWidth/4 - 40);


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
        this.draw();

    }

    private void draw(){
        if (ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);
            background.drawIconOnCanvas(canvas);
            scoreBgr.drawIconOnCanvas(canvas);
            timerBgr.drawIconOnCanvas(canvas);

            for (HUDElement icon : lifeLeftIcons) {
                icon.drawIconOnCanvas(canvas);
            }

            for (HUDElement icon : bombsLeftIcons) {
                icon.drawIconOnCanvas(canvas);
            }

            pauseButton.drawIconOnCanvas(canvas);
            bombButton.drawIconOnCanvas(canvas);

            player.drawPlayerOnCanvas(canvas);

            ourHolder.unlockCanvasAndPost(canvas);

        }
    }

    public void controlFPS(){
        long timeThisFrame = (System.currentTimeMillis() - lastFrameTime);
        long timeToSleep = 50 - timeThisFrame;

        if(timeThisFrame > 0) {
            fps = (int)(1000/timeThisFrame);
        }

        if (timeToSleep > 0) {
            try {
                ourThread.sleep(timeToSleep);
            } catch (InterruptedException e) {
            }
        }

        lastFrameTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        while (isGamePlaying){
            draw();
            controlFPS();
        }
    }

    public void pause() {
        isGamePlaying = false;
        try {
            ourThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        isGamePlaying = true;
        ourThread = new Thread(this);
        ourThread.start();
    }

    public void takeLife(){
        if(livesLeft > 0){
            livesLeft--;
            int lastIndex = lifeLeftIcons.size() - 1;
            lifeLeftIcons.remove(lastIndex);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        this.updatePlayerPositionTo(x,y);

        return true;
    }

    public void updatePlayerPositionTo(int x, int y){

        if(y > screenHeight - player.playerHeight){
            y = screenHeight - player.playerHeight;
        }

        if (y < hudAreaHeight + player.topMinionHeight + 20){
            y = hudAreaHeight + player.topMinionHeight + 20;
        }

        if (x > screenWidth - player.playerWidth){
            x = screenWidth - player.playerWidth;
        }

        player.setPlayerPosition(new Position(x,y));
    }


}
