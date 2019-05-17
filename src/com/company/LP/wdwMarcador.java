package com.company.LP;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que utilizaremos para visualizar el marcador de un partido
 */
public class wdwMarcador extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField ptosEquipo1;
    private JTextField ptosEquipo2;
    private JLabel lblNewLabel_1;
    private GestorLN gln;


    /**
     * Create the frame.
     */
    public wdwMarcador(GestorLN gln_) {
        gln = gln_;
        this.setTitle("MARCADOR");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 628, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Ptos.'Equipo1'");
        lblNewLabel.setBounds(72, 50, 60, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Ptos.'Equipo2'");
        lblNewLabel_1.setBounds(120, 50, 100, 14);
        contentPane.add(lblNewLabel_1);

        ptosEquipo1 = new JTextField();
        ptosEquipo1.setBounds(72, 70, 86, 20);
        contentPane.add(ptosEquipo1);
        ptosEquipo1.setColumns(10);

        ptosEquipo2 = new JTextField();
        ptosEquipo2.setBounds(120, 70, 86, 20);
        contentPane.add(ptosEquipo2);
        ptosEquipo2.setColumns(10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

