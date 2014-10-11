package com.ctela.ct.castillodetela;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * Created by Seba on 24-09-2014.
 */
public class menu_principal extends Activity {


    ListView lvCuentos;
    String[] cuentos= { "La niña mas linda", " El Zorro y los Piñones", "La Pincoya", "The Number 4"};
    //crear array para identificar nombre de imagenes de cuentos para pantalla de lectura
    Integer[] imageId = {R.drawable.portadacuento1, R.drawable.portadacuento2, R.drawable.portadacuento3, R.drawable.portadacuento4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);




        CustomList adapter = new CustomList(menu_principal.this, cuentos, imageId);
        lvCuentos=(ListView) findViewById(R.id.lvCuentos);
        lvCuentos.setAdapter(adapter);
        lvCuentos.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(menu_principal.this,"You Clicked at "+cuentos[+ position] , Toast.LENGTH_SHORT).show();
                leerCuento(view);
            }
        });

    }




    public void leerCuento(View v) {
        Intent leer= new Intent (this, leer_cuento.class);
        startActivity(leer);
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
