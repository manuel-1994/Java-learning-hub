package com.ejemplos.igu.swing.basico;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaLetras {

    public static void main(String[] args) {
        MarcoConLetras miMarco = new MarcoConLetras();
        LaminaConLetras miLamina = new LaminaConLetras();

        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.add(miLamina);
    }

}

class MarcoConLetras extends JFrame {

    public MarcoConLetras() {
        setTitle("Marco con letras");
        setLocationRelativeTo(null);
        setSize(400, 400);
        setVisible(true);
    }

}

class LaminaConLetras extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Arial", Font.ITALIC, 12));

        g2.drawString("Hola, probando las fonts", 100, 100);
    }

}
