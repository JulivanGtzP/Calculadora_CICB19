package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewPantalla;
    private boolean punto;
    private boolean equal;
    private String resultado;
    private String res;
    private StringTokenizer cadena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textViewPantalla = this.findViewById(R.id.textView);
        punto = false;
        equal = false;
        res = "";
        resultado = "";
    }

    public void onClick(View v)
    {

    }

    public void onClickDigito(View v) {
        Button buttonDigito = (Button)v;

        if ( equal ) {
            textViewPantalla.setText("0.0");
            equal = false;
        }
        if ( !(textViewPantalla.getText().toString().equals("0.0")) ) {
            if ( buttonDigito.getText().toString().equals(".") ){
                if ( !punto ) {
                    resultado = textViewPantalla.getText().toString() + buttonDigito.getText().toString();
                    punto = true;
                }
            }
            else{
                resultado = textViewPantalla.getText().toString() + buttonDigito.getText().toString();
            }
        }
        else {
            if ( buttonDigito.getText().toString().equals(".") ){
                if ( !punto ) {
                    resultado = buttonDigito.getText().toString();
                    punto = true;
                }
            }
            else{
                resultado = buttonDigito.getText().toString();
            }
        }
        textViewPantalla.setText(resultado);
    }

    public void onClickC(View v) {
        resultado = "";
        textViewPantalla.setText("0.0");
    }

    public void onClickMM(View v) {
        if ( resultado.charAt(0) != '-' )
            resultado = "-" + resultado;
        else
            resultado = resultado.substring( 1, resultado.length() );
        textViewPantalla.setText(resultado);
    }

    public void onClickOperadores(View v) {
        Button buttonOperador = (Button)v;
        textViewPantalla.setText("0.0");
        if ( res.equals("") )
            res = resultado + "#" + buttonOperador.getText().toString();
        else
            res = res + "#" + resultado + "#" + buttonOperador.getText().toString();
        resultado = "";
        punto = false;
    }

    public void onClickEqual(View v)
    {
        res = res + "#" + resultado;
        cadena = new StringTokenizer( res, "#" );
        Convertidor c;
        c = new Convertidor ( cadena );
        cadena = c.convertir();
        Evaluador e;
        e = new Evaluador ( cadena );
        textViewPantalla.setText( Double.toString( e.evaluar() ) );
        res = "";
        resultado = "";
        punto = false;
        equal = true;
    }
}