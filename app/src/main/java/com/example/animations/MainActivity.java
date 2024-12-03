package com.example.animations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button frameBtn;
    private Button tweenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        frameBtn = findViewById(R.id.button);
        tweenBtn = findViewById(R.id.button2);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation expantionANIM = AnimationUtils.loadAnimation(this, R.anim.expantion);

        frameBtn.startAnimation(fadeIn);
        tweenBtn.startAnimation(expantionANIM);
    }

    public void framePage(View v)
    {
        Intent intent = new Intent (this, FrameActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void tweenPage(View v)
    {
        Intent intent = new Intent (this, TweenActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}