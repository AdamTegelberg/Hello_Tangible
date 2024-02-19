package com.example.hellotangible;

import static com.example.hellotangible.GameView.screenRatioX;
import static com.example.hellotangible.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Bullet {
    int x, y;
    Bitmap bullet;

    Bullet(Resources res) {

        bullet = BitmapFactory.decodeResource(res, R.drawable.bullet);

        int width = bullet.getWidth();
        int height = bullet.getHeight();

        width = (int) width / 4;
        height = (int) height / 4;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        bullet = Bitmap.createScaledBitmap(bullet, width, height, false);

    }


}
