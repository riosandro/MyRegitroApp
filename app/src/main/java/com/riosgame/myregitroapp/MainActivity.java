package com.riosgame.myregitroapp;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePicker.OnDateChangedListener {
    private static final String BARRA = "/";
    // private static final String CERO = "0";
    public final Calendar c = Calendar.getInstance();
    // final int mes = c.get(Calendar.MONTH);
    // final int dia = c.get(Calendar.DAY_OF_MONTH);
    //final int anio = c.get(Calendar.YEAR);

    TextInputEditText etFecha;
    // ImageButton ibObtenerFecha;
    TextInputEditText nombrec;
    TextInputEditText telefonoc;
    TextInputEditText emailc;
    TextInputEditText detallesc;
    Button btsiguiente;
    Button borrar;
    DatePicker fechadenaci;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btsiguiente    = (Button) findViewById(R.id.Bsiguiente);
        nombrec        = (TextInputEditText) findViewById(R.id.tie_nombres);
        telefonoc      = (TextInputEditText) findViewById(R.id.ttelefono);
        emailc         = (TextInputEditText) findViewById(R.id.email);
        detallesc      = (TextInputEditText) findViewById(R.id.detalles);
        // nombrec        = (EditText) findViewById(R.id.tnombre);
        etFecha        = (TextInputEditText) findViewById(R.id.tie_fecha);
        // ibObtenerFecha = (ImageButton) findViewById(R.id.ib_obtener_fecha);
        borrar         = (Button) findViewById(R.id.Borrar);
        fechadenaci    = (DatePicker) findViewById(R.id.dp_nacimiento);
        fechadenaci.setOnDateChangedListener(this);
        borrar.setOnClickListener(this);
        // ibObtenerFecha.setOnClickListener(this);
        btsiguiente.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Bsiguiente:
                siguienteAtivity();
                break;
            case R.id.Borrar:
                BotonBorrar();
                break;
        }
    }

    private void siguienteAtivity() {
        // String fecha = etFecha.getText().toString();
        Intent x = new Intent(MainActivity.this, Confirmacion.class);
        x.putExtra("fecha", etFecha.getText().toString());
        x.putExtra("nombreco",nombrec.getText().toString());
        x.putExtra("telefonoco",telefonoc.getText().toString());
        x.putExtra("emailco",emailc.getText().toString());
        x.putExtra("detallesco",detallesc.getText().toString());
        startActivity(x);
        // finishAffinity();

    }
    private void BotonBorrar() {
        etFecha.setText("");//para mi conocimiento, si dejo las comillas con espacion al precionar el boton borrar me bora todo incluyendo el hint text.
        nombrec.setText("");
        telefonoc.setText("");
        emailc.setText("");
        detallesc.setText("");
    }

    @Override
    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
        int mes = fechadenaci.getMonth();
        int day = fechadenaci.getDayOfMonth();
        int year = fechadenaci.getYear();

        etFecha .setText((mes+1) + BARRA + day + BARRA + year);


    }
}
