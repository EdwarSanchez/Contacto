package com.codedwar.edwar.contacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InformacionContacto extends AppCompatActivity {

    private Button btnEditar;
    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_contacto);
        Bundle parametros = getIntent().getExtras();
        btnEditar = (Button)findViewById(R.id.btnEditar);

        String nombre = parametros.getString("Nombre");
        int dia = parametros.getInt("Dia");
        int mes = parametros.getInt("Mes");
        int year = parametros.getInt("Year");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String descripcion = parametros.getString("Descripcion");

        final String fecha = ""+dia+"/ "+mes+"/ "+year;


        tvNombre      = (TextView)findViewById(R.id.tvNombre);
        tvFecha       = (TextView)findViewById(R.id.tvFecha);
        tvTelefono    = (TextView)findViewById(R.id.tvTelefono);
        tvEmail       = (TextView)findViewById(R.id.tvEmail);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);




        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InformacionContacto.this, MainActivity.class);
                i.putExtra("Nombre1",tvNombre.getText().toString());
                i.putExtra("Fecha1",tvFecha.getText().toString());
                i.putExtra("Telefono1",tvTelefono.getText().toString());
                i.putExtra("Email1",tvEmail.getText().toString());
                i.putExtra("Descripcion1",tvDescripcion.getText().toString());
                i.putExtra("Bandera",1);
                startActivity(i);
                finish();
            }
        });



    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent i = new Intent(InformacionContacto.this, MainActivity.class);
            startActivity(i);
        }
        return super.onKeyDown(keyCode,event);

    }



}
