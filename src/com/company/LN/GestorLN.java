package com.company.LN;

import com.company.LD.clsDatos;
import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que va a gestionar la comunicación entre el paquete LN y el paquete LP
 */
public class GestorLN {

    /**
     * Este va a ser el ArrayList que va a contener los campos de los diferentes equipos
     */
    ArrayList<Campo> campos = new ArrayList<>();
    /**
     * Este va a ser el ArrayList que va a contener los participantes de la liga
     */
    ArrayList<Equipo> equipos = new ArrayList<>();
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
            objDatos.conectarBD();
            Campo campo = new Campo(nombre, ciudad, calle, numero, cp, aforo);
            campos.add(campo);
            campo.setId(objDatos.insertarCampo(nombre, ciudad, calle, numero, cp, aforo));
            objDatos.desconectarBD();
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
        ArrayList<itfProperty> retorno = new ArrayList<>();
        try {

            for (Campo c : campos) {
                retorno.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public void cargarDatosCampos() {
        try {
            objDatos.conectarBD();
            ResultSet rs = objDatos.buscarCampos();
            while (rs.next()) {

                Campo c = new Campo();
                c.resultSetToCampo(rs);
                campos.add(c);
            }

            objDatos.desconectarBD();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error al cargar los datos");
            e.printStackTrace();
        }

    }

    public void anadirEquipo(String nombre, String patrocinador) {
        try {
            objDatos.conectarBD();
            Equipo equipo = new Equipo(nombre, patrocinador);
            equipos.add(equipo);
            equipo.setId(objDatos.insertarEquipo(nombre, patrocinador));
            objDatos.desconectarBD();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Este método lo vamos a emplear para leer los equipos
     *
     * @return
     */
    public ArrayList<itfProperty> leerEquipos() {
        System.out.println("entro aqui");
        ArrayList<itfProperty> retorno = new ArrayList<>();
        try {

            for (Equipo e : equipos) {
                retorno.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public void cargarDatosEquipos() {
        try {
            objDatos.conectarBD();
            ResultSet rs = objDatos.buscarEquipo();
            while (rs.next()) {

                Equipo e = new Equipo();
                e.resultSetToEquipo(rs);
                equipos.add(e);
            }

            objDatos.desconectarBD();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error al cargar los datos");
            e.printStackTrace();
        }


    }
}