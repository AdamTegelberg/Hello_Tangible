package com.example.hellotangible;

import static com.example.hellotangible.GameView.screenRatioX;
import static com.example.hellotangible.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Flight {

    public boolean isGoingUp = false;
    int x, y, width, height, wingCounter = 0;
    Bitmap chicken1, chicken2, dead;


    Flight(int screenY, Resources res) {
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

        y = screenY / 2;
        x = (int) (64 * screenRatioX);

        dead = BitmapFactory.decodeResource(res, R.drawable.chickenchickendead);
        dead = Bitmap.createScaledBitmap(dead, width, height, false);

    }

    Bitmap getFlight() {

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
