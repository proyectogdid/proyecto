package com.company.LP;

import com.company.LN.Equipo;
import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.EQUIPO_ID;

/**
 * Clase que utilizaremos para que una persona se pueda registrar en la apk
 */
public class wdwRegistrarUsuario extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel UserRegistro;
    private JLabel UserLogin;
    private JLabel Correo;
    private JLabel Equipo;
    private JLabel PassLogin;
    private JLabel PassRegistro;
    private JTextField txtRegistrousername;
    private JTextField txtRegistropassw;
    private JTextField txtRegistroemail;
    private JTextField txtRegistroEquipo;
    private JTextField txtLoginusername, txtLoginpassw;
    private GestorLN gln;
    private JComboBox<itfProperty> cbEquipo;
    private final String BOTON_ACEPTAR_REGISTRO = "aceptarRegistro";
    private final String BOTON_CANCELAR_REGISTRO = "cancelarRegistro";
    private final String BOTON_ACEPTAR_LOGIN = "aceptarLogin";

    /**
     * Create the frame.
     */
    public wdwRegistrarUsuario(GestorLN gln_) {
        this.setTitle("BASKET LIVE ⛹️");
        gln = gln_;

        ArrayList<itfProperty> equipos = gln.leerEquipos();
        cbEquipo = new JComboBox<>();
        for (int i = 0; i < equipos.size(); i++) {
            cbEquipo.addItem(equipos.get(i));
        }

        cbEquipo.setBounds(198, 190, 120, 34);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 628, 548);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(cbEquipo);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("Introduce tus datos y disfruta \uD83D\uDE0A");
        menuBar.add(mntmNewMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

        UserRegistro = new JLabel("Nombre de usuario");
        UserRegistro.setBounds(72, 50, 110, 14);
        contentPane.add(UserRegistro);

        txtRegistrousername = new JTextField();
        txtRegistrousername.setBounds(198, 50, 212, 20);
        contentPane.add(txtRegistrousername);
        txtRegistrousername.setColumns(10);

        PassRegistro = new JLabel("Contraseña");
        PassRegistro.setBounds(72, 102, 100, 14);
        contentPane.add(PassRegistro);

        txtRegistropassw = new JTextField();
        txtRegistropassw.setBounds(198, 99, 212, 20);
        contentPane.add(txtRegistropassw);
        txtRegistropassw.setColumns(10);

        Correo = new JLabel("Correo electrónico");
        Correo.setBounds(72, 154, 110, 14);
        contentPane.add(Correo);

        txtRegistroemail = new JTextField();
        txtRegistroemail.setBounds(198, 151, 212, 20);
        contentPane.add(txtRegistroemail);
        txtRegistroemail.setColumns(10);

        Equipo = new JLabel("Equipo favorito");
        Equipo.setBounds(72, 206, 110, 14);
        contentPane.add(Equipo);

        cbEquipo = new JComboBox();
        cbEquipo.setBounds(198, 203, 212, 20);
        contentPane.add(cbEquipo);

        txtRegistroEquipo = new JTextField();
        txtRegistroEquipo.setBounds(198, 203, 212, 20);
        contentPane.add(txtRegistroEquipo);
        txtRegistroEquipo.setColumns(10);

        Button aceptar = new Button("Aceptar");
        aceptar.setBounds(225, 240, 70, 22);
        contentPane.add(aceptar);
        aceptar.setActionCommand(BOTON_ACEPTAR_REGISTRO);
        aceptar.addActionListener(this);
        aceptar.setBackground(Color.GREEN);


        Button cancelar = new Button("Cancelar");
        cancelar.setBounds(306, 240, 70, 22);
        contentPane.add(cancelar);
        cancelar.setActionCommand(BOTON_CANCELAR_REGISTRO);
        cancelar.addActionListener(this);
        cancelar.setBackground(Color.ORANGE);

        UserLogin = new JLabel("Usuario");
        UserLogin.setBounds(72, 310, 110, 14);
        contentPane.add(UserLogin);

        txtLoginusername = new JTextField();
        txtLoginusername.setBounds(198, 310, 212, 20);
        contentPane.add(txtLoginusername);
        txtLoginusername.setColumns(10);

        PassLogin = new JLabel("Contraseña");
        PassLogin.setBounds(72, 350, 110, 14);
        contentPane.add(PassLogin);

        txtLoginpassw = new JTextField();
        txtLoginpassw.setBounds(198, 350, 212, 20);
        contentPane.add(txtLoginpassw);
        txtLoginpassw.setColumns(10);

        Button blogin = new Button("Iniciar Sesion");
        blogin.setBounds(265, 380, 80, 22);
        contentPane.add(blogin);
        blogin.setActionCommand(BOTON_ACEPTAR_LOGIN);
        blogin.addActionListener(this);

        /*
        * Este boton se ha creado para que el boton iniciar sesion no de fallo y ocupe toda la pantalla
        */
        Button bfixed=new Button("Arreglo de iniciar sesion");
        contentPane.add(bfixed);
        bfixed.setVisible(false);

        for (int i = 0; i <equipos.size() ; i++) {
            cbEquipo.addItem(equipos.get(i));
        }

    }

    /**
     * Clase para ejecutar las acciones del evento
     *
     * @param e e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case BOTON_ACEPTAR_REGISTRO:
                System.out.println("entro aqui");
                try {
                    gln.registrarUsuario(txtRegistrousername.getText(), txtRegistropassw.getText(), (int) ((itfProperty) cbEquipo.getSelectedItem()).getProperty(EQUIPO_ID), txtRegistroemail.getText());
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Fallo en el registro");
                }
                ventanaMenu vm = new ventanaMenu(gln);
                vm.setVisible(true);
                this.dispose();
                break;
            case BOTON_CANCELAR_REGISTRO:
                cbEquipo.setSelectedIndex(0);
                txtRegistroemail.setText("");
                txtRegistropassw.setText("");
                txtRegistrousername.setText("");
                break;
            case BOTON_ACEPTAR_LOGIN:
                try {
                    if (gln.login(txtLoginusername.getText(), txtLoginpassw.getText())) {
                        ventanaMenu v = new ventanaMenu(gln);
                        v.setVisible(true);
                        this.dispose();
                    }
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "error con el login");
                    ex.printStackTrace();
                }
        }

    }
}
