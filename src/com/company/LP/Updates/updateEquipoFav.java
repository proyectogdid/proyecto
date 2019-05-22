package com.company.LP.Updates;

import com.company.LN.GestorLN;
import com.company.LP.ventanaMenu;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.EQUIPO_ID;

public class updateEquipoFav extends JFrame implements ActionListener, WindowListener {

    private JPanel contentPane;
    private GestorLN gln;
    private JLabel Equipo;
    private JComboBox<itfProperty> cbEquipo;
    private final String BOTON_ACEPTAR_REGISTRO = "aceptarRegistro";
    private final String BOTON_CANCELAR_REGISTRO = "cancelarRegistro";

    public updateEquipoFav(GestorLN gln_) {

        this.setTitle("BASKET LIVE ⛹️");
        gln = gln_;

        ArrayList<itfProperty> equipos = gln.leerEquipos();
        cbEquipo = new JComboBox<>();
        for (int i = 0; i < equipos.size(); i++) {
            cbEquipo.addItem(equipos.get(i));
        }

        cbEquipo.setBounds(5, 5, 120, 34);


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        setBounds(100, 100, 500, 200);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("Cambia de equipo");
        menuBar.add(mntmNewMenuItem);
        contentPane = new JPanel();

        contentPane.setLayout(null);
        setContentPane(contentPane);

        Equipo = new JLabel("Equipo favorito");
        Equipo.setBounds(72, 50, 110, 14);
        contentPane.add(Equipo);

        cbEquipo = new JComboBox();
        cbEquipo.setBounds(198, 50, 212, 20);
        contentPane.add(cbEquipo);

        Button aceptar = new Button("Aceptar");
        aceptar.setBounds(198, 80, 70, 22);
        contentPane.add(aceptar);
        aceptar.setActionCommand(BOTON_ACEPTAR_REGISTRO);
        aceptar.addActionListener(this);
        aceptar.setBackground(Color.GREEN);

        Button cancelar = new Button("Cancelar");
        cancelar.setBounds(290, 80, 70, 22);
        contentPane.add(cancelar);
        cancelar.setActionCommand(BOTON_CANCELAR_REGISTRO);
        cancelar.addActionListener(this);
        cancelar.setBackground(Color.ORANGE);


        for (int i = 0; i < equipos.size(); i++) {
            cbEquipo.addItem(equipos.get(i));
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case BOTON_ACEPTAR_REGISTRO:
                System.out.println("entro aqui");
                try {
                    gln.updateUsuario((int) ((itfProperty) cbEquipo.getSelectedItem()).getProperty(EQUIPO_ID));
                    javax.swing.JOptionPane.showMessageDialog(this,"equipo actualizado con exito");
                    this.dispose();
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Fallo en la actualización");
                    ex.printStackTrace();
                }
                break;
            case BOTON_CANCELAR_REGISTRO:
                cbEquipo.setSelectedIndex(0);
                ventanaMenu m=new ventanaMenu(gln);
                m.setVisible(true);
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
