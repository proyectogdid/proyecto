package com.company.comun;

import java.sql.ResultSet;

/**
 * interfaz para clases que vamos a almacenar en Base de Datos,
 * una funcion para leer resultSets
 */
public interface itfPersistable {
    void resultsetLoad(ResultSet rs) throws Exception;
}
