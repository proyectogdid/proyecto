package com.company.LP;

import com.company.comun.itfProperty;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

import static com.company.comun.clsConstantes.NOTICIA_FECHA;
import static com.company.comun.clsConstantes.NOTICIA_TEXTO;

public class NoticiaComponent extends Panel {
    public NoticiaComponent(itfProperty noticia) {
        setEnabled(false);
        setBackground(Color.LIGHT_GRAY);

        setLayout(null);
        this.setPreferredSize(new Dimension(300, 80));


        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      //  Image img=new ImageIcon("C:\\Users\\Industria 4.0\\Documents\\Programacion II\\proyecto\\src\\com\\company\\LP\\imagenes\\dollar.png").getImage();
        ImageIcon i=new ImageIcon(NoticiaComponent.class.getResource("/com/company/LP/imagenes/dollar.png"));
        Image img=i.getImage();
        ImageIcon img2=new ImageIcon(( img).getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        lblNewLabel.setIcon(img2);
        lblNewLabel.setBounds(10, 5, 89, 77);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel((String) (noticia.getProperty(NOTICIA_TEXTO)));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(126, 11, 223, 71);
        add(lblNewLabel_1);
    }
}
