package com.company.LD;

import java.sql.*;

import static com.company.LD.constantesBD.DIRECCION;
import static com.company.LD.constantesBD.PUERTO;
import static com.company.LD.constantesBD.NAME;
import static com.company.LD.constantesBD.USUARIO;
import static com.company.LD.constantesBD.PASS;


/**
 * Clase que va gestionar la comunicación entre la base de datos creada y necesaria con LD
 */
public abstract class Conexion {


    /**
     * metodo generico para ejecutar queries evitando el codigo repetido
     * @param con, query
     * @return
     * @throws Exception
     */

	public static ResultSet select(Connection con, String query) throws Exception{
        Statement stt=con.createStatement();
        ResultSet rs=stt.executeQuery(query);

        return rs;
    }

    /**
     * metodo para hacer queries con parametros
     * @param query
     * @param parametros
     * @return
     * @throws Exception
     */
    public static ResultSet query(Connection con,String query, Object[] parametros)throws Exception{
        PreparedStatement stt=con.prepareStatement(query);
        cargarDatos(stt,parametros);
        ResultSet rs=stt.executeQuery(query);

        return  rs;
    }

    /**
     * Metodo generico para llamar a inserts ahorrando el codigo repetido
     * @param con
     * @param query sentencia sql a ejecutar
     * @param parametros
     * @return id del objeto insertado
     * @throws Exception
     */
    public static int insert(Connection con, String query, Object[] parametros)throws Exception{
        PreparedStatement stt=con.prepareStatement(query);
        cargarDatos(stt,parametros);
        stt.execute();
        return stt.getUpdateCount();
    }

    /**
     * metodo para cargar datos dentro de un prepared statement
     * usando un array de clase object y un prepared statement para poder cargar los datos en el Prepared statement
     * @param stt
     * @param parametros
     * @throws Exception
     */
    private static void cargarDatos(PreparedStatement stt, Object[]parametros)throws Exception{
        for (int i=0;i<parametros.length;i++) {
            int j=i+1;
            if (parametros[i] instanceof String) {
                stt.setString(j, (String) parametros[i]);
            } else if (parametros[i] instanceof Integer) {
                stt.setInt(j, (Integer) parametros[i]);
            } else if(parametros[i] instanceof Double){
                stt.setDouble(j,(Double) parametros[i]);
            }
        }
    }

}
