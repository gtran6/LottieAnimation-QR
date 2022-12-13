package com.example.week4day2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class LottieAnimationActivity extends AppCompatActivity {
    LottieAnimationView animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_animation);

        animation = (LottieAnimationView) findViewById(R.id.animation);
        animation.setAnimation(R.raw.christmas_animations);
        animation.playAnimation();
        animation.loop(true);
    }
}