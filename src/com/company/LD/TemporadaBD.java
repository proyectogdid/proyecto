package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Clase para insertar y obtener informacion sobre la temporada de la BD
 */
public class TemporadaBD extends Conexion {
    public static final String TEMPLATE = "tem.id,tem.ano";

    /**
     * metodo para recuperar la temporada
     *
     * @param con conexion de BD
     * @return result set de datos
     * @throws Exception cualquier fallo que pueda tener la select
     */
    public static ResultSet getAll(Connection con) throws Exception {
        return select(con, "SELECT " + TEMPLATE + " FROM temporadas tem");
    }

    /**
     * metodo de BD para insertar temporda
     *
     * @param con  objcon
     * @param anio fecha de la temporada
     * @return id
     * @throws Exception SQL exception
     */

    public static int insertTemporada(Connection con, Date anio) throws Exception {
        Object[] datos = {anio};
        return insert(con, "INSERT INTO temporadas (ano) VALUES(?)", datos);
    }


}
