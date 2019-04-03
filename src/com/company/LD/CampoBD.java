package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Esta clase la utilizaremos para insertar y obtener informacion sobre los campos de la BD
 */

public class CampoBD extends Conexion {
    private static final String TEMPLATE = "cmp.id, cmp.nombre, cmp.ciudad, cmp.calle, cmp.numero, cmp.cp, cmp.cantidad";

    /**
     * Metodo para insertar informacion sobre los campos en la BD
     *
     * @param nombre nombre
     * @param ciudad ciudad
     * @param calle calle
     * @param numero numero
     * @param cp cp
     * @param aforo aforo
     * @return return
     * @throws Exception throws Exception
     */
    public static int insertar(Connection con, String nombre, String ciudad, String calle, String numero, String cp, int aforo) throws Exception {
        Object[] parametros = {nombre, ciudad, calle, numero, cp, aforo};
        return insert(con, "INSERT INTO campos(nombre,ciudad,calle,numero,cp,cantidad)VALUES(?,?,?,?,?,?)", parametros);
    }

    /**
     * Metodo para obtener informacion de los campos de la BD
     *
     * @return return
     * @throws Exception throws Exception
     */
    public static ResultSet getAll(Connection con) throws Exception {
        String query = "SELECT " + TEMPLATE + " FROM campos cmp";

        ResultSet rs = select(con, query);
        return rs;
    }

}
