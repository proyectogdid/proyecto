package com.company.comun;

/**
 * interfaz que implemenetaremos en las clases de ln para poder acceder a los atributos desde lp
 */
public interface itfProperty {
    /**
     * metodo get property por el que accederemos a los atributos de las clases que implementen esta itf
     * @param prop prop
     * @return object
     */
    Object getProperty(String prop);
}
