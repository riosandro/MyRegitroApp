package com.riosgame.myregitroapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {
    TextView nombrem;
    TextView fecham;
    TextView telefonom;
    TextView emailm;
    TextView detallesm;
    Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        fecham = (TextView) findViewById(R.id.fechac);
        nombrem = (TextView) findViewById(R.id.nombrecomple);
        telefonom = (TextView) findViewById(R.id.tvtelefono);
        emailm = (TextView) findViewById(R.id.tvemail);
        detallesm = (TextView) findViewById(R.id.tvdetalles);
        editar = (Button) findViewById(R.id.Bteditardeta);

        Bundle parametros = getIntent().getExtras();
        String fechita = parametros.getString("fecha");
        String nombcomp = parametros.getString("nombreco");
        String telefocomp = parametros.getString("telefonoco");
        String emailcomp = parametros.getString("emailco");
        String detallescomp = parametros.getString("detallesco");

        String a = nombrem.getResources().getString(R.string.TNombre);
        nombrem.setText(a+" "+nombcomp);
        String b = telefonom.getResources().getString(R.string.TTelefono);
        telefonom.setText(b+" "+ telefocomp);
        String c = fecham.getResources().getString(R.string.TFecha);
        fecham.setText(c+" "+ fechita);
        String d = emailm.getResources().getString(R.string.TEmail);
        emailm.setText(d+" "+ emailcomp);
        String e = detallesm.getResources().getString(R.string.TDetalles);
        // int color = detallesm.getResources().getColor(R.color.colorPrimaryDark);
        //  detallesm.setTextColor(color);
        detallesm.setText(e+" "+ detallescomp);

        editar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                //Intent editar = new Intent(Confirmacion.this,LoginActivity.class); si avilito este inten no me da la fuides de ida y vuelta
                // en las activities
                // startActivity(editar);
                finish();
            }

        });

    }
}
