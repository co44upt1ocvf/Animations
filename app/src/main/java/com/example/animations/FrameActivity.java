package com.example.animations;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FrameActivity extends AppCompatActivity {
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        ImageView cats = findViewById(R.id.imageView);
        Button startBtn = findViewById(R.id.button3);
        Button backBtn = findViewById(R.id.button4);

        frameAnimation = (AnimationDrawable)cats.getDrawable();

        Animation blinkANIM = AnimationUtils.loadAnimation(this, R.anim.blink);
        Animation shakeANIM = AnimationUtils.loadAnimation(this, R.anim.shake);

        startBtn.startAnimation(blinkANIM);
        backBtn.startAnimation(shakeANIM);

        startBtn.setOnClickListener(v -> {
            if (!frameAnimation.isRunning()) {
                frameAnimation.start();
            }
        });
    }

    public void backToMain(View v)
    {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
    }
}
