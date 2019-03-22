package com.company.LD;

import com.company.LN.Campo;

import java.util.ArrayList;

/**
 * clase encargada de gestionar comunicacion entre LD y LN
 */
public class clsDatos {

    /**
     * metodo para insertar un nuevo campo
     * @param nombre
     * @param ciudad
     * @param calle
     * @param numero
     * @param cp
     * @param aforo
     * @return devuelve el id que tenga en BD
     * @throws Exception
     */
    public int insertarCampo(String nombre,String ciudad,String calle,String numero,String cp, int aforo)throws Exception {
        return CampoBD.insertar(nombre, ciudad, calle, numero, cp, aforo);
    }
    public ArrayList<Campo>buscarCampos()throws Exception{
        return CampoBD.getAll();
    }
}
