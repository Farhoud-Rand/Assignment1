package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductionActivity extends AppCompatActivity {
    ImageView logo, background;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        logo = findViewById(R.id.logo);
        background = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);

        background.animate()
                .translationX(1600) // Move to the right along the X-axis
                .translationY(-1600) // Move upward along the Y-axis
                .setDuration(1000)
                .setStartDelay(3000);

        //background.animate().translationY(-3000).setDuration(1000).setStartDelay(3000);
        lottieAnimationView.animate().translationY(3000).setDuration(1000).setStartDelay(3000);

        // Handler to make the logo visible after 3.3 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create the scaling animation
                ScaleAnimation scaleAnimation = new ScaleAnimation(
                        0.5f, 1f, // Start and end scale X
                        0.5f, 1f, // Start and end scale Y
                        Animation.RELATIVE_TO_SELF, 0.5f, // Pivot X coordinate
                        Animation.RELATIVE_TO_SELF, 0.5f // Pivot Y coordinate
                );

                // Set the animation duration and other properties
                scaleAnimation.setDuration(1000); // Animation duration in milliseconds
                scaleAnimation.setFillAfter(true); // Maintain the final animation state

                // Start the animation on the logo ImageView
                logo.startAnimation(scaleAnimation);
            }
        }, 3300); // Delay for 3.3 seconds (3300 milliseconds)



        // Delayed execution to start MainActivity after the animation finishes
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to start MainActivity
                Intent intent = new Intent(IntroductionActivity.this, MainActivity.class);
                startActivity(intent);

                // Finish the IntroductionActivity to prevent going back to it with the back button
                finish();
            }
        }, 4800); // Delay for 4.8 seconds (4800 milliseconds)

    }
}