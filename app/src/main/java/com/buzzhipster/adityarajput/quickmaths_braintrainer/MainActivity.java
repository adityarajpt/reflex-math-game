package com.buzzhipster.adityarajput.quickmaths_braintrainer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity{
    Button playButton;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//actual game code
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , gameSetting.class);
                startActivity(intent);
                playButton.setBackgroundColor(R.drawable.batman);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        playButton.setBackgroundColor(Color.TRANSPARENT);

    }
}
