package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Esta clase se utilizara para hacer multiInserts y obtener informacion sobre los partidos de la BD
 */

public class PartidoBD extends Conexion {

    public static final String TEMPLATE = "par.id,par.fecha,par.ptosLocal,par.ptosVisitante,par.local,par.visitante,par.jornada ";

    /**
     * metodo para recuperar los distintos partidos de la temporada
     *
     * @param con conexion de BD
     * @return result set de datos
     * @throws Exception cualquier fallo que pueda tener la select
     */
    public static ResultSet getAll(Connection con) throws Exception {
        return select(con, "SELECT " + TEMPLATE + " FROM partidos par order by par.jornada");
    }

    /**
     * Metodo para insertar los partidos del ArrayLisst
     *
     * @param con   con
     * @param datos datos
     * @return return
     * @throws Exception cualquier fallo que pueda haber en la multiInsert
     */
    public static ArrayList<Integer> insertarPartidos(Connection con, Object[][] datos) throws Exception {
        return multiInsert(con, "INSERT INTO partidos  (local,visitante,fecha,temporada,campo,jornada) VALUES ", datos);
    }
}

