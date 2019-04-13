package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * clase que va a gestionar la situacion de cada jugador de la BD
 */
public class EventoBD extends Conexion{

    public static final String TEMPLATE="eve.id,eve.estadoPrevio,eve.estadoPosterior,eve.jugador";

    /**
     * metodo para recuperar los eventos
     * @param con conexion de BD
     * @return result set de datos
     * @throws Exception cualquier fallo que pueda tener la select
     */
    public static ResultSet getAll(Connection con)throws Exception{
        return select(con, "SELECT "+TEMPLATE+" FROM eventos eve");
    }

}
