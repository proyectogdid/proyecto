package com.company.LP;

import com.company.Excepciones.EquiposInsuficientesException;
import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        try {
            gln.cargarDatos();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error al cargar datos");
            e.printStackTrace();
        }


        int op = 0;
        do {
            System.out.println("Elija:");
            System.out.println("1.-Introducir campo");
            System.out.println("2.-Ver campo");
            System.out.println("3.-Introducir equipo");
            System.out.println("4.-Ver Equipo");
            System.out.println("5.-ALta jugador");
            System.out.println("6.-Ver jugaodes");
            System.out.println("7.-calendario");
            System.out.println("8.-Salir");
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
                case 5:
                    altaJugador(gln);
                    break;
                case 6:
                    visualizarJugador(gln.leerJugadores());
                    break;
                case 7:
                    try {
                        altaTemporada(gln);

                    } catch (EquiposInsuficientesException e) {
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Introduzca una opción válida");
                    break;


            }

        } while (op != 8);


    }


    public static void altaTemporada(GestorLN gln) throws Exception, EquiposInsuficientesException {
        gln.anadirTemporada();
    }

    /**
     * metodo para recoger los datos de campo y añadirlos en gestorln
     *
     * @param gln gln
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
     * @param campos campos
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

    /**
     * Metodo para dar de alta los diferentes equipos de la liga
     *
     * @param gln gln
     */
    public static void altaEquipo(GestorLN gln) {


        try {
            wdwEquipo v=new wdwEquipo(gln);
            v.setVisible(true);
            String nombre;
            String patrocinador;
            int idcampo;

            System.out.println("Nombre:");
            nombre = clsUtilidades.leerCadena();

            System.out.println("Patrocinador:");
            patrocinador = clsUtilidades.leerCadena();

            System.out.println("campo:");
            idcampo = clsUtilidades.leerEntero();

            gln.anadirEquipo(nombre, patrocinador, idcampo);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * metodo que lista los equipos almacenados en memoria de gestorln
     *
     * @param equipos equipos
     */

    public static void visualizarEquipo(ArrayList<itfProperty> equipos) {

        for (itfProperty a : equipos) {

            System.out.println("ID:" + a.getProperty(EQUIPO_ID));
            System.out.println("Nombre:" + a.getProperty(EQUIPO_NOMBRE));
            System.out.println("Patrocinador:" + a.getProperty(EQUIPO_PATROCINADOR));

            System.out.println();

        }
    }

    /**
     * Metodo para dar de alta los partidos de la liga
     *
     * @param gln gln
     */
    public static void altaJugador(GestorLN gln) {
        try {

        	wdwJugador v=new wdwJugador(gln);
        	v.setVisible(true);
            String nombre;
            String apellido1;
            String apellido2;
            String dorsal;
            String textoCamiseta;
            String fechaNac;
            int idequipo;
            int idposicion;
            int idestado;


            System.out.println("Nombre:");
            nombre = clsUtilidades.leerCadena();

            System.out.println("Primer apellido:");
            apellido1 = clsUtilidades.leerCadena();

            System.out.println("Segundo apellido:");
            apellido2 = clsUtilidades.leerCadena();

            System.out.println("Fecha de nacimiento:(dd/MM/yyyy)");
            fechaNac = clsUtilidades.leerCadena();
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);
            System.out.println("Dorsal:");
            dorsal = clsUtilidades.leerCadena();

            System.out.println("Texto de la camiseta:");
            textoCamiseta = clsUtilidades.leerCadena();

            System.out.println("Equipo:");
            idequipo = clsUtilidades.leerEntero();

            System.out.println("Posicion:");
            idposicion = clsUtilidades.leerEntero();

            System.out.println("Estado:");
            idestado = clsUtilidades.leerEntero();

            gln.anadirJugador(nombre, apellido1, apellido2, fecha, dorsal, textoCamiseta, idequipo, idposicion, idestado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que lista los jugadores en memoria de gestorln
     *
     * @param jugadores jugadores
     */
    public static void visualizarJugador(ArrayList<itfProperty> jugadores) {

        for (itfProperty a : jugadores) {

            System.out.println("ID:" + a.getProperty(JUGADOR_ID));
            System.out.println("Nombre:" + a.getProperty(JUGADOR_NOMBRE));
            System.out.println("Primer apellido:" + a.getProperty(JUGADOR_APELLIDO1));
            System.out.println("Segundo apellido:" + a.getProperty(JUGADOR_APELLIDO2));
            System.out.println("Fecha de nacimiento:" + a.getProperty(JUGADOR_FECHA_NACIMIENTO));
            System.out.println("Dorsal:" + a.getProperty(JUGADOR_DORSAL));
            System.out.println("Texto de la camiseta:" + a.getProperty(JUGADOR_TEXTO_CAMISETA));

            System.out.println();

        }
    }


}

