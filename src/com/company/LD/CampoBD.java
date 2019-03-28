package com.company.LD;

import com.company.LN.Campo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Esta clase la utilizaremos para insertar y obtener información sobre los campos de la BD
 */

public class CampoBD extends Conexion{
    private static final String template="cmp.id, cmp.nombre, cmp.ciudad, cmp.calle, cmp.numero, cmp.cp, cmp.cantidad";
    /**
     * Metodo para insertar información sobre los campos en la BD
     * @param nombre
     * @param ciudad
     * @param calle
     * @param numero
     * @param cp
     * @param aforo
     * @return
     * @throws Exception
     */
    public static int insertar(Connection con,String nombre,String ciudad,String calle,String numero,String cp, int aforo ) throws Exception{
        /*PreparedStatement sentencia=con.prepareStatement("INSERT INTO campos(nombre,ciudad,calle,numero,cp,cantidad)VALUES(?,?,?,?,?,?)");
        sentencia.setString(1,nombre);
        sentencia.setString(2,ciudad);
        sentencia.setString(3,calle);
        sentencia.setString(4,numero);
        sentencia.setString(5,cp);
        sentencia.setInt(6,aforo);
        sentencia.execute();
        int retorno=sentencia.getUpdateCount();
        return  retorno;*/
        Object[] parametros={nombre,ciudad,calle,numero,cp,aforo};
        return insert(con,"INSERT INTO campos(nombre,ciudad,calle,numero,cp,cantidad)VALUES(?,?,?,?,?,?)",parametros);
    }

    /**
     * Metodo para obtener información de los campos de la BD
     * @return
     * @throws Exception
     */
    public static ResultSet getAll(Connection con)throws Exception{
        String query="SELECT "+template+" FROM campos cmp";
        System.out.println(query);
        ResultSet rs =select(con,query);
        return rs;
    }

}
