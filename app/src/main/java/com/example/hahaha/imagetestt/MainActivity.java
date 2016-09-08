package com.example.hahaha.imagetestt;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;

     class BitmapTask extends AsyncTask<Integer,Void,Bitmap> {
        private final WeakReference<ImageView> imageViewWeakReference;
        private int data;

        public BitmapTask(ImageView imageView) {
            imageViewWeakReference=new WeakReference<ImageView>(imageView);
        }

        @Override
        protected Bitmap doInBackground(Integer... params) {
            data=params[0];
            return ImageHandler.decodeReqBitmapfromResource(getResources(),
                    R.drawable.pic1,200,200);
        }

         @Override
         protected void onPostExecute(Bitmap bitmap) {
             if (imageViewWeakReference!=null && bitmap!=null){
                 ImageView theImageView=imageViewWeakReference.get();
                 if(theImageView!=null){
                     theImageView.setImageBitmap(bitmap);

                 }
             }
         }
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageView);
        button= (Button) findViewById(R.id.btn_loadpic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageBitmap(ImageHandler.decodeReqBitmapfromResource(getResources(),
                        R.drawable.pic1,200,200));
            }
        });

        button= (Button) findViewById(R.id.btn_listview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Activity_ListView.class);
                startActivity(intent);
            }
        });

    }
}
