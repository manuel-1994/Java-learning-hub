package com.ejemplos.igu.swing.basico;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaConImagen {
    public static void main(String[] args) {
        MarcoConImagen miMarco = new MarcoConImagen();
        LaminaConImagen miLamina = new LaminaConImagen();

        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.add(miLamina);
    }
}

class MarcoConImagen extends JFrame {

    MarcoConImagen() {
        setTitle("Marco con Imagen");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class LaminaConImagen extends JPanel {

    private BufferedImage imagen;

    private void panelConImagen() {
        try {
            imagen = ImageIO.read(new File("./src/com/ejemplos/igu/swing/imagenes/pruembaImagen.jpg"));
        } catch (Exception e) {
            System.out.println("No se Encuentra la imagen");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        panelConImagen();
        if (imagen != null) {
            g.drawImage(imagen, 10, 10, null);
        }

    }

}