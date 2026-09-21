package com.ejemplos.igu.swing.eventos;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LaminaConBotones extends JPanel {
    protected JButton botonAzul = new JButton("Azul");
    protected JButton botonAmarillo = new JButton("Amarillo");
    protected JButton botonRojo = new JButton("Rojo");

    protected LaminaConBotones() {
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);
    }
}