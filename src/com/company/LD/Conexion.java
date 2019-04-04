package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;



/**
 * Clase que va gestionar la comunicacion entre la base de datos creada y necesaria con LD
 */
public abstract class Conexion {


    /**
     * metodo generico para ejecutar queries evitando el codigo repetido
     *
     * @param con, query
     * @return return
     * @throws Exception fallos en la query
     */

    public static ResultSet select(Connection con, String query) throws Exception {
        Statement stt = con.createStatement();
        System.out.println(query);
        ResultSet rs = stt.executeQuery(query);

        return rs;
    }

    /**
     * metodo generico para actualizar registros en BD
     *
     * @param con con
     * @param query query
     * @param parametros parametros
     * @return numero lineas afectadas
     * @throws Exception fallos en la query
     */

    public static int update(Connection con, String query, Object[] parametros) throws Exception {
        PreparedStatement stt = con.prepareStatement(query);
        cargarDatos(stt, parametros);
        return stt.executeUpdate();
    }

    /**
     * metodo para hacer queries con parametros
     *
     * @param query query
     * @param parametros parametros
     * @return return
     * @throws Exception fallos en la query
     */
    public static ResultSet query(Connection con, String query, Object[] parametros) throws Exception {
        PreparedStatement stt = con.prepareStatement(query);
        cargarDatos(stt, parametros);
        ResultSet rs = stt.executeQuery(query);

        return rs;
    }

    /**
     * Metodo generico para llamar a inserts ahorrando el codigo repetido
     *
     * @param con con
     * @param query      sentencia sql a ejecutar
     * @param parametros parametros
     * @return id del objeto insertado
     * @throws Exception throws Exception
     */
    public static int insert(Connection con, String query, Object[] parametros) throws Exception {
        PreparedStatement stt = con.prepareStatement(query);
        cargarDatos(stt, parametros);
        stt.execute();
        return stt.getUpdateCount();
    }

    /**
     * metodo para cargar datos dentro de un prepared statement
     * usando un array de clase object y un prepared statement para poder cargar los datos en el Prepared statement
     *
     * @param stt stt
     * @param parametros parametros
     * @throws Exception Throws Exception
     */
    private static void cargarDatos(PreparedStatement stt, Object[] parametros) throws Exception {
        for (int i = 0; i < parametros.length; i++) {
            int j = i + 1;
            if (parametros[i] instanceof String) {
                stt.setString(j, (String) parametros[i]);
            } else if (parametros[i] instanceof Integer) {
                stt.setInt(j, (Integer) parametros[i]);
            } else if (parametros[i] instanceof Double) {
                stt.setDouble(j, (Double) parametros[i]);
            }else if(parametros[i] instanceof java.util.Date){
                java.util.Date date=(java.util.Date)parametros[i];
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int month = localDate.getMonthValue();
                int day = localDate.getDayOfMonth();
                int year = localDate.getYear();
                java.sql.Date fechabd=new java.sql.Date(year,month,day);
                stt.setDate(j,fechabd);
            }
        }
    }

}
