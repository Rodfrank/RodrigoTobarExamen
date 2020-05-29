package com.uisrael.examenrtobar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    TextView tvbienv, tvnombre, tvcuota, tvopinion, tvencuest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        tvbienv = findViewById(R.id.tvbienr);
        tvnombre = findViewById(R.id.etnombre);
        tvcuota = findViewById(R.id.etcuota);
        tvopinion = findViewById(R.id.edopinion);
        tvencuest = findViewById(R.id.edchrb);
        String usuario = getIntent().getStringExtra("usuarioenvidao");
        String cuota = getIntent().getStringExtra("cuotaenviada");
        String nombre = getIntent().getStringExtra("nombreenviado");
        String encuesta = getIntent().getStringExtra("datenv1");
        String opinion = getIntent().getStringExtra("opinionenviada");

        tvbienv.setText(usuario);
        tvnombre.setText(nombre);
        tvcuota.setText(cuota);
        tvopinion.setText(opinion);
        tvencuest.setText(encuesta);
    }
}
