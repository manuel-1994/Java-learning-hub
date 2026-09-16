package com.ejemplos.igu.swing.eventos.accionEvents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventosLambda {
    public static void main(String[] args) {
        MarcoLambda marco = new MarcoLambda();
        Lamina lamina = new Lamina();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.add(lamina);
    }
}

class MarcoLambda extends JFrame {
    MarcoLambda() {
        setTitle("Prueba de eventos");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class Lamina extends JPanel {

    private JButton botonAzul = new JButton("Azul");
    private JButton botonAmarillo = new JButton("Amarillo");
    private JButton botonRojo = new JButton("Rojo");

    Lamina() {
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);
        botonAzul.addActionListener(e -> setBackground(Color.blue));
        botonAmarillo.addActionListener(e -> setBackground(Color.yellow));
        botonRojo.addActionListener(e -> setBackground(Color.red));
    }

}