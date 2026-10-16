package com.ejemplos.igu.swing.layouts;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class PruebaBorderLayout {
    public static void main(String[] args) {
        MarcoBorderLayout marco = new MarcoBorderLayout();
        LaminaBorderLayout lamina = new LaminaBorderLayout();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(lamina);
    }
}

class MarcoBorderLayout extends JFrame {
    MarcoBorderLayout() {
        setTitle("Prueba Border layout");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class LaminaBorderLayout extends JPanel {
    LaminaBorderLayout() {
        setLayout(new BorderLayout());

        addButton("boton norte", BorderLayout.NORTH);
        addButton("boton sur", BorderLayout.SOUTH);
        addButton("boton este", BorderLayout.EAST);
        addButton("boton oeste", BorderLayout.WEST);
        addButton("boton centro", BorderLayout.CENTER);
    }

    private void addButton(String nameButton, String position) {
        add(new JButton(nameButton), position);
    }
}