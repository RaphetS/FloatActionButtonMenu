package org.raphets.floatbuttondemo;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isShowed=false;
    private TextView mTv;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv= (TextView) findViewById(R.id.tv);
         fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (isShowed){
                   closeMenu(view);
               }else {
                   openMenu(view);
               }
            }
        });
    }

    private void closeMenu(View view) {
        ObjectAnimator animator=ObjectAnimator.ofFloat(view,"rotation",-135,20,0);
        animator.setDuration(500);
        animator.start();

        AlphaAnimation alphaAnim=new AlphaAnimation(0.7f,0);
        alphaAnim.setDuration(500);
        mTv.startAnimation(alphaAnim);
        mTv.setVisibility(View.GONE);

        isShowed=false;
    }

    private void openMenu(View view){
        ObjectAnimator animator=ObjectAnimator.ofFloat(view,"rotation",0,-155,-135);
        animator.setDuration(500);
        animator.start();

        mTv.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnim=new AlphaAnimation(0,0.7f);
        alphaAnim.setDuration(500);
        alphaAnim.setFillAfter(true);
        mTv.startAnimation(alphaAnim);

        isShowed=true;
    }

    @Override
    public void onBackPressed() {
        if (isShowed){
            closeMenu(fab);
        }else {
            super.onBackPressed();
        }
    }
}
