package com.ctela.ct.castillodetela;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class splash_screen extends ActionBarActivity {

    public static final int segundos = 8;
    public static final int milisegundos = segundos*1000;
    public static final int delay=2;
    private ProgressBar pbProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsplash);
        /* pbProgreso= (ProgressBar) findViewById(R.id.pb_splash); */
        pbProgreso.setMax(maximoProgreso());
       /* empezarAnimacion();*/
    }


    public void empezarAnimacion () {
        new CountDownTimer(milisegundos, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                pbProgreso.setProgress(establecerProgreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent nuevofrom=  new Intent(splash_screen.this, menu_principal.class);
                startActivity(nuevofrom);
                finish();

            }
        }.start();
    }

    public int establecerProgreso(long miliseconds){

        return (int)((milisegundos-miliseconds)/1000);
    }

    public int maximoProgreso() {
        return segundos-delay;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
