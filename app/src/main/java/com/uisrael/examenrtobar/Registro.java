package com.uisrael.examenrtobar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    TextView tvbien;
    EditText et1, et2, et3;
    Bundle usuariologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        et1 = findViewById(R.id.etnom);
        et2 = findViewById(R.id.etmontoin);
        et3 = findViewById(R.id.etcuota);
        tvbien = findViewById(R.id.etbien);

        usuariologin = getIntent().getExtras();
        String usuariobn = usuariologin.getString("usuarioenviado");
        tvbien.setText("Usuario conectado: "+usuariobn);
    }

    public void calcular(View v){
        Double montoini,cuota;
        if(et2.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Ingrese el monto inicial", Toast.LENGTH_LONG).show();
        }else{
            montoini = Double.parseDouble(et2.getText().toString());
            cuota = (1800-montoini)/3 * 0.05 + (1800-montoini)/3;
            et3.setText(cuota.toString());
        }

    }

    public void Encuesta(View v){
        if(et3.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Necesita calcular la cuota", Toast.LENGTH_LONG).show();
        }else {
            Intent intentEnviar = new Intent(Registro.this, Encuesta.class);
            intentEnviar.putExtra("cuotaenviada", et3.getText().toString());
            intentEnviar.putExtra("nombreenviado", et1.getText().toString());
            intentEnviar.putExtra("usuarioenvidao", tvbien.getText().toString());
            startActivity(intentEnviar);
        }
    }
}
