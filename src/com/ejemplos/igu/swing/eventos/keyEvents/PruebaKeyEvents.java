package com.ejemplos.igu.swing.eventos.keyEvents;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.ejemplos.igu.swing.eventos.MarcoConEventos;

public class PruebaKeyEvents {
    public static void main(String[] args) {
        MarcoConEventos miMarco = new MarcoConEventos();
        EventoKey miEvento = new EventoKey();

        miMarco.setTitle("Prueba key events");
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        miMarco.addKeyListener(miEvento);
    }
}

class EventoKey implements KeyListener {

    @Override
    public void keyPressed(KeyEvent arg0) {
        System.out.println("estoy presionando la tecla " + arg0.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

}
