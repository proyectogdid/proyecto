package com.company.LP.imagenes;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Clase para darle un formato a las imagenes que utilicemos
 */
public class clsImagen extends JPanel {
    private Image bgImage;

    public clsImagen()
    {
        super();

        // Hacemos que el panel sea transparente
        this.setOpaque(false);
    }

    /**
     * Lo utilizaremos para establecerle su imagen de fondo.
     * @param bgImage La imagen en cuestion
     */
    public void setBackgroundImage(Image bgImage) {
        this.bgImage = bgImage;
    }

    /**
     * Para recuperar una imagen de un archivo...
     * @param path Ruta de la imagen relativa al proyecto
     * @return una imagen
     */
    public ImageIcon createImage(String path) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            //return new Image(imgURL);
            return new ImageIcon(imgURL);

        } else {
            System.err.println("No se encuentra el archivo: " + path);
            return null;
        }
    }

    @Override
    public void paint(Graphics g)
    {

        // Pintamos la imagen de fondo...
        if(bgImage != null)
        {
            g.drawImage(bgImage, 0, 0, null);
        }

        // Y pintamos el resto de cosas que pueda tener el panel
        super.paint(g);

    }
}
