package com.company.LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.company.LD.constantesBD.DIRECCION;
import static com.company.LD.constantesBD.PUERTO;
import static com.company.LD.constantesBD.NAME;
import static com.company.LD.constantesBD.USUARIO;
import static com.company.LD.constantesBD.PASS;


/**
 * Clase que va gestionar la comunicación entre la base de datos creada y necesaria con LD
 */
public abstract class Conexion {

    public static Connection conectarBD() throws SQLException {
        //Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
        String url="jdbc:mysql://" + DIRECCION + ":" + PUERTO + "/" + NAME + "?useTimezone=true&serverTimezone=GMT&useSSL=false";
        Connection objConn = null;
        objConn = DriverManager.getConnection (url, USUARIO, PASS);
        return objConn;
    }

	public static void desconectarBD(Connection conexion)throws SQLException {
        	conexion.close();
	}

}
