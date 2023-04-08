package com.example.recycleview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_view);
        ImageView imgview = findViewById(R.id.imgview);
        Intent intent = new Intent(this.getIntent());
        int s = intent.getIntExtra("image",0);
        Drawable dr = getDrawable(s);
        imgview.setImageDrawable(dr);
        String as = intent.getStringExtra("mydata");
        Log.e("***", "Received data is " + as); //check data
    }
}
