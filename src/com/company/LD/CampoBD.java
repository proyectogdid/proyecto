package com.company.LD;

import com.company.LN.Campo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CampoBD extends Conexion{
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
        desconectarBD(con);
        return  sentencia.getUpdateCount();
    }
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
