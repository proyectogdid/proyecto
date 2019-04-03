package com.company.LD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

/**
 * Esta clase la utilizaremos para insertar y obtener informacion de los partidos de la BD
 */
public class JugadoresBD extends Conexion{

    private static final String TEMPLATE= "jug.id,jug.nombre,jug.apellido1,jug.apellido2,jug.fechaNac,jug.dorsal,jug.textoCamiseta";

    /**
     * MEtodo para insertar jugadores a nuestra BD
     * @param con con
     * @param nombre nombre
     * @param apellido1 apellido1
     * @param apellido2 apellido2
     * @param fechaNac fechaNac
     * @param dorsal dorsal
     * @param textoCamiseta textoCamiseta
     * @param equipo
     * @param estado
     * @param posicion
     * @return retur
     * @throws Exception throws Exception
     */
    public static int insertar(Connection con, String nombre, String apellido1, String apellido2, Date fechaNac, String dorsal, String textoCamiseta, int equipo, int estado, int posicion) throws Exception {

        Object[] parametros = {nombre,apellido1,apellido2,fechaNac,dorsal,textoCamiseta};
        return insert(con, "INSERT INTO partidos(nombre,apellido1,apellido2,fechaNac,dorsal,textoCamiseta)VALUES(?,?,?,?,?,?)", parametros);
    }

    /**
     * Metodo para obtener informcacion de los jugadores de la BD
     * @param con con
     * @return return
     * @throws Exception throws Exception
     */
    public static ResultSet getAll(Connection con) throws Exception {
        String query = "SELECT" + TEMPLATE +"FROM jugadores jug";
        System.out.println(query);
        ResultSet rs= select(con,query);
        return rs;
    }
}
