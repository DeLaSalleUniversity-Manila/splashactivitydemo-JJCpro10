package com.example.janssen.splashactivitydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.content.Intent;


public class SplashActivity extends Activity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);



        startAnimating();
    }



private void startAnimating() {

        TextView logo1 = (TextView) findViewById(R.id.textView);
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo1.startAnimation(fade1);

        TextView logo2 = (TextView) findViewById(R.id.textView2);
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        logo2.startAnimation(fade2);

        fade2.setAnimationListener(new Animation.AnimationListener() {

@Override
public void onAnimationEnd(Animation animation) {

        Intent i = new Intent(SplashActivity.this,
        MainActivity.class);
        startActivity(i);
        SplashActivity.this.finish();
        }

@Override
public void onAnimationRepeat(Animation animation) {
        }

@Override
public void onAnimationStart(Animation animation) {
        }


        });

        Animation spinin = AnimationUtils.loadAnimation(this,
        R.anim.custom_anim);
        LayoutAnimationController controller = new LayoutAnimationController(
        spinin);
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
        TableRow row = (TableRow) table.getChildAt(i);
        row.setLayoutAnimation(controller);
        }
        }

}