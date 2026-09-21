package com.ejemplos.igu.swing.eventos.accionEvents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventosClaseInterna {
    public static void main(String[] args) {
        Marco marco = new Marco();
        LaminaClaseInterna lamina = new LaminaClaseInterna();

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

class LaminaClaseInterna extends JPanel {
    private JButton botonAzul = new JButton("Azul");
    private JButton botonAmarillo = new JButton("Amarillo");
    private JButton botonRojo = new JButton("Rojo");

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
        add(botonAmarillo);
        add(botonAzul);
        add(botonRojo);

        ColorDeFondo colorAmarillo = new ColorDeFondo(Color.yellow);
        ColorDeFondo colorAzul = new ColorDeFondo(Color.blue);
        ColorDeFondo colorRojo = new ColorDeFondo(Color.red);

        botonAmarillo.addActionListener(colorAmarillo);
        botonAzul.addActionListener(colorAzul);
        botonRojo.addActionListener(colorRojo);
    }
}
