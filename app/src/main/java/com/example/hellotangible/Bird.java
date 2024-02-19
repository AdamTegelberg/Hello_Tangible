package com.example.hellotangible;

import static com.example.hellotangible.GameView.screenRatioX;
import static com.example.hellotangible.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Bird {

    public int speed = 20;
    int x = 0, y, width, height, birdCounter = 1;
    Bitmap chickenBeaver1, chickenBeaver2, chickenBeaver3;

    Bird(Resources res) {

        //4 bilder i rad ser ut som en animation.
        chickenBeaver1 = BitmapFactory.decodeResource(res, R.drawable.beaverchicken1);
        chickenBeaver2 = BitmapFactory.decodeResource(res, R.drawable.beaverchicken2);
        chickenBeaver3 = BitmapFactory.decodeResource(res, R.drawable.beaverchicken3);

        width = chickenBeaver1.getWidth();
        height = chickenBeaver1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        chickenBeaver1 = Bitmap.createScaledBitmap(chickenBeaver1, width, height, false);
        chickenBeaver2 = Bitmap.createScaledBitmap(chickenBeaver2, width, height, false);
        chickenBeaver3 = Bitmap.createScaledBitmap(chickenBeaver3, width, height, false);


        y = -height;

    }

    Bitmap getBird() {
        if (birdCounter == 1) {
            birdCounter ++;
            return chickenBeaver1;
        }
        if (birdCounter == 2) {
            birdCounter ++;
            return chickenBeaver2;
        }
        else{
            birdCounter = 1;
            return chickenBeaver3;
        }

    }

    Rect getCollisionShape() {
        return new Rect(x, y, x + width, y + height);
    }



}
