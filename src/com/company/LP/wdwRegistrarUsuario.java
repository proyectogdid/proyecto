package com.company.LP;

import com.company.LN.GestorLN;
import com.company.LP.imagenes.clsImagen;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.UnknownServiceException;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.EQUIPO_ID;

/**
 * Clase que utilizaremos para que una persona se pueda registrar en la apk
 */
public class wdwRegistrarUsuario extends JFrame implements WindowListener, ActionListener {


    private JLabel UserRegistro;
    private JLabel UserLogin;
    private JLabel Correo;
    private JLabel Equipo;
    private JLabel PassLogin;
    private JLabel PassRegistro;
    private JTextField txtRegistrousername;
    private JTextField txtRegistropassw;
    private JTextField txtRegistroemail;
    private JTextField txtLoginusername, txtLoginpassw;
    private GestorLN gln;
    private JButton blogin;
    private JComboBox<itfProperty> cbEquipo;
    private final String BOTON_ACEPTAR_REGISTRO = "aceptarRegistro";
    private final String BOTON_CANCELAR_REGISTRO = "cancelarRegistro";
    private final String BOTON_ACEPTAR_LOGIN = "aceptarLogin";
    private final String ENTER_LOGIN = "EnterLogin";
    private clsImagen contentPane;

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


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        setBounds(100, 100, 628,548);
        contentPane = new clsImagen();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackgroundImage(contentPane.createImage("/com/company/LP/imagenes/sign&log.png").getImage());
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("Introduce tus datos y disfruta \uD83D\uDE0A");
        menuBar.add(mntmNewMenuItem);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

        JPanel jpRegistrar = new JPanel();
        jpRegistrar.setBorder(new TitledBorder(null, "Registrar usuario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
        jpRegistrar.setBounds(10, 11, 390, 300);
        contentPane.add(jpRegistrar);
        jpRegistrar.setOpaque(false);

        jpRegistrar.setLayout(null);

        UserRegistro = new JLabel("Nombre de usuario");
        UserRegistro.setBounds(10, 50, 110, 14);
        jpRegistrar.add(UserRegistro);
        UserRegistro.setForeground(Color.WHITE);



        txtRegistrousername = new JTextField();
        txtRegistrousername.setBounds(151, 50, 212, 20);
        jpRegistrar.add(txtRegistrousername);
        txtRegistrousername.setColumns(10);

        PassRegistro = new JLabel("Contraseña");
        PassRegistro.setBounds(10, 102, 100, 14);
        PassRegistro.setForeground(Color.WHITE);
        jpRegistrar.add(PassRegistro);

        txtRegistropassw = new JTextField();
        txtRegistropassw.setBounds(151, 99, 212, 20);
        jpRegistrar.add(txtRegistropassw);
        txtRegistropassw.setColumns(10);

        Correo = new JLabel("Correo electrónico");
        Correo.setBounds(10, 154, 110, 14);
        Correo.setForeground(Color.WHITE);
        jpRegistrar.add(Correo);

        txtRegistroemail = new JTextField();
        txtRegistroemail.setBounds(151, 151, 212, 20);
        jpRegistrar.add(txtRegistroemail);
        txtRegistroemail.setColumns(10);

        Equipo = new JLabel("Equipo favorito");
        Equipo.setBounds(10, 206, 110, 14);
        Equipo.setForeground(Color.WHITE);
        jpRegistrar.add(Equipo);

        cbEquipo = new JComboBox();
        cbEquipo.setBounds(151, 203, 212, 20);
        jpRegistrar.add(cbEquipo);


       JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(200, 240, 85, 22);
        jpRegistrar.add(aceptar);
        aceptar.setActionCommand(BOTON_ACEPTAR_REGISTRO);
        aceptar.addActionListener(this);
        aceptar.setForeground(Color.WHITE);
        aceptar.setOpaque(false);
        aceptar.setContentAreaFilled(false);
        aceptar.setBorderPainted(false);


        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(281, 240, 85, 22);
        jpRegistrar.add(cancelar);
        cancelar.setActionCommand(BOTON_CANCELAR_REGISTRO);
        cancelar.addActionListener(this);
        cancelar.setForeground(Color.WHITE);
        cancelar.setOpaque(false);
        cancelar.setContentAreaFilled(false);
        cancelar.setBorderPainted(false);

        JPanel jpIniciarSesion = new JPanel();
        jpIniciarSesion.setBorder(new TitledBorder(null, "Iniciar Sesion", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
        jpIniciarSesion.setBounds(10, 320, 390, 150);
        contentPane.add(jpIniciarSesion);
        jpIniciarSesion.setLayout(null);
        jpIniciarSesion.setOpaque(false);


        UserLogin = new JLabel("Usuario");
        UserLogin.setBounds(10, 30, 46, 14);
        UserLogin.setForeground(Color.WHITE);
        jpIniciarSesion.add(UserLogin);

        txtLoginusername = new JTextField();
        txtLoginusername.setBounds(151, 27, 212, 20);
        jpIniciarSesion.add(txtLoginusername);
        txtLoginusername.setColumns(10);
        txtLoginusername.setActionCommand(ENTER_LOGIN);
        txtLoginusername.addActionListener(this);

        PassLogin = new JLabel("Contraseña");
        PassLogin.setBounds(10, 61, 70, 14);
        PassLogin.setForeground(Color.WHITE);
        jpIniciarSesion.add(PassLogin);


        txtLoginpassw = new JTextField();
        txtLoginpassw.setBounds(151, 58, 212, 20);
        jpIniciarSesion.add(txtLoginpassw);
        txtLoginpassw.setColumns(10);
        txtLoginpassw.setActionCommand(ENTER_LOGIN);
        txtLoginpassw.addActionListener(this);

        blogin = new JButton("Iniciar Sesion");
        blogin.setBounds(180, 90, 144, 23);
        jpIniciarSesion.add(blogin);
        blogin.setActionCommand(BOTON_ACEPTAR_LOGIN);
        blogin.addActionListener(this);
        blogin.setForeground(Color.WHITE);
        blogin.setOpaque(false);
        blogin.setContentAreaFilled(false);
        blogin.setBorderPainted(false);

        /*
         * Este boton se ha creado para que el boton iniciar sesion no de fallo y ocupe toda la pantalla
         */
        Button bfixed = new Button("Arreglo de iniciar sesion");
        contentPane.add(bfixed);
        bfixed.setVisible(false);

        for (int i = 0; i < equipos.size(); i++) {
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
                ventanaComienzoApk ca=new ventanaComienzoApk(gln);
                ca.setVisible(true);
                this.dispose();
                break;
            case BOTON_ACEPTAR_LOGIN:
                try {
                    if (gln.login(txtLoginusername.getText(), txtLoginpassw.getText())) {
                        ventanaMenu v = new ventanaMenu(gln);
                        v.setVisible(true);
                        this.dispose();
                    }
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error con el login");
                    ex.printStackTrace();
                }
                break;
            case ENTER_LOGIN:
                blogin.doClick();
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
