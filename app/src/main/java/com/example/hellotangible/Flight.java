package com.example.hellotangible;

import static com.example.hellotangible.GameView.screenRatioX;
import static com.example.hellotangible.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Flight {

    private GameView gameView;
    public boolean isGoingUp = false;
    int x, y, width, height, wingCounter = 0, shootCounter = 1;
    Bitmap chicken1, chicken2, dead, shoot5;
    public int toShoot = 0;


    Flight(GameView gameView, int screenY, Resources res) {

        this.gameView = gameView;
        chicken1 = BitmapFactory.decodeResource(res, R.drawable.chickenchicken1);
        chicken2 = BitmapFactory.decodeResource(res, R.drawable.chickenchicken2);

        width = chicken1.getWidth();
        height = chicken1.getHeight();

        width /= 4;
        height /= 4;

        width = (int) (screenRatioX * width);
        height = (int) (screenRatioY * height);

        chicken1 = Bitmap.createScaledBitmap(chicken1, width, height, false);
        chicken2 = Bitmap.createScaledBitmap(chicken2, width, height, false);

        shoot5 = BitmapFactory.decodeResource(res, R.drawable.chickenchicken2);
        shoot5 = Bitmap.createScaledBitmap(shoot5, width, height, false);

        y = screenY / 2;
        x = (int) (64 * screenRatioX);

        dead = BitmapFactory.decodeResource(res, R.drawable.chickenchickendead);
        dead = Bitmap.createScaledBitmap(dead, width, height, false);

    }

    Bitmap getFlight() {

        if (toShoot != 0) {

            toShoot --;
            gameView.newBullet();
            return shoot5;

        }

        if (wingCounter == 0) {
            wingCounter ++;
            return chicken1;
        }
        wingCounter --;
        return chicken2;
    }

    Rect getCollisionShape() {
        return new Rect(x, y, x + width, y + height);
    }

    Bitmap getDead() {
        return dead;
    }


}
