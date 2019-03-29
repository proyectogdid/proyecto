package com.company.LP;

import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import java.util.ArrayList;

import static com.company.comun.clsConstantes.*;

/**
 * Clase que gestionara la interaccion con el usuario
 */
public class Menu {

    /**
     * punto de entrada de la aplicacion
     */
    public static void menu() {
        GestorLN gln = new GestorLN();
        gln.cargarDatosCampos();
        gln.cargarDatosEquipos();
        int op = 0;
        do {
            System.out.println("Eliga:");
            System.out.println("1.-Introducir campo");
            System.out.println("2.-Ver campo");
            System.out.println("3.-Introducir equipo");
            System.out.println("4.-Ver Equipo");
            System.out.println("5.-Salir");
            op = clsUtilidades.leerEntero();

            switch (op) {

                case 1:
                    altaCampo(gln);
                    break;
                case 2:
                    visualizarCampo(gln.leerCampos());
                    break;
                case 3:
                    altaEquipo(gln);
                    break;
                case 4:
                    visualizarEquipo(gln.leerEquipos());
                    break;
                default:
                    System.out.println("Introduzca una opción válida");
                    break;


            }

        } while (op != 5);



    }

    /**
     * metodo para recoger los datos de campo y añadirlos en gestorln
     *
     * @param gln
     */
    public static void altaCampo(GestorLN gln) {
        String nombre;
        String ciudad;
        String calle;
        String numero;
        String cp;
        int aforo;


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


        gln.anadirCampo(nombre, ciudad, calle, numero, cp, aforo);


    }

    /**
     * metodo que lista los campos almacenados en memoria de gestorln
     *
     * @param campos
     */

    public static void visualizarCampo(ArrayList<itfProperty> campos) {

        for (itfProperty a : campos) {

            System.out.println("ID:" + a.getProperty(CAMPO_ID));
            System.out.println("Nombre:" + a.getProperty(CAMPO_NOMBRE));
            System.out.println("Ciudad:" + a.getProperty(CAMPO_CIUDAD));
            System.out.println("Calle:" + a.getProperty(CAMPO_CALLE));
            System.out.println("Numero:" + a.getProperty(CAMPO_NUMERO));
            System.out.println("CP:" + a.getProperty(CAMPO_CP));
            System.out.println("Aforo:" + a.getProperty(CAMPO_AFORO));
            System.out.println();

        }
    }

    public static void altaEquipo(GestorLN gln) {
        String nombre;
        String patrocinador;


        System.out.println("Nombre:");
        nombre = clsUtilidades.leerCadena();

        System.out.println("Patrocinador:");
        patrocinador=clsUtilidades.leerCadena();


        gln.anadirEquipo(nombre, patrocinador);


    }

    /**
     * metodo que lista los equipos almacenados en memoria de gestorln
     *
     * @param equipos
     */

    public static void visualizarEquipo(ArrayList<itfProperty> equipos) {

        for (itfProperty a : equipos) {

            System.out.println("Nombre:" + a.getProperty(EQUIPO_NOMBRE));
            System.out.println("Patrocinador:" + a.getProperty(EQUIPO_PATROCINADOR));

            System.out.println();

        }
    }
}

