package com.ejemplos.igu.swing.eventos.accionEvents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ejemplos.igu.swing.eventos.LaminaConBotones;
import com.ejemplos.igu.swing.eventos.MarcoConEventos;

public class PruebaEventosConClaseExterna {
    public static void main(String[] args) {
        MarcoConEventos marco = new MarcoConEventos();
        LaminaClaseExterna lamina = new LaminaClaseExterna();

        marco.setTitle("Prueba de eveentos con bonotnes");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(lamina);
    }

}

class LaminaClaseExterna extends LaminaConBotones {

    public LaminaClaseExterna() {
        super();

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