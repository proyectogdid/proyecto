package com.company.LP;

import com.company.LN.GestorLN;

/**
 * Clase que gestionara la interaccion con el usuario
 */
public class Menu {
    private static GestorLN gln;

    /**
     * punto de entrada de la aplicacion
     */
    public static void menu() {
        gln = new GestorLN();


        try {
            gln.cargarDatos();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error al cargar datos");
            e.printStackTrace();
        }
        ventanaComienzoApk c = new ventanaComienzoApk(gln);
        c.setVisible(true);


    }
}
