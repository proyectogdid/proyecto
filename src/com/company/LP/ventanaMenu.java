package com.company.LP;

import com.company.LN.GestorLN;
import com.company.LP.InsertarPorVentanas.insertar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase se va a utilizar para sacar por pantalla la ventana del menu principal de la aplicacion
 */
public class ventanaMenu extends JFrame  implements ActionListener {

    private JPanel contentPane;
    private GestorLN gln;
    private final String ABRIR_NOTICIAS="noticias";
    private final String INSERTAR="insertar";
    private final String ABRIR_CLASIFICACION ="clasificacion";
    private final String ABRIR_JORNADA="jornada";


    /**
     * Create the frame.
     */
    public ventanaMenu(GestorLN gln_) {
        this.setTitle("BASKET LIVE ⛹️");
        gln=gln_;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem = new JMenuItem("Basket Live");
        menuBar.add(mntmNewMenuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(50, 50));
        setContentPane(contentPane);

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
    }

    /**
     * Metodo para realizar las acciones del evento
     * @param e e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ABRIR_NOTICIAS:
               // wdwJugador w=new wdwJugador(gln);
               // w.setVisible(true);
                break;
            case ABRIR_CLASIFICACION:
                wdwClasificacion c=new wdwClasificacion(gln);
                c.setVisible(true);
                break;
           case ABRIR_JORNADA:
                break;

            case INSERTAR:
                insertar i=new insertar(gln);
                i.setVisible(true);
                break;
        }
    }
}
