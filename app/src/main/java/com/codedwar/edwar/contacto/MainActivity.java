package com.codedwar.edwar.contacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnSiguiente;
    private EditText etNombre;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    private DatePicker dpFecha;
    private int dia,mes,year;
    private int bandera = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle parametros = getIntent().getExtras();

        try {
            bandera = parametros.getInt("Bandera");
        }catch (Exception e){
            bandera = 0;
        }

        btnSiguiente  = (Button)findViewById(R.id.btnSiguiente);

        etNombre      = (EditText)findViewById(R.id.etNombre);
        etTelefono    = (EditText)findViewById(R.id.etTelefono);
        etEmail       = (EditText)findViewById(R.id.etEmail);
        etDescripcion = (EditText)findViewById(R.id.etDescripcion);

        dpFecha = (DatePicker)findViewById(R.id.dpFecha);

        dia = dpFecha.getDayOfMonth();
        mes = dpFecha.getMonth() + 1;
        year = dpFecha.getYear();

        if(bandera == 1) {
            String nombre = parametros.getString("Nombre1");
            String telefono = parametros.getString("Telefono1");
            String email = parametros.getString("Email1");
            String descripcion = parametros.getString("Descripcion1");
            etNombre.setText(nombre);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
            bandera = 0;
        }




        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bandera = 1;
                Intent i = new Intent(MainActivity.this, InformacionContacto.class);
                i.putExtra("Nombre",etNombre.getText().toString());
                i.putExtra("Dia",dia);
                i.putExtra("Mes",mes);
                i.putExtra("Year",year);
                i.putExtra("Telefono",etTelefono.getText().toString());
                i.putExtra("Email",etEmail.getText().toString());
                i.putExtra("Descripcion",etDescripcion.getText().toString());
                startActivity(i);
                finish();
            }
        });
    }
}
