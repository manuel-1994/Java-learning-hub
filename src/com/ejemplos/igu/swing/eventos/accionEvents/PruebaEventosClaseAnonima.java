package com.ejemplos.igu.swing.eventos.accionEvents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventosClaseAnonima {
    public static void main(String[] args) {
        Marco marco = new Marco();
        LaminaAnonima lamina = new LaminaAnonima();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.add(lamina);
    }
}

class Marco extends JFrame {
    Marco() {
        setTitle("Prueba de eventos");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class LaminaAnonima extends JPanel {

    private JButton botonAzul = new JButton("Azul");
    private JButton botonAmarillo = new JButton("Amarillo");
    private JButton botonRojo = new JButton("Rojo");

    LaminaAnonima() {
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);

        botonAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                setBackground(Color.blue);
            }
        });

        botonAmarillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                setBackground(Color.yellow);
            }
        });

        botonRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                setBackground(Color.red);
            }
        });
    }

}