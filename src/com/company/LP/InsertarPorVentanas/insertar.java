package com.company.LP.InsertarPorVentanas;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que utilizaremos para insertar jugadores, equipos, posiciones y estados desde ventana en la BD
 */
public class insertar extends JFrame implements ActionListener {

    private JPanel contentPane;
    private GestorLN gln;
    private final String INSERTAR_JUGADOR = "jugador";
    private final String INSERTAR_EQUIPO = "equipo";
    private final String INSERTAR_POSICION = "posicion";
    private final String INSERTAR_ESTADO = "estado";

    /**
     * Create the frame.
     */
    public insertar(GestorLN gln_) {
        gln = gln_;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 200);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("Ventana para insertar equipos, jugadores, posiciones y estados");
        menuBar.add(mntmNewMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnJugador = new JButton("Insertar jugador");
        btnJugador.setActionCommand(INSERTAR_JUGADOR);
        btnJugador.addActionListener(this);
        panel.add(btnJugador);

        JButton btnEquipo = new JButton("Insertar equipo");
        btnEquipo.setActionCommand(INSERTAR_EQUIPO);
        btnEquipo.addActionListener(this);
        panel.add(btnEquipo);

        JButton btnPosicion = new JButton("Insertar posicion");
        btnPosicion.setActionCommand(INSERTAR_POSICION);
        btnPosicion.addActionListener(this);
        panel.add(btnPosicion);

        JButton btnEstado = new JButton("Insertar estado");
        btnEstado.setActionCommand(INSERTAR_ESTADO);
        btnEstado.addActionListener(this);
        panel.add(btnEstado);


    }

    /**
     * Metodo para realizar las acciones del evento
     *
     * @param e e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case INSERTAR_JUGADOR:
                wdwJugador j = new wdwJugador(gln);
                j.setVisible(true);
                break;
            case INSERTAR_EQUIPO:
                wdwEquipo eq = new wdwEquipo(gln);
                eq.setVisible(true);
                break;
            case INSERTAR_POSICION:
                wdwPosicion p = new wdwPosicion(gln);
                p.setVisible(true);
                break;
            case INSERTAR_ESTADO:
                wdwEstado es = new wdwEstado(gln);
                es.setVisible(true);
                break;
        }
    }
}

