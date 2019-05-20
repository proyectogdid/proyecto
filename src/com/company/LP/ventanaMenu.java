package com.company.LP;

import com.company.LN.GestorLN;
import com.company.LP.InsertarPorVentanas.insertar;
import com.company.LP.Updates.updateEquipoFav;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Esta clase se va a utilizar para sacar por pantalla la ventana del menu principal de la aplicacion
 */
public class ventanaMenu extends JFrame implements ActionListener, WindowListener {

    private JPanel contentPane;
    private GestorLN gln;
    private JMenuBar barraMenu;
    private JMenu menuAjustes, menuPerfil,menuInsertar;
    /**
     * Para ajustes
     */
    private JMenuItem itemCerrarSesion, itemCambiarEquipoFav;
    /**
     * Para perfil
     */
    private JMenuItem itemDatosPesonales;

    private final String ABRIR_NOTICIAS = "noticias";
    private final String INSERTAR = "insertar";
    private final String ABRIR_CLASIFICACION = "clasificacion";
    private final String ABRIR_JORNADA = "jornada";
    private final String CERRAR_SESION = "cerrar sesión";
    private final String CAMBIAR_EQUIPO_FAV = "cambiar equipo fav";
    private final String DATOS_PERSONALES = "datos personales";

    /**
     * Create the frame.
     */
    public ventanaMenu(GestorLN gln_) {
        this.setTitle("BASKET LIVE ⛹️");
        gln = gln_;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        setBounds(100, 100, 450, 150);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);


        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnNoticias = new JButton("Noticias");
        btnNoticias.setActionCommand(ABRIR_NOTICIAS);
        btnNoticias.addActionListener(this);
        panel.add(btnNoticias);

        JButton btnInsertar = new JButton("Insertar");
        btnInsertar.setActionCommand(INSERTAR);
        btnInsertar.addActionListener(this);
        panel.add(btnInsertar);


        JButton btnClasificacion = new JButton("Clasificacion");
        btnClasificacion.setActionCommand(ABRIR_CLASIFICACION);
        btnClasificacion.addActionListener(this);
        panel.add(btnClasificacion);

        JButton btnJornada = new JButton("Jornada");
        btnJornada.setActionCommand(ABRIR_JORNADA);
        btnJornada.addActionListener(this);
        panel.add(btnJornada);

        menuAjustes = new JMenu("Ajustes");
        barraMenu.add(menuAjustes);

        itemCerrarSesion = new JMenuItem("Cerrar sesión");
        itemCerrarSesion.setActionCommand(CERRAR_SESION);
        itemCerrarSesion.addActionListener(this);
        menuAjustes.add(itemCerrarSesion);

        itemCambiarEquipoFav = new JMenuItem("Cambia de equipo");
        itemCambiarEquipoFav.setActionCommand(CAMBIAR_EQUIPO_FAV);
        itemCambiarEquipoFav.addActionListener(this);
        menuAjustes.add(itemCambiarEquipoFav);

        menuPerfil = new JMenu("Perfil");
        barraMenu.add(menuPerfil);

        itemDatosPesonales = new JMenuItem("Datos personales");
        itemDatosPesonales.setActionCommand(DATOS_PERSONALES);
        itemDatosPesonales.addActionListener(this);
        menuPerfil.add(itemDatosPesonales);

        if(gln.isAdmin()){
            menuInsertar = new JMenu("Insertar");
            barraMenu.add(menuInsertar);

            itemDatosPesonales = new JMenuItem("Datos personales");
            itemDatosPesonales.setActionCommand(DATOS_PERSONALES);
            itemDatosPesonales.addActionListener(this);
            menuPerfil.add(itemDatosPesonales);
        }



    }

    /**
     * Metodo para realizar las acciones del evento
     *
     * @param e e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ABRIR_NOTICIAS:
                // wdwJugador w=new wdwJugador(gln);
                // w.setVisible(true);
                break;
            case ABRIR_CLASIFICACION:
                wdwClasificacion c = new wdwClasificacion(gln);
                c.setVisible(true);
                break;
            case ABRIR_JORNADA:
                break;

            case INSERTAR:
                insertar i = new insertar(gln);
                i.setVisible(true);
                break;
            case CERRAR_SESION:
                this.setVisible(false);
                wdwRegistrarUsuario ru= new wdwRegistrarUsuario(gln);
                ru.setVisible(true);
                break;
            case CAMBIAR_EQUIPO_FAV:
                updateEquipoFav ef=new updateEquipoFav(gln);
                ef.setVisible(true);
                break;
            case DATOS_PERSONALES:
                break;


        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
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
