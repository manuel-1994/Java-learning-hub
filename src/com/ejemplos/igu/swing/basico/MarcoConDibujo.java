package com.ejemplos.igu.swing.basico;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class MarcoConDibujo {
    public static void main(String[] args) {
        MarcoPrincipal miMarco1 = new MarcoPrincipal();
        LaminaConDibujo2d miLamina1 = new LaminaConDibujo2d();

        miMarco1.setTitle("Marco con dibujo");
        miMarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco1.add(miLamina1);
    }
}

class MarcoPrincipal extends JFrame {
    public MarcoPrincipal() {
        setSize(500, 500);
        setLocation(100, 100);
        setVisible(true);
    }
}

class LaminaConDibujo extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(100, 100, 250, 250);
        g.drawLine(200, 200, 500, 250);
    }
}

class LaminaConDibujo2d extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        Ellipse2D elipse = new Ellipse2D.Double();
        Line2D linea = new Line2D.Double(100, 100, 300, 250);

        elipse.setFrame(rectangulo);

        g2.draw(rectangulo);
        g2.draw(elipse);
        g2.draw(linea);
    }
}