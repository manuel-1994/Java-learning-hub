package com.ejemplos.igu.swing.layouts;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class PruebaFlowLayout {
    public static void main(String[] args) {
        MarcoFlowLayout marco = new MarcoFlowLayout();
        LaminaFlowLayout lamina = new LaminaFlowLayout();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(lamina);
    }
}

class MarcoFlowLayout extends JFrame {
    MarcoFlowLayout() {
        setTitle("Prueba FlowLayout");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class LaminaFlowLayout extends JPanel {
    LaminaFlowLayout() {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));

        add(new JButton("Boton 1"));
        add(new JButton("Boton 2"));
    }
}