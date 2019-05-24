package com.company.LP.InsertarPorVentanas;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que utilizaremos para insertar las posiciones en la BD
 */
public class wdwPosicion extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel nombre;
    private JTextField textoNombre;
    private GestorLN gln;
    private final String BOTON_ACEPTAR = "aceptar";
    private final String BOTON_CANCELAR = "cancelar";

    /**
     * Create the frame
     * @param gln_ gln_
     */
    public wdwPosicion(GestorLN gln_) {
        gln = gln_;
        this.setTitle("Inserte una posición");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 628, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        nombre = new JLabel("Nombre");
        nombre.setBounds(72, 50, 60, 14);
        contentPane.add(nombre);

        textoNombre = new JTextField();
        textoNombre.setBounds(198, 47, 212, 20);
        contentPane.add(textoNombre);
        textoNombre.setColumns(10);

        Button aceptar = new Button("Aceptar");
        aceptar.setBounds(399, 100, 70, 22);
        aceptar.addActionListener(this);
        aceptar.setActionCommand(BOTON_ACEPTAR);
        contentPane.add(aceptar);
        aceptar.setBackground(Color.GREEN);

        Button cancelar = new Button("Cancelar");
        cancelar.setBounds(480, 100, 70, 22);
        cancelar.addActionListener(this);
        cancelar.setActionCommand(BOTON_CANCELAR);
        contentPane.add(cancelar);
        cancelar.setBackground(Color.ORANGE);

    }

    /**
     * Metodo para realizar acciones en funcion del evento
     *
     * @param e e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case BOTON_ACEPTAR:
                try {
                    gln.anadirPosicion(textoNombre.getText());
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Fallo en la inserción de la posición");
                }
                break;
            case BOTON_CANCELAR:
                textoNombre.setText("");
                this.dispose();
                break;
        }

    }
}

