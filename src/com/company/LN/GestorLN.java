package com.company.LN;

import com.company.LD.clsDatos;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que va a gestionar la comunicación entre el paquete LN y el paquete LP
 */
public class GestorLN {

    /**
     * Este va aser el ArrayList que va a contener los campos de los diferentes equipos
     */
    ArrayList<Campo> campos = new ArrayList<>();
    /**
     * comunicacion con capa de datos en LN
     */
    private clsDatos objDatos = new clsDatos();

    /**
     * Este método se va a utilizar para añadir los campos en el Array de los campos
     *
     * @param nombre
     * @param ciudad
     * @param calle
     * @param numero
     * @param cp
     * @param aforo
     */
    public void anadirCampo(String nombre, String ciudad, String calle, String numero, String cp, int aforo) {
        try {
            Campo campo = new Campo(nombre, ciudad, calle, numero, cp, aforo);
            campos.add(campo);
            campo.setId(objDatos.insertarCampo(nombre, ciudad, calle, numero, cp, aforo));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(campos);

    }


    /**
     * Este método lo vamos a emplear para leer los campos de los equipos
     *
     * @return
     */
    public ArrayList<Campo> leerCampos() {
        try {
            campos = objDatos.buscarCampos();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return campos;
    }

}