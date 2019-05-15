package com.company.LP;

import com.company.LN.GestorLN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaComienzoApk extends JFrame implements ActionListener {
    private JPanel contentPane;
    private GestorLN gln;
    private final String COMENZAR = "comenzar";

    public ventanaComienzoApk(GestorLN gln_) {
        gln = gln_;
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

        JButton btnComenzar = new JButton("Comenzar");
        btnComenzar.setActionCommand(COMENZAR);
        btnComenzar.addActionListener(this);
        panel.add(btnComenzar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case COMENZAR:
                wdwRegistrarUsuario ru=new wdwRegistrarUsuario(gln);
                break;

        }
    }
}
