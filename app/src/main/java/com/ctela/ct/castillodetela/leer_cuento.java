package com.ctela.ct.castillodetela;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.view.Window;
import android.widget.RelativeLayout;
import java.util.ArrayList;




/**
 * Created by Sebastian on 10/6/2014.
 */
public class leer_cuento extends Activity implements View.OnClickListener {


    ImageButton btFwd;
    ImageButton btBwd;
    RelativeLayout back;
    ArrayList<Integer> imagearray;
    Resources res;
    Drawable drawable;
    int track = 0;
    boolean flag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
        setContentView(R.layout.leercuento_layout);

        imagearray = new ArrayList<Integer>();

        back = (RelativeLayout) findViewById(R.id.back);
        btBwd = (ImageButton) findViewById(R.id.bt_Bwd);
        btFwd = (ImageButton) findViewById(R.id.bt_Fwd);

        btBwd.setOnClickListener(this);
        btFwd.setOnClickListener(this);
        setup();

        res = getResources();

    }

    private void setup() {

        imagearray.add(R.drawable.cuento1_pag1);
        imagearray.add(R.drawable.cuento1_pag2);
        imagearray.add(R.drawable.cuento1_pag3);

        if (back.getBackground()== null) back.setBackgroundResource( imagearray.get(0));

        if (track == 0 ) {
            btBwd.setEnabled(false);
            btBwd.setVisibility(View.GONE);
        }


    }

    @Override
    public void onClick (View v) {
        switch (v.getId()){
            case R.id.bt_Bwd: if(track != 0) track--;
                checkview();
                back.setBackgroundResource(imagearray.get(track));
            break;

            case R.id.bt_Fwd: if (track != imagearray.size()-1) track++;
                checkview();
                back.setBackgroundResource(imagearray.get(track));
            break;

        }
    }

    private void checkview () {
        if (track == 0) {
            btBwd.setEnabled(false);
            btBwd.setVisibility(View.GONE);
        } else {
            btBwd.setEnabled(true);
            btBwd.setVisibility(View.VISIBLE);
        }

        if (track == imagearray.size()-1) {
            btFwd.setEnabled(false);
            btFwd.setVisibility(View.GONE);
        } else {
            btFwd.setEnabled(true);
            btFwd.setVisibility(View.VISIBLE);
        }

    }


}