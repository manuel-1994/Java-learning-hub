package com.ejemplos.igu.swing.basico;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreandoLamina {
    public static void main(String[] args) {
        MiMarcoConLamina miMarco1 = new MiMarcoConLamina();
        MiLamina miLamina1 = new MiLamina();

        miMarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco1.add(miLamina1);
    }
}

class MiMarcoConLamina extends JFrame {
    MiMarcoConLamina() {
        setTitle("Mi Marco");
        setSize(400, 300);
        setLocation(100, 100);
        setVisible(true);
    }
}

class MiLamina extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Estamos aprendiendo Swing", 100, 100);
    }
}