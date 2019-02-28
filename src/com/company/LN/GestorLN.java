package com.company.LN;

import java.util.ArrayList;

/**
 * Clase que va a gestionar la comunicación entre el paquete LN y el paquete LP
 */
public class GestorLN {

    /**
     * Este va aser el ArrayList que va a contener los campos de los diferentes equipos
     */
    ArrayList<Campo>campos=new ArrayList<>();

    /**
     * Este método se va a utilizar para añadir los campos en el Array de los campos
     * @param id
     * @param nombre
     * @param ciudad
     * @param calle
     * @param numero
     * @param cp
     * @param aforo
     */
    public void anadirCampo(int id, String nombre, String ciudad, String calle, String numero, String cp, int aforo){

        Campo campo=new Campo( id,nombre,ciudad,calle,numero,cp,aforo);
        campos.add(campo);
    }

    /**
     * Este método lo vamos a emplear para leer los campos de los equipos
     * @return
     */
    public ArrayList<Campo>leerCampos(){
        return campos;
    }
}
