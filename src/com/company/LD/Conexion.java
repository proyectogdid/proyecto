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
     * Metodo empleado para conectarnos con la BD
     * @return
     * @throws SQLException
     */
    public static Connection conectarBD() throws SQLException {
        //Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
        String url="jdbc:mysql://" + DIRECCION + ":" + PUERTO + "/" + NAME + "?useTimezone=true&serverTimezone=GMT&useSSL=false&AllowPublicKeyRetrieval=true";
        Connection objConn = null;
        objConn = DriverManager.getConnection (url, USUARIO, PASS);
        return objConn;
    }

    /**
     * Metodo para desconectarnos de la BD
     * @param conexion
     * @throws SQLException
     */
	public static void desconectarBD(Connection conexion)throws SQLException {
        	conexion.close();
	}

    /**
     * metodo generico para ejecutar queries evitando el codigo repetido
     * @param query
     * @return
     * @throws Exception
     */

	public static ResultSet select(String query) throws Exception{
        Connection con=conectarBD();
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
    public static ResultSet query(String query, Object[] parametros)throws Exception{
        Connection con=conectarBD();
        PreparedStatement stt=con.prepareStatement(query);
        cargarDatos(stt,parametros);
        ResultSet rs=stt.executeQuery(query);

        return  rs;
    }

    /**
     * metodo para cargar datos dentro de un prepared statement
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
