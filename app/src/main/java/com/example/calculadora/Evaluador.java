package com.example.calculadora;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluador {
    private static StringTokenizer cadena;
    private static Stack<Double> pila;

    public Evaluador ( StringTokenizer cad ) {
        cadena = cad;
        pila = new Stack<>();
    }

    public double evaluar () {
        String temp1;
        double d, temp, temp2;
        while ( cadena.hasMoreTokens() ) {
            temp1 = cadena.nextToken();
            System.out.println( temp1 );
            try{
                d = Double.valueOf( temp1 );
                pila.push(d);
            }catch( Exception e ) {
                switch ( temp1 )
                {
                    case "+":
                        temp = pila.pop();
                        temp2 = pila.pop() + temp;
                        pila.push(temp2);
                        break;
                    case "-":
                        temp = pila.pop();
                        temp2 = pila.pop() - temp;
                        pila.push(temp2);
                        break;
                    case "/":
                        temp = pila.pop();
                        temp2 = pila.pop() / temp;
                        pila.push(temp2);
                        break;
                    case "*":
                        temp = pila.pop();
                        temp2 = pila.pop() * temp;
                        pila.push(temp2);
                        break;
                    case "%":
                        temp = pila.pop();
                        temp2 = pila.pop();
                        temp = temp2 * (temp / 100);
                        pila.push(temp2);
                        pila.push(temp);
                        break;
                    case "POW":
                        temp = pila.pop();
                        temp2 = Math.pow( pila.pop(), temp );
                        pila.push(temp2);
                        break;
                    case "SQRT":
                        temp = Math.sqrt( pila.pop() );
                        pila.push(temp);
                        break;
                    case "SEN":
                        temp = Math.sin( Math.toRadians( pila.pop() ) );
                        pila.push(temp);
                        break;
                    case "COS":
                        temp = Math.cos( Math.toRadians( pila.pop() ) );
                        pila.push(temp);
                        break;
                    case "TAN":
                        temp = Math.tan( Math.toRadians( pila.pop() ) );
                        pila.push(temp);
                        break;
                    case "CTAN":
                        temp2 = pila.pop();
                        temp = Math.cos( Math.toRadians( temp2 ) ) / Math.sin( Math.toRadians( temp2 ) );
                        pila.push(temp);
                        break;
                    case "SEC":
                        temp = 1 / Math.cos( Math.toRadians( pila.pop() ) );
                        pila.push(temp);
                        break;
                    case "CSEC":
                        temp = 1 / Math.sin( Math.toRadians( pila.pop() ) );
                        pila.push(temp);
                        break;
                }
            }
        }
        return pila.pop();
    }
}
