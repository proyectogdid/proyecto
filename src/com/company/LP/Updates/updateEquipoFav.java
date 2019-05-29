package com.company.LP.Updates;

import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.AFICIONADO_FAVORITO;
import static com.company.comun.clsConstantes.EQUIPO_ID;

/**
 * Clase que utilizaremos para actualizar el Equipo favorito del usuario
 */
public class updateEquipoFav extends JFrame implements ActionListener, WindowListener {

    private JPanel contentPane;
    private GestorLN gln;
    private JLabel Equipo;
    private JComboBox<itfProperty> cbEquipo;
    private final String ACEPTAR = "aceptarRegistro";
    private final String CANCELAR = "cancelarRegistro";

    /**
     * Create the frame
     * @param gln_ gln_
     */
    public updateEquipoFav(GestorLN gln_) {

        this.setTitle("BASKET LIVE ⛹️");
        gln = gln_;
        int idequipofav=(int)gln.getEquipoFav().getProperty(EQUIPO_ID);

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

        JMenuItem mntmNewMenuItem = new JMenuItem("Cambia de equipo favorito");
        menuBar.add(mntmNewMenuItem);
        contentPane = new JPanel();

        contentPane.setLayout(null);
        setContentPane(contentPane);

        JPanel jpCambiar = new JPanel();
        jpCambiar.setBorder(new TitledBorder(null, "Cambiar de equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpCambiar.setBounds(10, 11, 450, 120);
        contentPane.add(jpCambiar);
        jpCambiar.setLayout(null);
        Equipo = new JLabel("Equipo favorito");
        Equipo.setBounds(72, 50, 110, 14);
        jpCambiar.add(Equipo);

        cbEquipo = new JComboBox();
        cbEquipo.setBounds(198, 50, 212, 20);
        jpCambiar.add(cbEquipo);

        Button aceptar = new Button("Aceptar");
        aceptar.setBounds(198, 80, 70, 22);
        jpCambiar.add(aceptar);
        aceptar.setActionCommand(ACEPTAR);
        aceptar.addActionListener(this);
        aceptar.setBackground(Color.GREEN);

        Button cancelar = new Button("Cancelar");
        cancelar.setBounds(290, 80, 70, 22);
        jpCambiar.add(cancelar);
        cancelar.setActionCommand(CANCELAR);
        cancelar.addActionListener(this);
        cancelar.setBackground(Color.ORANGE);

        int selected=0;
        for (int i = 0; i < equipos.size(); i++) {
            if((int)equipos.get(i).getProperty(EQUIPO_ID)==idequipofav){
               selected=i;
            }
            cbEquipo.addItem(equipos.get(i));
        }
        cbEquipo.setSelectedIndex(selected);

    }

    /**
     * Metodo para realizar las acciones del evento
     * @param e e
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case ACEPTAR:
                System.out.println("entro aqui");
                try {
                    gln.updateUsuario((int) ((itfProperty) cbEquipo.getSelectedItem()).getProperty(EQUIPO_ID));
                    javax.swing.JOptionPane.showMessageDialog(this,"Equipo actualizado con exito");
                    this.dispose();
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Fallo en la actualización");
                    ex.printStackTrace();
                }
                break;
            case CANCELAR:
                cbEquipo.setSelectedIndex(0);
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
