package com.example.rapidrollclassic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class GameView extends SurfaceView implements Runnable {

    public static int maxX = 20; // размер по горизонтали
    public static int maxY = 28; // размер по вертикали
    public static float unitW = 0; // пикселей в юните по горизонтали
    public static float unitH = 0; // п

    private boolean firstTime = true;
    private boolean gameRunning = true;
    private Thread gameThread = null;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    Platform platform;


    private final int ASTEROID_INTERVAL = 50; // время через которое появляются астероиды (в итерациях)
    private int currentTime = 0;

    public GameView(Context context) {
        super(context);
        //инициализируем обьекты для рисования
        surfaceHolder = getHolder();
        paint = new Paint();

        // инициализируем поток
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameRunning) {
            update();
            draw();
            checkCollision();
            checkIfNewAsteroid();
            control();
        }
    }

    private void checkCollision() {
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void checkIfNewAsteroid() {

    }

    private void update() {
        if(!firstTime) {

        }
    }

    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {  //проверяем валидный ли surface

            if(firstTime){ // инициализация при первом запуске
                firstTime = false;
                unitW = surfaceHolder.getSurfaceFrame().width()/maxX; // вычисляем число пикселей в юните
                unitH = surfaceHolder.getSurfaceFrame().height()/maxY;


            }

            canvas = surfaceHolder.lockCanvas();

            canvas.drawCircle(500, 170, 25, paint);


            surfaceHolder.unlockCanvasAndPost(canvas); // открываем canvas
        }
    }
}
