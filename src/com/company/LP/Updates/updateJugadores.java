package com.company.LP.Updates;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que utilizaremos los admin para actualizar los jugadores de la BD
 */
public class updateJugadores extends JFrame implements ActionListener {

    private GestorLN gln;
    private JPanel contentPane;
    private JTextField textField;
    private JList<String> list;
    private final String BORRAR="borrar";
    private final String SALIR ="salir";

    private DefaultListModel<String> modelo = new DefaultListModel<String>();

    public updateJugadores(GestorLN gln_) {

        this.setTitle("Actualizar Jugadorr️");
        gln = gln_;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(238, 48, 161, 202);
        contentPane.add(scrollPane);

        scrollPane.setViewportView(list);


        textField = new JTextField();
        textField.setBounds(56, 47, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton borrar = new JButton("Borrar");
        borrar.setActionCommand(BORRAR);
        borrar.addActionListener(this);
        borrar.setBounds(53, 124, 89, 23);
        contentPane.add(borrar);


        JButton salir = new JButton("Salir");
        salir.setActionCommand(SALIR);
        salir.addActionListener(this);
        salir.setBounds(53, 227, 89, 23);
        contentPane.add(salir);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case BORRAR:
                int posicion = list.getSelectedIndex();
                modelo.remove(posicion);
                break;
            case SALIR:
                System.exit(0);
                break;
        }
    }
}

