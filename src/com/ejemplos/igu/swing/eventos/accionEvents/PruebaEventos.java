package com.ejemplos.igu.swing.eventos.accionEvents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.ejemplos.igu.swing.eventos.LaminaConBotones;
import com.ejemplos.igu.swing.eventos.MarcoConEventos;

public class PruebaEventos {
    public static void main(String[] args) {
        MarcoConEventos marco = new MarcoConEventos();
        LaminaEvento lamina = new LaminaEvento();

        marco.setTitle("Marco con botones");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.add(lamina);
    }
}

class LaminaEvento extends LaminaConBotones implements ActionListener {

    LaminaEvento() {
        super();

        botonAzul.addActionListener(this);
        botonAmarillo.addActionListener(this);
        botonRojo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object botonPulsado = arg0.getSource();
        if (botonPulsado == botonAzul) {
            setBackground(Color.blue);
        } else if (botonPulsado == botonAmarillo) {
            setBackground(Color.yellow);
        } else {
            setBackground(Color.red);
        }
    }

}