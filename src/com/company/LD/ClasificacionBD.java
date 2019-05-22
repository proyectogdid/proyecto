package com.company.LD;



import java.sql.Connection;
import java.sql.ResultSet;

public class ClasificacionBD extends Conexion {

    /**
     * metodo para contar en la base de datos cuantos partidos han ganado, perdido  y empatado
     * @param con
     * @return
     * @throws Exception
     */
    public static ResultSet cargarClasificacion(Connection con)throws Exception{

        String query="select e.nombre,\n" +
                "(select count(*) from partidos where ptosLocal>ptosVisitante and local = e.id or ptosLocal<ptosVisitante and visitante = e.id) as victorias , \n" +
                "(select count(*) from partidos where ptosLocal<ptosVisitante and local = e.id or ptosLocal>ptosVisitante and visitante = e.id) as derrotas,\n" +
                "(select count(*) from partidos where ptosLocal=ptosVisitante and local = e.id or ptosLocal=ptosVisitante and visitante = e.id) as empates\n" +
                "from partidos , equipos e\n" +
                "where (local=e.id\n" +
                "or visitante=e.id)\n" +
                "and e.id=e.id\n" +
                "group by e.id";
        return select(con,query);
    }
}
