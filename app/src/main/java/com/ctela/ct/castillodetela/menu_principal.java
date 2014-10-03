package com.ctela.ct.castillodetela;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.ctela.ct.castillodetela.view.VerticalPager;


/**
 * Created by benja on 24-09-2014.
 */
public class menu_principal extends Activity {

    VerticalPager pagerLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);
        pagerLibros = (VerticalPager) findViewById(R.id.pgLibros);

        for (int i = 0; i < 20; i++) {
            setViewPagerData("Subhanallah " + i);
        }
    }

    private void setViewPagerData(final String str) {
        Log.e("Set Filpper Called", str + "");
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.flipper_item_view, null);
        TextView textView1 = (TextView) view.findViewById(R.id.textView1);
        TextView textView2 = (TextView) view.findViewById(R.id.textView2);
        textView1.setText("" + str);
        textView2.setText("" + str);
        Button button = (Button) view.findViewById(R.id.button1);
        pagerLibros.addView(view);
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
