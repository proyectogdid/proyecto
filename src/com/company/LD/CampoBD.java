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
    public static int insertar(String nombre,String ciudad,String calle,String numero,String cp, int aforo ) throws Exception{
        Connection con =conectarBD();
        PreparedStatement sentencia=con.prepareStatement("INSERT INTO campos(nombre,ciudad,calle,numero,cp,cantidad)VALUES(?,?,?,?,?,?)");
        sentencia.setString(1,nombre);
        sentencia.setString(2,ciudad);
        sentencia.setString(3,calle);
        sentencia.setString(4,numero);
        sentencia.setString(5,cp);
        sentencia.setInt(6,aforo);
        sentencia.execute();
        int retorno=sentencia.getUpdateCount();
        desconectarBD(con);
        return  retorno;
    }

    /**
     * Metodo para obtener información de los campos de la BD
     * @return
     * @throws Exception
     */
    public static ArrayList<Campo> getAll()throws Exception{
        Connection con=conectarBD();
        Statement stt=con.createStatement();
        ResultSet rs=stt.executeQuery("SELECT * FROM campos");

        ArrayList<Campo> retorno=new ArrayList<>();
        while (rs.next()){
      
            Campo c =new Campo();

            c.setId(rs.getInt("id"));
            c.setNombre(rs.getString("nombre"));
            c.setCiudad(rs.getString("ciudad"));
            c.setCalle(rs.getString("calle"));
            c.setNumero(rs.getString("numero"));
            c.setCp(rs.getString("cp"));
            c.setAforo(rs.getInt("cantidad"));

            retorno.add(c);
        }
        desconectarBD(con);
        return retorno;
    }

}
