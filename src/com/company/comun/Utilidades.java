package com.company.comun;

/**
 * Clase que utilizaremos para poder generar el calendario en el Gestor de LN
 */
public class Utilidades {
    public static int factorial(int numero) {
        if (numero > 0) {
            return numero * factorial(numero - 1);
        } else {
            return 1;
        }
    }
}
