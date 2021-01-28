package com.sambit.TicTacToe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import soup.neumorphism.NeumorphTextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Util.blackIconStatusBar(SplashActivity.this, R.color.light_backgroud);

        Window w = getWindow(); // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        NeumorphTextView textView = findViewById(R.id.textView3);
        ImageView imageView = findViewById(R.id.imageView3);
        ImageView imageview2 = findViewById(R.id.image_view6);

        
        textView.setAlpha(0f);
        imageview2.setAlpha(0f);
        imageView.setAlpha(0f);

        textView.animate()
                .translationY(textView.getHeight())
                .alpha(1f)
                .setStartDelay(1000)
                .setDuration(1200);

        imageview2.animate()
                .translationY(textView.getHeight())
                .alpha(1f)
                .setStartDelay(1500)
                .setDuration(1000);
        
        imageView.animate()
                .translationY(textView.getHeight())
                .alpha(1f)
                .setDuration(800);
        
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}
