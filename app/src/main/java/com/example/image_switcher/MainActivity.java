package com.example.image_switcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher image_switcher;
    Button btn_next, btn_previous;

    //creating integer array of photo
    int[] image_arr = {R.drawable.imageone, R.drawable.imgtwo, R.drawable.imgthree, R.drawable.imgfour, R.drawable.imgfive, R.drawable.imgsix, R.drawable.imgseven};
    int image_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_next = (Button) findViewById(R.id.btn_next);
        btn_previous = (Button) findViewById(R.id.btn_previous);

        image_switcher = (ImageSwitcher) findViewById(R.id.image_switcher);

        //to set image switcher we need to add image switcher method i.e
        image_switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                //HERE WE NEED TO CREATE CLASS OF IMAGEVIEW TO SET IMAGE OBJECT

                ImageView imageView = new ImageView(getApplicationContext());
                //to show image in center
                imageView.setScaleType(ImageView.ScaleType.CENTER);


                return imageView;
            }
        });

        //to show image of zeroth position
        image_switcher.setImageResource(image_arr[0]);

    }

    public void nextBtn(View view) {
        image_index = image_index + 1;
        //sabai images image array bata sakepaxi next click garda crash rokna ko lagi and again image start bata aauna ko lagi
        if (image_index == image_arr.length) {
            image_index = 0;
        }
        image_switcher.setImageResource(image_arr[image_index]);

    }

    public void previousBtn(View view)
    {
        image_index=image_index-1;
        //sabai images image array bata sakepaxi next click garda crash rokna ko lagi and again image start bata aauna ko lagi
        if(image_index<0)
        {
            image_index=image_arr.length-1;
        }

        image_switcher.setImageResource(image_arr[image_index]);
    }
}