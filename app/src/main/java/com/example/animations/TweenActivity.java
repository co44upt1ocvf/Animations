package com.example.animations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        ImageView squid = findViewById(R.id.imageView2);
        Button startBtn = findViewById(R.id.button5);
        Button backBtn = findViewById(R.id.button6);

        Animation rotateANIM = AnimationUtils.loadAnimation(this, R.anim.rotate);
        Animation bounceANIM = AnimationUtils.loadAnimation(this, R.anim.bounce);
        Animation tweenANIM = AnimationUtils.loadAnimation(this, R.anim.tween_animation);

        startBtn.startAnimation(rotateANIM);
        backBtn.startAnimation(bounceANIM);

        startBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                squid.startAnimation(tweenANIM);
            }
        });
    }

    public void backToMain(View v)
    {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.wobble_in, R.anim.wobble_out);
    }
}
