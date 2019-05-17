package com.company.LP.InsertarPorVentanas;

import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.CAMPO_ID;

public class wdwPosicion extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField textoNombre;
    private GestorLN gln;




    public wdwPosicion(GestorLN gln_) {
        gln=gln_;
        this.setTitle("Inserte una posición");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 628, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setBounds(72, 50, 60, 14);
        contentPane.add(lblNewLabel);

        textoNombre = new JTextField();
        textoNombre.setBounds(198, 47, 212, 20);
        contentPane.add(textoNombre);
        textoNombre.setColumns(10);

        Button aceptar = new Button("Aceptar");
        aceptar.setBounds(399, 214, 70, 22);
        aceptar.addActionListener(this);
        aceptar.setActionCommand("1");
        contentPane.add(aceptar);

        Button cancelar = new Button("Cancelar");
        cancelar.setBounds(480, 214, 70, 22);
        cancelar.addActionListener(this);
        cancelar.setActionCommand("0");
        contentPane.add(cancelar);

    }

    /**
     * Metodo para realizar acciones en funcion del evento
     * @param e e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "1":
                try {
                    gln.anadirPosicion(textoNombre.getText());
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Fallo en la inserción de la posición");
                }
                break;
            case "0":
                break;
        }

    }
}

