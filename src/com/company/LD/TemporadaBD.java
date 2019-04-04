package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

public class TemporadaBD extends Conexion {
    public static final String TEMPLATE="tem.id,tem.ano";

    /**
     * metodo para recuperar la temporada
     * @param con conexion de BD
     * @return result set de datos
     * @throws Exception cualquier fallo que pueda tener la select
     */
    public static ResultSet getAll(Connection con)throws Exception{
        return select(con, "SELECT "+TEMPLATE+" FROM temporadas tem");
    }


}
