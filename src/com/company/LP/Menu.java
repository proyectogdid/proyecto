package com.company.LP;

import com.company.LN.Campo;
import com.company.LN.GestorLN;

import java.util.ArrayList;

public class Menu {
    private static GestorLN gln = new GestorLN();

    public static void menu() {
        int op = 0;
        do {
            System.out.println("Eliga:");
            System.out.println("1.-Introducir campo");
            System.out.println("2.-Ver campo");

            op = LP.clsUtilidades.leerEntero();

            switch (op) {

                case 1:
                    altaCampo();
                    break;
                case 2:
                    visualizarCampo(gln.leerCampos());
                    break;
                default:
                    break;


            }

        } while (op != 3);

    }


    public static void altaCampo() {
        String nombre;
        String ciudad;
        int id;
        String calle;
        String numero;
        String cp;
        int aforo;

        GestorLN objGestor;
        Campo objCampo;


        System.out.println("Identificador:");
        id = LP.clsUtilidades.leerEntero();

        System.out.println("Nombre:");
        nombre = LP.clsUtilidades.leerCadena();

        System.out.println("Ciudad:");
        ciudad = LP.clsUtilidades.leerCadena();

        System.out.println("Calle:");
        calle = LP.clsUtilidades.leerCadena();

        System.out.println("Numero:");
        numero = LP.clsUtilidades.leerCadena();

        System.out.println("CP");
        cp = LP.clsUtilidades.leerCadena();

        System.out.println("Aforo:");
        aforo = LP.clsUtilidades.leerEntero();


        gln.anadirCampo(id, nombre, ciudad, calle, numero, cp, aforo);


    }

    public static void visualizarCampo(ArrayList<Campo> campos) {

        for (Campo a : campos) {

            System.out.println("ID:" + a.getId());
            System.out.println("Año:" + a.getNombre());
            System.out.println("Titulo:" + a.getCiudad());
            System.out.println("Calle:" + a.getCalle());
            System.out.println("Numero:" + a.getNumero());
            System.out.println("CP:" + a.getCp());
            System.out.println("Aforo" + a.getAforo());
            System.out.println();

        }
    }
}

