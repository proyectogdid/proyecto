package com.company.LP;

import com.company.LP.clsUtilidades;
import com.company.LN.Campo;
import com.company.LN.GestorLN;

import java.util.ArrayList;

/**
 * Clase que gestionara la interaccion con el usuario
 */
public class Menu {

    /**
     * punto de entrada de la aplicacion
     */
    public static void menu() {
        GestorLN gln = new GestorLN();
        int op = 0;
        do {
            System.out.println("Eliga:");
            System.out.println("1.-Introducir campo");
            System.out.println("2.-Ver campo");
            System.out.println("3.-Salir");
            op = clsUtilidades.leerEntero();

            switch (op) {

                case 1:
                    altaCampo(gln);
                    break;
                case 2:
                    visualizarCampo(gln.leerCampos());
                    break;
                default:
                    break;


            }

        } while (op != 3);

    }

    /**
     * metodo para recoger los datos de campo y añadirlos en gestorln
     * @param gln
     */
    public static void altaCampo(GestorLN gln) {
        String nombre;
        String ciudad;
        int id;
        String calle;
        String numero;
        String cp;
        int aforo;





        System.out.println("Identificador:");
        id = clsUtilidades.leerEntero();

        System.out.println("Nombre:");
        nombre = clsUtilidades.leerCadena();

        System.out.println("Ciudad:");
        ciudad = clsUtilidades.leerCadena();

        System.out.println("Calle:");
        calle = clsUtilidades.leerCadena();

        System.out.println("Numero:");
        numero = clsUtilidades.leerCadena();

        System.out.println("CP");
        cp = clsUtilidades.leerCadena();

        System.out.println("Aforo:");
        aforo = clsUtilidades.leerEntero();


        gln.anadirCampo(id, nombre, ciudad, calle, numero, cp, aforo);


    }

    /**
     * metodo que lista los campos almacenados en memoria de gestorln
     * @param campos
     */

    public static void visualizarCampo(ArrayList<Campo> campos) {

        for (Campo a : campos) {

            System.out.println("ID:" + a.getId());
            System.out.println("Nombre:" + a.getNombre());
            System.out.println("Ciudad:" + a.getCiudad());
            System.out.println("Calle:" + a.getCalle());
            System.out.println("Numero:" + a.getNumero());
            System.out.println("CP:" + a.getCp());
            System.out.println("Aforo:" + a.getAforo());
            System.out.println();

        }
    }
}

