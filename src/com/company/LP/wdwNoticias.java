package com.company.LP;

import com.company.LN.GestorLN;
import com.company.comun.itfProperty;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class wdwNoticias extends JFrame {
    private JPanel contentPane;
    private GestorLN gln;
    private ArrayList<itfProperty> noticias;
    private ArrayList<NoticiaComponent > componentes=new ArrayList<>();

    public wdwNoticias(GestorLN gln_) {
        gln=gln_;
        noticias=gln.leerNoticias();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 618);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBounds(27, 11, 373, 245);
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        //contentPane.add(panel);

        for(int i=0; i<noticias.size();i++){

            NoticiaComponent c1=new NoticiaComponent(noticias.get(i));
            componentes.add(c1);
            //scrollPane.add(c1);
            panel.add(c1);
        }
        contentPane.setLayout(null);
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 57, 435, 522);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        contentPane.add(scrollPane);
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(187, 23, 89, 23);
        contentPane.add(btnNewButton);

    }
}
