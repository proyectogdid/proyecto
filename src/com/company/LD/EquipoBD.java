package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Esta clase la utilizaremos para insertar y obtener información sobre los equipos de la BD
 */

public class EquipoBD extends Conexion {
    private static final String template = "cmp.id, cmp.nombre, cmp.patrocinador";

    /**
     * Método para insertar los equipos en nuestra BD
     *
     * @param con
     * @param nombre
     * @param patrocinador
     * @return
     * @throws Exception
     */
    public static int insertar(Connection con, String nombre, String patrocinador) throws Exception {
        /*PreparedStatement sentencia=con.prepareStatement("INSERT INTO equipos (nombre,patrocinador)VALUES(?,?)");
        sentencia.setString(1,nombre);
        sentencia.setString(2,patrocinador);
        sentencia.execute();
        int retorno=sentencia.getUpdateCount();
        return  retorno;*/
        Object[] parametros = {nombre, patrocinador};
        return insert(con, "INSERT INTO equipos(nombre,patrocinador)VALUES(?,?)", parametros);
    }

    /**
     * Metodo para obtener información de los equipos de la BD
     *
     * @return
     * @throws Exception
     */
    public static ResultSet getAll(Connection con) throws Exception {
        String query = "SELECT " + template + " FROM equipos cmp";
        System.out.println(query);
        ResultSet rs = select(con, query);
        return rs;
    }

}
