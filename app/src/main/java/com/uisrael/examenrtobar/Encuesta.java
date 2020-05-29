package com.uisrael.examenrtobar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Encuesta extends AppCompatActivity {
    TextView tvbien;
    EditText etcentro;
    RadioButton rb1, rb2;
    CheckBox ck1, ck2, ck3;
    //Bundle usuario, cuota, nombre;
    String usuario;
    String cuota ;
    String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        tvbien = findViewById(R.id.tvbienr);
        etcentro = findViewById(R.id.etcentro);
        ck1 = findViewById(R.id.ck1);
        ck2 = findViewById(R.id.ck2);
        ck3 = findViewById(R.id.ck3);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);

         usuario = getIntent().getStringExtra("usuarioenvidao");
         cuota = getIntent().getStringExtra("cuotaenviada");
         nombre = getIntent().getStringExtra("nombreenviado");
         tvbien.setText(usuario);
    }

    public void Impresion(View v){
        String cont="a";
        Intent intentEnviar1 = new Intent(Encuesta.this,Resumen.class);
        if(etcentro.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Si opinión",Toast.LENGTH_LONG).show();
        }else{
            intentEnviar1.putExtra("opinionenviada", etcentro.getText().toString());
        }

        //startActivity(intentEnviar1);
        cont = "Usted practica los siguientes deportes: \n";

        if(ck1.isChecked()==false && ck2.isChecked()==false && ck3.isChecked()==false){
            Toast.makeText(getApplicationContext(),"Sin Seleccion en los CB",Toast.LENGTH_LONG).show();

        }else {
            if(ck1.isChecked()==true && ck2.isChecked()==true && ck3.isChecked()==true){
                cont = cont + ck1.getText().toString() + " "  +ck2.getText().toString() + " "  +ck3.getText().toString() + "\n";
            }else{
                if(ck1.isChecked()==true && ck2.isChecked()==true){
                    cont = cont + ck1.getText().toString() + " "  +ck2.getText().toString()+ "\n";
                }else{
                    if(ck1.isChecked()==true && ck3.isChecked()==true){
                        cont = cont + ck1.getText().toString() + " " +ck3.getText().toString()+ "\n";
                    }else{
                        if(ck2.isChecked()==true && ck3.isChecked()==true){
                            cont = cont +ck2.getText().toString() + " "  +ck3.getText().toString()+ "\n";
                        }else{
                            if(ck1.isChecked()==true){
                                cont = cont + ck1.getText().toString() + "\n";
                            }else{
                                if(ck2.isChecked()==true){
                                    cont = cont +  ck2.getText().toString()+ "\n" ;
                                }else{
                                    cont = cont + ck3.getText().toString()+ "\n";
                                }
                            }
                        }
                    }
                }
            }




        }

        if(rb1.isChecked()==false && rb2.isChecked()==false){
            Toast.makeText(getApplicationContext(),"Sin Seleccion en los RB",Toast.LENGTH_LONG).show();
        }
        else{
            cont = cont + "\n" + "Y  ";
            if(rb1.isChecked()==true){
                cont = "\n" + cont + "" +rb1.getText().toString();
            }else{
                cont = "\n" +  cont + "" +rb2.getText().toString();
            }
        }
        cont = cont + " esta interesado en aprender otro idioma";

        intentEnviar1.putExtra("cuotaenviada", cuota);
        intentEnviar1.putExtra("nombreenviado", nombre);
        intentEnviar1.putExtra("usuarioenvidao", tvbien.getText().toString());

        intentEnviar1.putExtra("datenv1",cont);
        startActivity(intentEnviar1);

    }
}
