package com.ctela.ct.castillodetela;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by benja on 26-09-2014.
 */
public class new_splash extends Activity {

    ImageView ivNube1,ivNube2,ivNube3;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsplash);

        ivNube1 = (ImageView) findViewById(R.id.ivNube1);
        ivNube2 = (ImageView) findViewById(R.id.ivNube2);
        //ivNube3 = (ImageView) findViewById(R.id.ivNube3);

        //rotate nube1
        ObjectAnimator rotateNube1 = ObjectAnimator.ofFloat(ivNube1, View.ROTATION, 3);
        rotateNube1.setRepeatCount(ValueAnimator.INFINITE);
        rotateNube1.setDuration(1000);
        rotateNube1.setRepeatMode(ValueAnimator.REVERSE);
        //rotate nube 2
      ObjectAnimator rotateNube2 = ObjectAnimator.ofFloat(ivNube2, View.ROTATION, 3);
        rotateNube2.setRepeatCount(ValueAnimator.INFINITE);
        rotateNube2.setDuration(1000);
        rotateNube2.setRepeatMode(ValueAnimator.REVERSE);
        //rotate nube 3
       /* ObjectAnimator rotateNube3 = ObjectAnimator.ofFloat(ivNube3, View.ROTATION, 3);
        rotateNube3.setRepeatCount(ValueAnimator.INFINITE);
        rotateNube3.setDuration(1000);
        rotateNube3.setRepeatMode(ValueAnimator.REVERSE);
*/
       // Translate nube 1
        ObjectAnimator translateNube1 = ObjectAnimator.ofFloat(ivNube1, View.TRANSLATION_X, 800);
        translateNube1.setRepeatCount(ValueAnimator.INFINITE);
        translateNube1.setDuration(11000);
        // Translate nube 2
        ObjectAnimator translateNube2 = ObjectAnimator.ofFloat(ivNube2, View.TRANSLATION_X, -800);
        translateNube2.setRepeatCount(ValueAnimator.INFINITE);
        translateNube2.setDuration(13000);
        // Translate nube 3
        ObjectAnimator translateNube3 = ObjectAnimator.ofFloat(ivNube3, View.TRANSLATION_X, 800);
        translateNube3.setRepeatCount(ValueAnimator.INFINITE);
        translateNube3.setDuration(15000);





        AnimatorSet setAnimation = new AnimatorSet();
       setAnimation.play(rotateNube1).with(rotateNube2).with(translateNube1).with(translateNube2);
        setAnimation.start();




    }

    public void inicio (View v) {
        Intent Inicio= new Intent (this, menu_principal.class);

        startActivity(Inicio);
    }


}
