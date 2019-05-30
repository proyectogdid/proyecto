package com.company.LP;

import com.company.comun.itfProperty;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

import static com.company.comun.clsConstantes.*;

/**
 * Clase encargada de mostrar las noticias de la aplicacion
 */
public class NoticiaComponent extends Panel {

    public NoticiaComponent(itfProperty noticia, int idequipofav) {
        setEnabled(false);
        setBackground((((int) noticia.getProperty(NOTICIA_EQUIPO_RELATIVO)) == idequipofav) ? SystemColor.activeCaption : Color.LIGHT_GRAY);

        setLayout(null);
        this.setPreferredSize(new Dimension(300, 80));


        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon i;
        switch ((String) noticia.getProperty(NOTICIA_TIPO)) {
            case NOTICIA_TIPO_TRASPASO:
                i = new ImageIcon(NoticiaComponent.class.getResource("/com/company/LP/imagenes/dollar.png"));
                break;
            case NOTICIA_TIPO_EVENTO:
                i = new ImageIcon(NoticiaComponent.class.getResource("/com/company/LP/imagenes/newspaper.png"));
                break;
            default:
                i = new ImageIcon(NoticiaComponent.class.getResource("/com/company/LP/imagenes/newspaper.png"));
        }


        Image img = i.getImage();
        ImageIcon img2 = new ImageIcon((img).getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        lblNewLabel.setIcon(img2);
        lblNewLabel.setBounds(10, 5, 89, 77);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel((String) (noticia.getProperty(NOTICIA_TEXTO)));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(109, 11, 295, 71);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel(((Date) noticia.getProperty(NOTICIA_FECHA)).toString());
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
        lblNewLabel_2.setBounds(142, 64, 262, 20);
        add(lblNewLabel_2);
    }
}
