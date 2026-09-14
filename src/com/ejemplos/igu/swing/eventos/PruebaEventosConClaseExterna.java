package com.ejemplos.igu.swing.eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventosConClaseExterna {
    public static void main(String[] args) {
        Marco marco = new Marco();
        Lamina lamina = new Lamina();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(lamina);
    }

}

class Marco extends JFrame {
    Marco() {
        setTitle("Prueba de eveentos con bonotnes");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class Lamina extends JPanel {
    private JButton botonAzul = new JButton("Azul");
    private JButton botonAmarillo = new JButton("Amarillo");
    private JButton botonRojo = new JButton("Rojo");

    public Lamina() {
        add(botonAmarillo);
        add(botonAzul);
        add(botonRojo);

        ColorDeFondo colorAmarillo = new ColorDeFondo(this, Color.yellow);
        ColorDeFondo colorAzul = new ColorDeFondo(this, Color.blue);
        ColorDeFondo colorRojo = new ColorDeFondo(this, Color.red);

        botonAmarillo.addActionListener(colorAmarillo);
        botonAzul.addActionListener(colorAzul);
        botonRojo.addActionListener(colorRojo);
    }
}

class ColorDeFondo implements ActionListener {
    private Color colorDeFondo;
    private JPanel ventana;

    ColorDeFondo(JPanel ventana, Color colorDeFondo) {
        this.colorDeFondo = colorDeFondo;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        ventana.setBackground(colorDeFondo);
    }

}