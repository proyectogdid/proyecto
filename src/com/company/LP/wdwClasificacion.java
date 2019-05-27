package com.company.LP;

import com.company.LN.GestorLN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Clase que utilizaremos para crear la tabla de la ventana clasificacion
 */
public class wdwClasificacion extends JFrame implements ActionListener, WindowListener {
    private GestorLN gln;
    private JPanel contentPane;
    private JTable tblClasificacion;
    private final String VOLVER = "volver";

    public wdwClasificacion(GestorLN gln_) {
        this.setTitle("Clasificacion");
        gln = gln_;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();

        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        ClasificacionModel tcm = new ClasificacionModel(gln.leerClasificacion());


        tblClasificacion = new JTable(tcm);
        tblClasificacion.setBounds(15, 45, 400, 200);
        // tblClasificacion.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tblClasificacion.setFillsViewportHeight(true);
        tblClasificacion.setEnabled(true);
        tblClasificacion.setRowSelectionAllowed(true);
        tcm.fireTableDataChanged();
        getContentPane().add(tblClasificacion);

        Button volver = new Button("Volver");
        volver.addActionListener(this);
        volver.setActionCommand(VOLVER);
        getContentPane().add(volver, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case VOLVER:
                ventanaMenu vm = new ventanaMenu(gln);
                vm.setVisible(true);
                this.dispose();
                break;

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        close();
    }

    private void close() {

        int eleccion = JOptionPane.showConfirmDialog(this, "¿Estás seguro?", "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);


        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
