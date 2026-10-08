package com.ejemplos.igu.swing.eventos.accionEvents;

import java.awt.Color;

import javax.swing.JFrame;

import com.ejemplos.igu.swing.eventos.LaminaConBotones;
import com.ejemplos.igu.swing.eventos.MarcoConEventos;

public class PruebaEventosLambda {
    public static void main(String[] args) {
        MarcoConEventos marco = new MarcoConEventos();
        LaminaConLambda lamina = new LaminaConLambda();

        marco.setTitle("Prueba de eventos con lambda");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.add(lamina);
    }
}

class LaminaConLambda extends LaminaConBotones {

    LaminaConLambda() {
        super();
        botonAzul.addActionListener(e -> setBackground(Color.blue));
        botonAmarillo.addActionListener(e -> setBackground(Color.yellow));
        botonRojo.addActionListener(e -> setBackground(Color.red));
    }

}