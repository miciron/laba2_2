package com.example.laba2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isAnimating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnimating) {
                    final ObjectAnimator animation = ObjectAnimator.ofFloat(button, "rotation", 0f, 360f);
                    animation.setDuration(1000);
                    animation.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            isAnimating = true;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            isAnimating = false;
                        }
                    });
                    animation.start();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnimating) {
                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_animation);
                    button2.startAnimation(animation);
                    isAnimating = true;
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            isAnimating = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                }
            }
        });
    }
}