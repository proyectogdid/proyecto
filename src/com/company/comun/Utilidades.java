package com.company.comun;

public class Utilidades {
    public static int factorial(int numero){
        if(numero>0){
            return numero*factorial(numero-1);
        }else{
            return 1;
        }
    }
}
