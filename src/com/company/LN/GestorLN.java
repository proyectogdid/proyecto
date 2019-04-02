package com.company.LN;

import com.company.LD.clsDatos;
import com.company.comun.itfProperty;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que va a gestionar la comunicacion entre el paquete LN y el paquete LP
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
     * Este va a ser el ArrayList que va a contener los estados en los que pueda estar un jugador
     */
    ArrayList<Estado> estados = new ArrayList<>();

    /**
     * comunicacion con capa de datos en LN
     */
    private clsDatos objDatos = new clsDatos();

    /**
     * Este metodo se va a utilizar para añadir los campos en el Array de los campos
     *
     * @param nombre nombre
     * @param ciudad ciudad
     * @param calle calle
     * @param numero numero
     * @param cp cp
     * @param aforo aforo
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
     * Este metodo lo vamos a emplear para leer los campos de los equipos
     *
     * @return return
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

    /**
     * Metodo para cargar los datos de los campos de la BD
     */
    public void cargarDatosCampos() throws Exception {
            ResultSet rs = objDatos.buscarCampos();
            while (rs.next()) {
                Campo c = new Campo();
                c.resultsetLoad(rs);
                campos.add(c);
            }

    }

    /**
     * Metodo para añadir equipos a la BD
     *
     * @param nombre nombre
     * @param patrocinador patrocinador
     * @param campo campo
     */
    public void anadirEquipo(String nombre, String patrocinador, int campo) {
        try {
            objDatos.conectarBD();
            Equipo equipo = new Equipo(nombre, patrocinador);
            equipos.add(equipo);
            equipo.setId(objDatos.insertarEquipo(nombre, patrocinador, campo));
            objDatos.desconectarBD();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Este metodo lo vamos a emplear para leer los equipos
     *
     * @return return
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

    /**
     * Metodo para cargar los datos de los quipos previamente introducidos a la BD
     */
    public void cargarDatosEquipos() throws Exception {

            ResultSet rs = objDatos.buscarEquipo();
            while (rs.next()) {

                Equipo e = new Equipo();
                e.resultSetToEquipo(rs);
                equipos.add(e);
            }
    }
    public void cargarDatosEstados() throws Exception{
        ResultSet rs=objDatos.buscarEstados();
        while (rs.next()){
            Estado e=new Estado();
            e.resultsetLoad(rs);
            estados.add(e);
        }
    }

    public void cargarDatos() throws Exception{
        objDatos.conectarBD();
        cargarDatosCampos();
        cargarDatosEquipos();
        cargarDatosEstados();
        objDatos.desconectarBD();
    }
}