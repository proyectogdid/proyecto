package com.company.LP;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class wdwDatosPersonales extends JFrame implements ActionListener, WindowListener {


    private GestorLN gln;
    private JPanel contentPane;
    private final String VOLVER="volver";
    private JLabel NombreUsuario;
    private JLabel UserLogin;
    private JLabel Correo;
    private JLabel Equipo;
    private JLabel PassLogin;
    private JLabel PassRegistro;
    private JTextField txtRegistrousername;
    private JTextField txtRegistropassw;
    private JTextField txtRegistroemail;
    private JTextField txtRegistroEquipo;


    public wdwDatosPersonales(GestorLN gln_) {

        this.setTitle("BASKET LIVE ⛹️");
        gln = gln_;


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();

        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JPanel jpDatosPersonales = new JPanel();
        jpDatosPersonales.setBorder(new TitledBorder(null, "Mis datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpDatosPersonales.setBounds(10, 11, 450, 300);
        contentPane.add(jpDatosPersonales);
        jpDatosPersonales.setLayout(null);

        NombreUsuario = new JLabel("Nombre de usuario");
        NombreUsuario.setBounds(72, 50, 110, 14);
        jpDatosPersonales.add(NombreUsuario);

        txtRegistrousername = new JTextField();
        txtRegistrousername.setBounds(198, 50, 212, 20);
        jpDatosPersonales.add(txtRegistrousername);
        txtRegistrousername.setColumns(10);

        PassRegistro = new JLabel("Contraseña");
        PassRegistro.setBounds(72, 102, 100, 14);
        jpDatosPersonales.add(PassRegistro);

        txtRegistropassw = new JTextField();
        txtRegistropassw.setBounds(198, 99, 212, 20);
        jpDatosPersonales.add(txtRegistropassw);
        txtRegistropassw.setColumns(10);

        Correo = new JLabel("Correo electrónico");
        Correo.setBounds(72, 154, 110, 14);
        jpDatosPersonales.add(Correo);

        txtRegistroemail = new JTextField();
        txtRegistroemail.setBounds(198, 151, 212, 20);
        jpDatosPersonales.add(txtRegistroemail);
        txtRegistroemail.setColumns(10);

        Equipo = new JLabel("Equipo favorito");
        Equipo.setBounds(72, 206, 110, 14);
        jpDatosPersonales.add(Equipo);

       /* cbEquipo = new JComboBox();
        cbEquipo.setBounds(198, 203, 212, 20);
        jpDatosPersonales.add(cbEquipo);*/

        txtRegistroEquipo = new JTextField();
        txtRegistroEquipo.setBounds(198, 203, 212, 20);
        jpDatosPersonales.add(txtRegistroEquipo);
        txtRegistroEquipo.setColumns(10);


        Button volver = new Button("Volver");
        volver.addActionListener(this);
        volver.setActionCommand(VOLVER);
        jpDatosPersonales.add(volver, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
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
