package com.example.hahaha.imagetestt;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by hahaha on 9/4/16.
 */
public class ImageHandler {
    public static int calculateSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
        int width=options.outWidth;
        int height=options.outHeight;
        int sampleSize=1;

        while(width/sampleSize>reqWidth || height/sampleSize>reqHeight){
            sampleSize=sampleSize*2;
        }
        return sampleSize;
    }

    public static Bitmap decodeReqBitmapfromResource(Resources resources,int resId,
                                                     int reqWidth,int reqHeight){
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(resources,resId,options);
        //calculate SampleSize
        options.inSampleSize=calculateSampleSize(options,reqWidth,reqHeight);
        //redecode
        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeResource(resources,resId,options);
    }
}
