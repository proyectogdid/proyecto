package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

public class PartidoBD extends Conexion{

        public static final String TEMPLATE="par.id,par.fecha,par.ptosLocal,par.ptosVisitante";

        /**
         * metodo para recuperar los distintos partidos de la temporada
         * @param con conexion de BD
         * @return result set de datos
         * @throws Exception cualquier fallo que pueda tener la select
         */
        public static ResultSet getAll(Connection con)throws Exception{
            return select(con, "SELECT "+TEMPLATE+" FROM partidos par");
        }
    }

