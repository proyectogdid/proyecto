package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Esta clase la utilizaremos para insertar y obtener información sobre los equipos de la BD
 */

public class EquipoBD extends Conexion {
    private static final String TEMPLATE = "eqp.id, eqp.nombre, eqp.patrocinador, eqp.campo";

    /**
     * Método para insertar los equipos en nuestra BD
     *
     * @param con
     * @param nombre
     * @param patrocinador
     * @return
     * @throws Exception
     */
    public static int insertar(Connection con, String nombre, String patrocinador, int campo) throws Exception {

        Object[] parametros = {nombre, patrocinador, campo};
        return insert(con, "INSERT INTO equipos(nombre,patrocinador,campo)VALUES(?,?,?)", parametros);
    }

    /**
     * Metodo para obtener información de los equipos de la BD
     *
     * @return
     * @throws Exception
     */
    public static ResultSet getAll(Connection con) throws Exception {
        String query = "SELECT " + TEMPLATE + " FROM equipos eqp";
        System.out.println(query);
        ResultSet rs = select(con, query);
        return rs;
    }

}
