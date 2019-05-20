package com.company.LP;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que utilizaremos para crear la tabla de la ventana clasificacion
 */
public class wdwClasificacion extends JFrame implements ActionListener {
    private GestorLN gln;
    private JPanel contentPane;
    private JTable tblClasificacion;

    public wdwClasificacion(GestorLN gln_) {
        this.setTitle("Clasificacion");
        gln = gln_;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        ClasificacionModel tcm = new ClasificacionModel(gln.leerClasificacion());


        tblClasificacion = new JTable(tcm);
        tblClasificacion.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tblClasificacion.setFillsViewportHeight(true);
        tblClasificacion.setEnabled(true);
        tblClasificacion.setRowSelectionAllowed(true);
        tcm.fireTableDataChanged();
        getContentPane().add(tblClasificacion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
