package com.example.hellotangible;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

        int x = 0, y = 0;
        Bitmap background;

        Background(int screenX, int screenY, Resources res) {
            background = BitmapFactory.decodeResource(res, R.drawable.chickenbg);
            background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
        }

}
