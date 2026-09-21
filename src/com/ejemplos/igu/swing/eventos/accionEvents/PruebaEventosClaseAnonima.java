package com.ejemplos.igu.swing.eventos.accionEvents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.ejemplos.igu.swing.eventos.LaminaConBotones;
import com.ejemplos.igu.swing.eventos.MarcoConEventos;

public class PruebaEventosClaseAnonima {
    public static void main(String[] args) {
        MarcoConEventos marco = new MarcoConEventos();
        LaminaAnonima lamina = new LaminaAnonima();
        marco.setTitle("Prueba de eventos");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.add(lamina);
    }
}

class LaminaAnonima extends LaminaConBotones {

    LaminaAnonima() {
        super();

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