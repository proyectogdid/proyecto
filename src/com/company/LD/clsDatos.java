package com.company.LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.constantesBD.*;

/**
 * clase encargada de gestionar comunicacion entre LD y LN
 */
public class clsDatos {
    /**
     * atributo de conexion con la BBDD
     */
    private Connection con;


    /**
     * Metodo empleado para conectarnos con la BD
     *
     * @return
     * @throws SQLException
     */
    public void conectarBD() throws SQLException {
        //Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
        String url = "jdbc:mysql://" + DIRECCION + ":" + PUERTO + "/" + NAME + "?useTimezone=true&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";
        //Connection co = null;
        con = DriverManager.getConnection(url, USUARIO, PASS);
        //return objConn;
    }

    /**
     * Metodo para desconectarnos de la BD
     *
     * @param
     * @throws SQLException
     */
    public void desconectarBD() throws SQLException {
        con.close();
    }

    /**
     * metodo para insertar un nuevo campo
     *
     * @param nombre
     * @param ciudad
     * @param calle
     * @param numero
     * @param cp
     * @param aforo
     * @return devuelve el id que tenga en BD
     * @throws Exception
     */
    public int insertarCampo(String nombre, String ciudad, String calle, String numero, String cp, int aforo) throws Exception {
        return CampoBD.insertar(con, nombre, ciudad, calle, numero, cp, aforo);
    }

    /**
     * Metedo para buscar campos
     *
     * @return
     * @throws Exception
     */
    public ResultSet buscarCampos() throws Exception {
        return CampoBD.getAll(con);

    }

    /**
     * Método para insertar un nuevo Equipo
     *
     * @param nombre
     * @param patrocinador
     * @return
     * @throws Exception
     */
    public int insertarEquipo(String nombre, String patrocinador,int campo) throws Exception {
        return EquipoBD.insertar(con, nombre, patrocinador, campo);
    }

    /**
     * Método para buscar equipos
     *
     * @return
     * @throws Exception
     */
    public ResultSet buscarEquipo() throws Exception {
        return EquipoBD.getAll(con);
    }
}
