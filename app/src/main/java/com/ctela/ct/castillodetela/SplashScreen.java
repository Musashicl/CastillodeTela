package com.ctela.ct.castillodetela;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;




/**
 * Created by benja on 26-09-2014.
 */
public class SplashScreen extends Activity {

    protected boolean _active = true;
    protected int _splashTime = 1500; //splash delay time


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (Exception e) {
                    } finally {
                        startActivity( new Intent(SplashScreen.this,menu_principal.class));
                        finish();
                    }
                }
            };
        splashThread.start();
    }


}

