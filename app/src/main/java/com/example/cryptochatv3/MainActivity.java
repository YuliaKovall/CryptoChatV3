package com.example.cryptochatv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Animation rotateLoadingWheelAnimation;
    ImageView imageView;
    private static final long DELAY_TIME = 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.rotatingWheel);
        rotateLoadingWheelAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity after the delay time
                Intent intent = new Intent(MainActivity.this, MainPageFirstLaunch.class);
                startActivity(intent);

                // Finish the loading activity to remove it from the back stack
                finish();
            }
        }, DELAY_TIME);

    }
    private void rotateLoadingWheelAnimation() {
        rotateLoadingWheelAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageView.startAnimation(rotateLoadingWheelAnimation);
    }
}