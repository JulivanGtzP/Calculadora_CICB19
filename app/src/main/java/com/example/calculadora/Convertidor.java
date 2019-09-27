package com.example.calculadora;

import java.util.Stack;
import java.util.StringTokenizer;

public class Convertidor {

    private static StringTokenizer cadena;
    private static Stack<String> pila;

    public Convertidor ( StringTokenizer cad )
    {
        cadena = cad;
        pila = new Stack<>();
    }

    public StringTokenizer convertir () {
        String res, temp1;
        res = "";
        float f;
        while (cadena.hasMoreTokens()) {
            temp1 = cadena.nextToken();
            try
            {
                f = Float.valueOf( temp1 );
                if ( res.equals("") )
                    res += Float.toString( f );
                else
                    res += "#" + Float.toString( f );
            }catch( Exception e ) {
                if ( pila.empty() )
                    pila.push( temp1 );
                else{
                    switch ( pila.peek() ){//Que hay hasta arriba de la pila
                        case "+":
                            switch ( temp1 ){//Cual es el nuevo token
                                case "+":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "-":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "-":
                            switch ( temp1 ){
                                case "+":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "-":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;

                            }
                            break;
                        case "*":
                            switch ( temp1 ){
                                case "+":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "-":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "*":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "/":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "/":
                            switch ( temp1 ){
                                case "+":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "-":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "*":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "/":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "POW":
                            switch ( temp1 ){
                                case "+":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "-":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "*":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "/":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "SQRT":
                            switch ( temp1 ){
                                case "+":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "-":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "*":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case "/":
                                    res += "#" + pila.pop();
                                    pila.push( temp1 );
                                    break;
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "(":
                            pila.push( temp1 );
                            break;
                        case "SEN":
                            switch ( temp1 ){
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "COS":
                            switch ( temp1 ){
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "TAN":
                            switch ( temp1 ){
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "CTAN":
                            switch ( temp1 ){
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "SEC":
                            switch ( temp1 ){
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                        case "CSEC":
                            switch ( temp1 ){
                                case ")":
                                    temp1 = pila.pop();
                                    while ( !"(".equals(temp1) )
                                    {
                                        res += "#" + temp1;
                                        temp1 = pila.pop();
                                    }
                                    break;
                                default:
                                    pila.push( temp1 );
                                    break;
                            }
                            break;
                    }
                }
            }
        }
        while ( !pila.empty() ) {
            res += "#" + pila.pop();
        }
        StringTokenizer res1 = new StringTokenizer(res, "#");
        return res1;
    }
}