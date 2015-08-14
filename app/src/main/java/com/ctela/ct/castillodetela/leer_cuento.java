package com.ctela.ct.castillodetela;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.List;


/**
 * Created by Sebastian on 10/6/2014.
 */
public class leer_cuento extends Activity implements View.OnClickListener {


    ImageButton btFwd;
    ImageButton btBwd;
    ImageButton btBck;
    RelativeLayout back;
    ArrayList<Integer> imagearray = new ArrayList<Integer>();
    Resources res;
    int track = 0;
    boolean flag=false;
    String idCuento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
        setContentView(R.layout.leercuento_layout);

        back = (RelativeLayout) findViewById(R.id.back);

        btBck = (ImageButton) findViewById(R.id.bt_Bck);
        btBwd = (ImageButton) findViewById(R.id.bt_Bwd);
        btFwd = (ImageButton) findViewById(R.id.bt_Fwd);

        btBwd.setOnClickListener(this);
        btFwd.setOnClickListener(this);
        btBck.setOnClickListener(this);
        
        res = getResources();


        setup();



    }

    private void setup() {

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idCuento = extras.getString("idCuento");

        }
        //Toast.makeText(this, String.valueOf(idCuento), Toast.LENGTH_LONG).show();
        Field[] fields = R.drawable.class.getFields();
        int id;
        for ( Field field : fields) {
            //corre segun las imagenes que empiesan con el nombre del cuento.
            if (field.getName().startsWith("cuento"+idCuento+"_pag")) {
                id = res.getIdentifier(field.getName(), "drawable", getPackageName());
                imagearray.add(id);
            }
        }

        //Toast.makeText(this, String.valueOf( imagearray), Toast.LENGTH_LONG).show();
        if (back.getBackground()== null) back.setBackgroundResource( imagearray.get(0));

        if (track == 0 ) {
            btBwd.setEnabled(false);
            btBwd.setVisibility(View.GONE);
        }


    }

    @Override // elije  que hacer cuando se apreta click en la pantalla de lectura de cuentos. segun que se apreta hace algo.. agrega el boton para volver aca " super.finish()
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

            case R.id.bt_Bck:
                finish();
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