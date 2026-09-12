package com.ejemplos.igu.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class PruebaConColor {
    public static void main(String[] args) {
        MarcoConColor miMarco1 = new MarcoConColor();
        LaminaConColor miLamina1 = new LaminaConColor();

        miLamina1.setBackground(Color.black);

        miMarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco1.add(miLamina1);
    }
}

class MarcoConColor extends JFrame {
    MarcoConColor() {
        setTitle("Marco con Color");
        setBounds(100, 100, 500, 500);
        setVisible(true);
    }
}

class LaminaConColor extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangle = new Rectangle2D.Double(100, 100, 200, 150);
        g2.setPaint(Color.WHITE);
        g2.draw(rectangle);
        g2.setPaint(Color.BLUE);
        g2.fill(rectangle);

        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangle);
        g2.setPaint(Color.RED);
        g2.fill(elipse);
    }
}