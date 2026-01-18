package com.politecnicomalaga.jugadores;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    //Hay que poner las variables en private

    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String DNI;
    private String Email;
    private String Tfno;
    private int dorsal;
    private EditText et;
    private Boolean portero;
    private TextView tv;
    private CheckBox cb;
    //Constructor



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    //funciones o metodos

    Jugador [] equipo = new Jugador[6];
    public void altaJugador(View v){

        Jugador nuevo;
        boolean termine=false;

        et = (EditText) findViewById(R.id.etNombre);
        Nombre = et.getText().toString();
        et = (EditText) findViewById(R.id.etApellido1);
        Apellido1 = et.getText().toString();
        et = (EditText) findViewById(R.id.etApellido2);
        Apellido2 = et.getText().toString();
        et =(EditText) findViewById(R.id.etDNI);
        DNI = et.getText().toString();
        et = (EditText)findViewById(R.id.etEmail);
        Email = et.getText().toString();
        et = (EditText)findViewById(R.id.etTelefono);
        Tfno = et.getText().toString();
        et = (EditText) findViewById(R.id.etDorsal);
        dorsal = Integer.parseInt(et.getText().toString());
        cb = ( CheckBox) findViewById(R.id.checkBox);
        portero = cb.isChecked();
        tv = (TextView) findViewById(R.id.tvResultadoDaralta);


        nuevo = new Jugador(Nombre,Apellido1,Apellido2,DNI,Email,Tfno,dorsal);

        if (portero == true){
            if (equipo[0]==null){
                equipo[0] = nuevo;
                tv.setText("Portero nuevo asignado");
            } else {
                tv.setText("Oh oh, ya hay un portero");
            }
        }else{
            //insertar en hueco
            for (int i =1;i<equipo.length && !termine;i++){
                if (equipo[i]==null){
                    equipo[i]=nuevo;
                    tv.setText("Equipo nuevo asignado");
                    termine=true;
                }
            }
            if (!termine) tv.setText("Equipo lleno");
        }
    }
    public void BajaJugador(View v) {
        int eliminado;
        et = (EditText) findViewById(R.id.etPosicion);
        tv = (TextView) findViewById(R.id.tvResultadoDarBaja);
        eliminado = Integer.parseInt(et.getText().toString());

       do{


            if (eliminado<0||eliminado>=equipo.length){
                tv.setText("¡Vaya! esa posición no es válida, introduce una dentro del rango");
            } else{
                equipo[eliminado]=null;
                tv.setText("Jugador eliminado");
            }
        }while (eliminado<0||eliminado>=equipo.length);

    }
    public void Mostrar (View v){
        tv = (TextView) findViewById(R.id.tvResultadoMostrar);
        String resultado = "";
        for (int i =0;i<equipo.length;i++){
            if (equipo[i]!=null){
                resultado += equipo[i].toString() + "\n";
            }
        }
        tv.setText(resultado);

    }


}