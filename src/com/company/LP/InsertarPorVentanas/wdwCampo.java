package com.company.LP.InsertarPorVentanas;

import com.company.LN.GestorLN;
import com.company.LP.ventanaMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para crear la ventana para insertar los daots de los campos
 */

public class wdwCampo extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JLabel nombre;
    private JTextField textoNombre;
    private JTextField textoCiudad;
    private JTextField textoCalle;
    private JTextField textoNumero;
    private JTextField textoCP;
    private JTextField textoCapacidad;
    private JLabel ciudad;
    private JLabel calle;
    private JLabel numero;
    private JLabel cp;
    private JLabel capacidad;
    private GestorLN gln;
    private final String BOTON_ACEPTAR = "aceptar";
    private final String BOTON_CANCELAR = "cancelar";


    /**
     * Create the frame.
     */
    public wdwCampo(GestorLN gln_) {

        gln = gln_;

        this.setTitle("Inserte un campo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 628, 440);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setResizable(false);

        nombre = new JLabel("Nombre");
        nombre.setBounds(72, 50, 60, 14);
        contentPane.add(nombre);

        ciudad = new JLabel("Ciudad");
        ciudad.setBounds(72, 99, 100, 14);
        contentPane.add(ciudad);

        calle = new JLabel("Calle");
        calle.setBounds(72, 147, 120, 14);
        contentPane.add(calle);

        numero = new JLabel("Número");
        numero.setBounds(72, 190, 130, 14);
        contentPane.add(numero);

        cp = new JLabel("CP");
        cp.setBounds(72, 232, 70, 14);
        contentPane.add(cp);

        capacidad = new JLabel("Capacidad");
        capacidad.setBounds(72, 271, 110, 14);
        contentPane.add(capacidad);

        textoNombre = new JTextField();
        textoNombre.setBounds(198, 47, 212, 20);
        contentPane.add(textoNombre);
        textoNombre.setColumns(10);

        textoCiudad = new JTextField();
        textoCiudad.setBounds(198, 99, 212, 20);
        contentPane.add(textoCiudad);
        textoCiudad.setColumns(10);

        textoCalle = new JTextField();
        textoCalle.setBounds(198, 147, 212, 20);
        contentPane.add(textoCalle);
        textoCalle.setColumns(10);

        textoNumero = new JTextField();
        textoNumero.setBounds(198, 190, 212, 20);
        contentPane.add(textoNumero);
        textoNumero.setColumns(10);

        textoCP = new JTextField();
        textoCP.setBounds(198, 232, 212, 20);
        contentPane.add(textoCP);
        textoCP.setColumns(10);

        textoCapacidad = new JTextField();
        textoCapacidad.setBounds(198, 271, 212, 20);
        contentPane.add(textoCapacidad);
        textoCapacidad.setColumns(10);

        Button aceptar = new Button("Aceptar");
        aceptar.setBounds(399, 330, 70, 22);
        aceptar.addActionListener(this);
        aceptar.setActionCommand(BOTON_ACEPTAR);
        contentPane.add(aceptar);
        aceptar.setBackground(Color.GREEN);

        Button cancelar = new Button("Cancelar");
        cancelar.setBounds(480, 330, 70, 22);
        cancelar.addActionListener(this);
        cancelar.setActionCommand(BOTON_CANCELAR);
        contentPane.add(cancelar);
        cancelar.setBackground(Color.ORANGE);


    }

    /**
     * Metodo para realizar las acciones de los eventos de la ventana
     *
     * @param e e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case BOTON_ACEPTAR:
                gln.anadirCampo(textoNombre.getText(), textoCiudad.getText(), textoCalle.getText(), textoNumero.getText(), textoCP.getText()
                        , Integer.parseInt(textoCapacidad.getText()));
                break;
            case BOTON_CANCELAR:
                textoNombre.setText("");
                textoCiudad.setText("");
                textoCalle.setText("");
                textoNumero.setText("");
                textoCP.setText("");
                ventanaMenu vm=new ventanaMenu(gln);
                vm.setVisible(true);
                this.dispose();
                break;


        }

    }
}
