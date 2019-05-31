package com.company.LP;

import com.company.Excepciones.EquiposInsuficientesException;
import com.company.LN.GestorLN;
import com.company.LP.InsertarPorVentanas.*;
import com.company.LP.Updates.updateEquipoFav;
import com.company.LP.imagenes.clsImagen;

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

    private GestorLN gln;
    private JMenuBar barraMenu;
    private JMenu menuAjustes, menuPerfil, menuInsertar;
    /**
     * Para ajustes
     */
    private JMenuItem itemCerrarSesion, itemCambiarEquipoFav;
    /**
     * Para perfil
     */
    private JMenuItem itemDatosPesonales;

    /**
     * Para insertar
     */
    private JMenuItem itemInsertarJugador, itemInsertarEquipo, itemInsertarPosicion, itemInsertarEstado, itemInsertarCampo
            ,itemInsertarTemporada;

    private final String ABRIR_NOTICIAS = "noticias";
    private final String INSERTAR = "insertar";
    private final String ABRIR_CLASIFICACION = "clasificacion";
    private final String ABRIR_JORNADA = "jornada";
    private final String CERRAR_SESION = "cerrar sesion";
    private final String CAMBIAR_EQUIPO_FAV = "cambiar equipo fav";
    private final String DATOS_PERSONALES = "datos personales";
    private final String INSERTAR_JUGADOR = "insertar jugador";
    private final String INSERTAR_EQUIPO = "insertar equipo";
    private final String INSERTAR_POSICION = "insertar posicion";
    private final String INSERTAR_ESTADO = "insertar estado";
    private final String INSERTAR_CAMPO = "insertar campo";
    private final String INSERTAR_TEMPORADA="insertar temporada";
    private clsImagen contentPane;

    /**
     * Create the frame.
     */
    public ventanaMenu(GestorLN gln_) {
        this.setTitle("BASKET LIVE ⛹");
        gln = gln_;
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        this.setResizable(false);
        setBounds(100, 100, 450, 348);

        contentPane = new clsImagen();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackgroundImage(contentPane.createImage("/com/company/LP/imagenes/menu.png").getImage());
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        JButton btnNoticias = new JButton("Noticias");
        getContentPane().add(btnNoticias, BorderLayout.EAST);
        btnNoticias.setActionCommand(ABRIR_NOTICIAS);
        btnNoticias.addActionListener(this);
        btnNoticias.setForeground(Color.WHITE);
        btnNoticias.setOpaque(false);
        btnNoticias.setContentAreaFilled(false);
        btnNoticias.setBorderPainted(false);

        JButton btnClasificacion = new JButton("Clasificacion");
        getContentPane().add(btnClasificacion, BorderLayout.WEST);
        btnClasificacion.setActionCommand(ABRIR_CLASIFICACION);
        btnClasificacion.addActionListener(this);
        btnClasificacion.setForeground(Color.WHITE);
        btnClasificacion.setOpaque(false);
        btnClasificacion.setContentAreaFilled(false);
        btnClasificacion.setBorderPainted(false);

        JButton btnJornada = new JButton("Jornada");
        getContentPane().add(btnJornada, BorderLayout.NORTH);
        btnJornada.setActionCommand(ABRIR_JORNADA);
        btnJornada.addActionListener(this);
        btnJornada.setForeground(Color.WHITE);
        btnJornada.setOpaque(false);
        btnJornada.setContentAreaFilled(false);
        btnJornada.setBorderPainted(false);

        menuAjustes = new JMenu("Ajustes");
        barraMenu.add(menuAjustes);

        itemCerrarSesion = new JMenuItem("Cerrar sesión");
        itemCerrarSesion.setActionCommand(CERRAR_SESION);
        itemCerrarSesion.addActionListener(this);
        menuAjustes.add(itemCerrarSesion);

        if (!gln.isAdmin()) {
            itemCambiarEquipoFav = new JMenuItem("Cambia de equipo");
            itemCambiarEquipoFav.setActionCommand(CAMBIAR_EQUIPO_FAV);
            itemCambiarEquipoFav.addActionListener(this);
            menuAjustes.add(itemCambiarEquipoFav);
        }

        if (!gln.isAdmin()) {
            menuPerfil = new JMenu("Perfil");
            barraMenu.add(menuPerfil);


            itemDatosPesonales = new JMenuItem("Datos personales");
            itemDatosPesonales.setActionCommand(DATOS_PERSONALES);
            itemDatosPesonales.addActionListener(this);
            menuPerfil.add(itemDatosPesonales);
        }
        if (gln.isAdmin()) {
            menuInsertar = new JMenu("Insertar");
            menuInsertar.setActionCommand(INSERTAR);
            menuInsertar.addActionListener(this);
            barraMenu.add(menuInsertar);

            itemInsertarJugador = new JMenuItem("Insertar jugador");
            itemInsertarJugador.setActionCommand(INSERTAR_JUGADOR);
            itemInsertarJugador.addActionListener(this);
            menuInsertar.add(itemInsertarJugador);

            itemInsertarEquipo = new JMenuItem("Insertar equipo");
            itemInsertarEquipo.setActionCommand(INSERTAR_EQUIPO);
            itemInsertarEquipo.addActionListener(this);
            menuInsertar.add(itemInsertarEquipo);

            itemInsertarCampo = new JMenuItem("Insertar campo");
            itemInsertarCampo.setActionCommand(INSERTAR_CAMPO);
            itemInsertarCampo.addActionListener(this);
            menuInsertar.add(itemInsertarCampo);

            itemInsertarPosicion = new JMenuItem("Insertar posicion de jugador");
            itemInsertarPosicion.setActionCommand(INSERTAR_POSICION);
            itemInsertarPosicion.addActionListener(this);
            menuInsertar.add(itemInsertarPosicion);

            itemInsertarEstado = new JMenuItem("Insertar estado de jugador");
            itemInsertarEstado.setActionCommand(INSERTAR_ESTADO);
            itemInsertarEstado.addActionListener(this);
            menuInsertar.add(itemInsertarEstado);

            itemInsertarTemporada=new JMenuItem("Insertar temporada");
            itemInsertarTemporada.setActionCommand(INSERTAR_TEMPORADA);
            itemInsertarTemporada.addActionListener(this);
            menuInsertar.add(itemInsertarTemporada);


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
                wdwNoticias w = new wdwNoticias(gln);
                w.setVisible(true);
                this.dispose();
                break;
            case ABRIR_CLASIFICACION:
                wdwClasificacion c = new wdwClasificacion(gln);
                c.setVisible(true);
                this.dispose();
                break;
            case ABRIR_JORNADA:
            	wdwJornadas wj=new wdwJornadas(gln);
            	wj.setVisible(true);
            	this.dispose();
                break;

            case INSERTAR_JUGADOR:
                wdwJugador j = new wdwJugador(gln);
                j.setVisible(true);
                this.dispose();
                break;
            case INSERTAR_EQUIPO:
                wdwEquipo eq = new wdwEquipo(gln);
                eq.setVisible(true);
                this.dispose();
                break;
            case INSERTAR_POSICION:
                wdwPosicion p = new wdwPosicion(gln);
                p.setVisible(true);
                this.dispose();
                break;
            case INSERTAR_ESTADO:
                wdwEstado es = new wdwEstado(gln);
                es.setVisible(true);
                this.dispose();
                break;
            case INSERTAR_CAMPO:
                wdwCampo ca = new wdwCampo(gln);
                ca.setVisible(true);
                this.dispose();
                break;
            case INSERTAR_TEMPORADA:
                try {
                    gln.anadirTemporada();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } catch (EquiposInsuficientesException ex) {
                    JOptionPane.showMessageDialog(this,ex.getMessage());
                }
                break;
            case CERRAR_SESION:
                wdwRegistrarUsuario ru = new wdwRegistrarUsuario(gln);
                ru.setVisible(true);
                this.dispose();
                break;
            case CAMBIAR_EQUIPO_FAV:
                updateEquipoFav ef = new updateEquipoFav(gln);
                ef.setVisible(true);
                this.dispose();
                break;
            case DATOS_PERSONALES:
                wdwDatosPersonales dp = new wdwDatosPersonales(gln);
                dp.setVisible(true);
                this.dispose();
                break;


        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int eleccion = JOptionPane.showConfirmDialog(this, "Â¿EstÃ¡s seguro?", "Salir",
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
