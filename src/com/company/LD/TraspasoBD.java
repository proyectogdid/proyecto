package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

public class TraspasoBD extends Conexion{
    public static final String TEMPLATE="tra.id, tra.precio, tra.jugador, tra.equipoPrevio, tra.equipoPosterior";

    /**
     * metodo para recuperar los ditintas traspasos de la temporada
     * @param con conexion de BD
     * @return result set de datos
     * @throws Exception cualquier fallo que pueda tener la select
     */
    public static ResultSet getAll(Connection con)throws Exception{
        return select(con, "SELECT "+TEMPLATE+" FROM traspasos tra");
    }


}
