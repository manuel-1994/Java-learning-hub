package com.ejemplos.igu.swing.eventos.maouseEvents;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PruebaMauseEvent {
    public static void main(String[] args) {
        MarcoMause marco = new MarcoMause();
        LaminaMause lamina = new LaminaMause();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(lamina);
    }
}

class MarcoMause extends JFrame {
    MarcoMause() {
        setTitle("Prueba");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class LaminaMause extends JPanel {
    JButton boton = new JButton("Hola");

    LaminaMause() {
        add(boton);
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                boton.setBackground(Color.blue);
                boton.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(null);
                boton.setForeground(null);
            }

        });

    }
}

/*
 * class CambioColor implements MouseListener {
 * 
 * private Color color;
 * private JButton button;
 * 
 * CambioColor(JButton button, Color color) {
 * this.color = color;
 * this.button = button;
 * }
 * 
 * @Override
 * public void mouseClicked(MouseEvent arg0) {
 * // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override
 * public void mouseEntered(MouseEvent arg0) {
 * button.setBackground(color);
 * button.setForeground(Color.white);
 * }
 * 
 * @Override
 * public void mouseExited(MouseEvent arg0) {
 * button.setBackground(null);
 * button.setForeground(null);
 * }
 * 
 * @Override
 * public void mousePressed(MouseEvent arg0) {
 * // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override
 * public void mouseReleased(MouseEvent arg0) {
 * // TODO Auto-generated method stub
 * 
 * }
 * 
 * }
 */