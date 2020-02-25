package com.greenbelly.need.ui.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class Base64Util {

    private static int img_width = 1035;
    private static int img_height = 250;

    public static Bitmap imageStringToBitmap(String base64image, int width, int height) {
        img_width = width;
        img_height = height;
        byte[] encodeByte = Base64.decode(base64image.getBytes(), Base64.DEFAULT);
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap image = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length, options);

        return resizeImage(image);
    }

    public static Bitmap resizeImage(Bitmap image) {

        image = Bitmap.createScaledBitmap(image, img_width, img_height, false);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return image;
    }


}
