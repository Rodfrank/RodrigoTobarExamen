package com.uisrael.examenrtobar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1 = findViewById(R.id.edusu);
        et2 = findViewById(R.id.edpass);
    }

    public void verificar(View v){
        if(et1.getText().toString().equals("estudiante2020") && et2.getText().toString().equals("uisrael2020")){
            Intent intentEnviar = new Intent(Login.this,Registro.class);
            intentEnviar.putExtra("usuarioenviado",et1.getText().toString());
            startActivity(intentEnviar);
        }else{
            Toast.makeText(getApplicationContext(), "Error en datos, intentelo nuevamente", Toast.LENGTH_LONG).show();
        }

    }
}
