package com.company.LD;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;


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
     * @param con        con
     * @param query      query
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
     * @param query      query
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
     * @param con        con
     * @param query      sentencia sql a ejecutar
     * @param parametros parametros
     * @return id del objeto insertado
     * @throws Exception throws Exception
     */
    public static int insert(Connection con, String query, Object[] parametros) throws Exception {
        PreparedStatement stt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        cargarDatos(stt, parametros);
        stt.execute();

        ResultSet rs = stt.getGeneratedKeys();
        return (rs.next()) ? rs.getInt(1) : -1;
    }

    /**
     * metodo para hacer una insert de multiples filas
     *
     * @param con    connexion de BD
     * @param query  insert "insert {template} into values"
     * @param params matriz de parametros
     * @return Array de PK
     * @throws Exception Sql exception
     */

    public static ArrayList<Integer> multiInsert(Connection con, String query, Object[][] params) throws Exception {

        int filas = params.length;
        int columnas = params[0].length;
        for (int j = 0; j < filas; j++) {


            String txt = "(";
            for (int i = 0; i < columnas; i++) {
                txt += (i < columnas - 1) ? "?," : "?";
            }
            txt += (j < filas - 1) ? ")," : ")";

            query += txt;
        }


        System.out.println(query);


        PreparedStatement stt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        cargarMultiDatos(stt, params);
        //query builder
        //for
        //cargarDatos(stt, params);
        stt.execute();
        ResultSet rs = stt.getGeneratedKeys();
        ArrayList<Integer> claves = new ArrayList<>();
        while (rs.next()) {
            claves.add(rs.getInt(1));
        }
        return claves;
    }

    /**
     * metodo para cargar datos dentro de un prepared statement multifilas
     * usando una matriz de clase object y un prepared statement para poder cargar los datos en el Prepared statement
     *
     * @param stt        stt
     * @param parametros parametros
     * @throws Exception Throws Exception
     */
    private static void cargarDatos(PreparedStatement stt, Object[] parametros) throws Exception {
        for (int i = 0; i < parametros.length; i++) {
            int j = i + 1;
            setData(stt,parametros[i],j);
        }
    }


    /**
     * metodo para cargar datos dentro de un prepared statement
     * usando un array de clase object y un prepared statement para poder cargar los datos en el Prepared statement
     *
     * @param stt        stt
     * @param parametros parametros
     * @throws Exception Throws Exception
     */
    private static void cargarMultiDatos(PreparedStatement stt, Object[][] parametros) throws Exception {
        int n = 1;
        for (int k = 0; k < parametros.length; k++) {

            for (int i = 0; i < parametros[k].length; i++) {
                setData(stt,parametros[k][i],n);
                n++;
            }
        }
        //    System.out.println(n);
    }

    private static void setData(PreparedStatement stt, Object obj, int index) throws SQLException {
        if (obj instanceof String) {
            stt.setString(index, (String)obj);
        } else if (obj instanceof Integer) {
            stt.setInt(index, (Integer) obj);
        } else if (obj instanceof Double) {
            stt.setDouble(index, (Double) obj);
        } else if (obj instanceof java.util.Date) {
            java.util.Date date = (java.util.Date) obj;


            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            int year = localDate.getYear();
            java.sql.Date fechabd = new java.sql.Date(date.getTime());
            stt.setDate(index, fechabd);
            //                  System.out.println(fechabd);
        }
    }

}
