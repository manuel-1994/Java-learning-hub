package com.ejemplos.igu.swing.eventos.accionEvents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.ejemplos.igu.swing.eventos.LaminaConBotones;
import com.ejemplos.igu.swing.eventos.MarcoConEventos;

public class PruebaEventosClaseInterna {
    public static void main(String[] args) {
        MarcoConEventos marco = new MarcoConEventos();

        LaminaClaseInterna lamina = new LaminaClaseInterna();

        marco.setTitle("Prueba de eveentos con bonotnes");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(lamina);
    }

}

class LaminaClaseInterna extends LaminaConBotones {

    private class ColorDeFondo implements ActionListener {
        private Color colorDeFondo;

        ColorDeFondo(Color colorDeFondo) {
            this.colorDeFondo = colorDeFondo;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            setBackground(colorDeFondo);
        }

    }

    public LaminaClaseInterna() {
        super();

        ColorDeFondo colorAmarillo = new ColorDeFondo(Color.yellow);
        ColorDeFondo colorAzul = new ColorDeFondo(Color.blue);
        ColorDeFondo colorRojo = new ColorDeFondo(Color.red);

        botonAmarillo.addActionListener(colorAmarillo);
        botonAzul.addActionListener(colorAzul);
        botonRojo.addActionListener(colorRojo);
    }
}
