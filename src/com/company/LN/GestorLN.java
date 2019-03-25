package com.company.LN;

import com.company.LD.clsDatos;
import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static com.company.comun.clsConstantes.*;

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
    public ArrayList<itfProperty> leerCampos() {
        System.out.println("entro aqui");
        ArrayList<itfProperty> retorno=new ArrayList<>();
        try {

            for (Campo c:campos) {
                retorno.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public void cargarDatos(){
        try{
            ResultSet rs =objDatos.buscarCampos();
            while(rs.next()){

                Campo c =new Campo();
                c.resultSetToCampo(rs);
                campos.add(c);
            }
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,"error al cargar los datos");
            e.printStackTrace();
        }

    }

}