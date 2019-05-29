package com.company.LP;

import com.company.LN.GestorLN;
import com.company.LP.imagenes.clsImagen;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static com.company.comun.clsConstantes.EQUIPO_ID;

/**
 * Clase que utilizaremos para que una persona se pueda registrar en la apk
 */
public class wdwRegistrarUsuario extends JFrame implements WindowListener, ActionListener, FocusListener {


    private JLabel UserRegistro;
    private JLabel UserLogin;
    private JLabel Correo;
    private JLabel Equipo;
    private JLabel PassLogin;
    private JLabel PassRegistro;
    private JLabel Requerido, Requerido1;
    private JTextField txtRegistrousername;
    private JTextField txtRegistropassw;
    private JTextField txtRegistroemail;
    private JTextField txtLoginusername, txtLoginpassOculto, txtLoginpassVisible;
    private GestorLN gln;
    private JButton blogin;
    private JButton visible;
    private JButton visible1;
    private ImageIcon img;
    private ImageIcon img1;
    private JComboBox<itfProperty> cbEquipo;
    private final String BOTON_ACEPTAR_REGISTRO = "aceptarRegistro";
    private final String BOTON_CANCELAR_REGISTRO = "cancelarRegistro";
    private final String BOTON_ACEPTAR_LOGIN = "aceptarLogin";
    private final String BOTON_VISIBLE = "visible";
    private final String BOTON_VISIBLE1 = "visible1";
    private final String ENTER_LOGIN = "EnterLogin";
    private clsImagen contentPane;
    private boolean mostrar = false;

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
        setBounds(100, 100, 628, 548);
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
        Font f = new Font("BankGothic Lt BT", Font.BOLD, 20);
        jpRegistrar.setBorder(new TitledBorder(null, "Registrar usuario", TitledBorder.LEADING, TitledBorder.TOP, f, Color.WHITE));
        jpRegistrar.setBounds(10, 11, 420, 300);

        jpRegistrar.setFont(f);
        contentPane.add(jpRegistrar);
        jpRegistrar.setOpaque(false);

        jpRegistrar.setLayout(null);

        UserRegistro = new JLabel("Nombre de usuario");
        UserRegistro.setBounds(10, 50, 180, 14);
        UserRegistro.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpRegistrar.add(UserRegistro);
        UserRegistro.setForeground(Color.WHITE);


        txtRegistrousername = new JTextField();
        txtRegistrousername.setBounds(181, 50, 212, 20);
        txtRegistrousername.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpRegistrar.add(txtRegistrousername);
        txtRegistrousername.setColumns(10);

        PassRegistro = new JLabel("Contraseña");
        PassRegistro.setBounds(10, 102, 100, 14);
        PassRegistro.setForeground(Color.WHITE);
        PassRegistro.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpRegistrar.add(PassRegistro);

        txtRegistropassw = new JPasswordField();
        txtRegistropassw.setBounds(181, 99, 212, 20);
        txtRegistropassw.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpRegistrar.add(txtRegistropassw);
        txtRegistropassw.setColumns(10);

        Correo = new JLabel("Correo electrónico");
        Correo.setBounds(10, 154, 160, 14);
        Correo.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        Correo.setForeground(Color.WHITE);
        jpRegistrar.add(Correo);

        txtRegistroemail = new JTextField();
        txtRegistroemail.setBounds(181, 151, 212, 20);
        txtRegistroemail.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpRegistrar.add(txtRegistroemail);
        txtRegistroemail.setColumns(10);

        Equipo = new JLabel("Equipo favorito");
        Equipo.setBounds(10, 206, 150, 14);
        Equipo.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        Equipo.setForeground(Color.WHITE);
        jpRegistrar.add(Equipo);

        cbEquipo = new JComboBox();
        cbEquipo.setBounds(181, 203, 212, 20);
        cbEquipo.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpRegistrar.add(cbEquipo);


        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(180, 240, 110, 22);
        aceptar.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpRegistrar.add(aceptar);
        aceptar.setActionCommand(BOTON_ACEPTAR_REGISTRO);
        aceptar.addActionListener(this);
        aceptar.setForeground(Color.WHITE);
        aceptar.setOpaque(false);
        aceptar.setContentAreaFilled(false);
        aceptar.setBorderPainted(false);


        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(281, 240, 110, 22);
        cancelar.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpRegistrar.add(cancelar);
        cancelar.setActionCommand(BOTON_CANCELAR_REGISTRO);
        cancelar.addActionListener(this);
        cancelar.setForeground(Color.WHITE);
        cancelar.setOpaque(false);
        cancelar.setContentAreaFilled(false);
        cancelar.setBorderPainted(false);

        JPanel jpIniciarSesion = new JPanel();
        Font f1 = new Font("BankGothic Lt BT", Font.BOLD, 20);
        jpIniciarSesion.setBorder(new TitledBorder(null, "Iniciar Sesion", TitledBorder.LEADING, TitledBorder.TOP, f1, Color.WHITE));
        jpIniciarSesion.setBounds(10, 320, 420, 150);
        contentPane.add(jpIniciarSesion);
        jpIniciarSesion.setLayout(null);
        jpIniciarSesion.setOpaque(false);


        UserLogin = new JLabel("Usuario");
        UserLogin.setBounds(10, 43, 90, 14);
        UserLogin.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        UserLogin.setForeground(Color.WHITE);
        jpIniciarSesion.add(UserLogin);

        txtLoginusername = new JTextField();
        txtLoginusername.setBounds(130, 43, 150, 20);
        txtLoginusername.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpIniciarSesion.add(txtLoginusername);
        txtLoginusername.setColumns(10);
        txtLoginusername.setActionCommand(ENTER_LOGIN);
        txtLoginusername.addActionListener(this);
        txtLoginusername.addFocusListener(this);

        PassLogin = new JLabel("Contraseña");
        PassLogin.setBounds(10, 80, 110, 14);
        PassLogin.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        PassLogin.setForeground(Color.WHITE);
        jpIniciarSesion.add(PassLogin);


        txtLoginpassOculto = new JPasswordField();
        txtLoginpassOculto.setBounds(130, 80, 150, 20);
        txtLoginpassOculto.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpIniciarSesion.add(txtLoginpassOculto);
        txtLoginpassOculto.setColumns(10);
        txtLoginpassOculto.setActionCommand(ENTER_LOGIN);
        txtLoginpassOculto.addActionListener(this);
        txtLoginpassOculto.addFocusListener(this);
        txtLoginpassOculto.setVisible(true);

        txtLoginpassVisible = new JTextField();
        txtLoginpassVisible.setBounds(130, 80, 150, 20);
        txtLoginpassVisible.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpIniciarSesion.add(txtLoginpassVisible);
        txtLoginpassVisible.setColumns(10);
        txtLoginpassVisible.setActionCommand(ENTER_LOGIN);
        txtLoginpassVisible.addActionListener(this);
        txtLoginpassVisible.addFocusListener(this);
        txtLoginpassVisible.setVisible(false);

        img = new ImageIcon(wdwRegistrarUsuario.class.getResource("/com/company/LP/imagenes/visibilidad.png"));
        visible = new JButton();
        visible.setIcon(img);
        visible.setBounds(100, 110, 110, 22);
        visible.setActionCommand(BOTON_VISIBLE);
        visible.addActionListener(this);
        visible.setOpaque(false);
        visible.setForeground(Color.WHITE);
        visible.setContentAreaFilled(false);
        visible.setBorderPainted(false);
        jpIniciarSesion.add(visible);
        visible.setVisible(true);

        img1 = new ImageIcon(wdwRegistrarUsuario.class.getResource("/com/company/LP/imagenes/visibilidad1.png"));
        visible1 = new JButton();
        visible1.setIcon(img1);
        visible1.setBounds(100, 110, 110, 22);
        visible1.setActionCommand(BOTON_VISIBLE1);
        visible1.addActionListener(this);
        visible1.setOpaque(false);
        visible1.setForeground(Color.WHITE);
        visible1.setContentAreaFilled(false);
        visible1.setBorderPainted(false);
        jpIniciarSesion.add(visible1);
        visible.setVisible(false);



        blogin = new JButton("Iniciar Sesion");
        blogin.setBounds(250, 110, 160, 23);
        blogin.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        jpIniciarSesion.add(blogin);
        blogin.setActionCommand(BOTON_ACEPTAR_LOGIN);
        blogin.addActionListener(this);
        blogin.setForeground(Color.WHITE);
        blogin.setOpaque(false);
        blogin.setContentAreaFilled(false);
        blogin.setBorderPainted(false);

        Requerido = new JLabel("Requerido");
        Requerido.setBounds(300, 43, 110, 14);
        Requerido.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        Requerido.setForeground(Color.RED);
        Requerido.setVisible(false);
        jpIniciarSesion.add(Requerido);

        Requerido1 = new JLabel("Requerido");
        Requerido1.setBounds(300, 80, 110, 14);
        Requerido1.setFont(new Font("BankGothic Lt BT", Font.BOLD, 13));
        Requerido1.setForeground(Color.RED);
        Requerido1.setVisible(false);
        jpIniciarSesion.add(Requerido1);


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
                ventanaComienzoApk ca = new ventanaComienzoApk(gln);
                ca.setVisible(true);
                this.dispose();
                break;
            case BOTON_ACEPTAR_LOGIN:

                if (txtLoginusername.getText().equals("")) {
                    Requerido.setVisible(true);
                    txtLoginusername.setBackground(Color.RED);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                if (txtLoginpassOculto.getText().equals("")) {
                    Requerido1.setVisible(true);
                    txtLoginpassOculto.setBackground(Color.RED);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                } else {

                    try {
                        if (gln.login(txtLoginusername.getText(), txtLoginpassOculto.getText())) {
                            ventanaMenu v = new ventanaMenu(gln);
                            v.setVisible(true);
                            this.dispose();

                        }
                    } catch (Exception ex) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Error con el login");
                        ex.printStackTrace();
                    }
                }
                break;
            case ENTER_LOGIN:
                blogin.doClick();
                break;
            case BOTON_VISIBLE:
                if (mostrar) {
                    txtLoginpassVisible.setVisible(true);
                    txtLoginpassOculto.setVisible(false);
                    txtLoginpassVisible.setText(txtLoginpassOculto.getText());
                    visible.setVisible(false);
                    visible1.setVisible(true);
                    mostrar = false;
                }
                break;
            case BOTON_VISIBLE1:
                if (!mostrar) {
                    txtLoginpassVisible.setVisible(false);
                    txtLoginpassOculto.setVisible(true);
                    txtLoginpassVisible.setText(txtLoginpassOculto.getText());
                    visible.setVisible(true);
                    visible1.setVisible(false);
                    mostrar = true;

                }
                break;

        }
    }

        @Override
        public void windowOpened (WindowEvent e){

        }

        @Override
        public void windowClosing (WindowEvent e){
            close();
        }

        private void close () {

            int eleccion = JOptionPane.showConfirmDialog(this, "¿Estás seguro?", "Salir",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            if (eleccion == JOptionPane.YES_OPTION) {
                System.exit(0);


            }
        }

        @Override
        public void windowClosed (WindowEvent e){

        }

        @Override
        public void windowIconified (WindowEvent e){

        }

        @Override
        public void windowDeiconified (WindowEvent e){

        }

        @Override
        public void windowActivated (WindowEvent e){

        }

        @Override
        public void windowDeactivated (WindowEvent e){

        }

        @Override
        public void focusGained (FocusEvent e){
            e.getComponent().setBackground(Color.WHITE);

            if (e.getComponent() == txtLoginusername) {
                txtLoginusername.setForeground(Color.BLACK);
                Requerido.setVisible(false);
            }
            if (e.getComponent() == txtLoginpassOculto) {
                txtLoginpassOculto.setForeground(Color.BLACK);
                Requerido1.setVisible(false);
            }


        }

        @Override
        public void focusLost (FocusEvent e){

        }
    }
