package com.ejemplos.igu.swing.eventos.multiplesEvents;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ejemplos.igu.swing.eventos.MarcoConEventos;

public class MultiplesOyentes {

    public static void main(String[] args) {
        MarcoConEventos marco = new MarcoConEventos();
        LaminaOyentes lamina = new LaminaOyentes();

        marco.setTitle("Prueba de multiples oyentes");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.add(lamina);
    }
}

class LaminaOyentes extends JPanel {
    LaminaOyentes() {
        JButton newWindow = new JButton("Nueva ventana");
        JButton closeAll = new JButton("Cerrar todas");
        newWindow.addActionListener(e -> new PruebaWindows(closeAll));

        add(newWindow);
        add(closeAll);
    }
}

class PruebaWindows extends JFrame {
    private static int newWindowCount = 0;

    PruebaWindows(JButton closeAll) {
        newWindowCount++;
        setTitle("Ventana " + newWindowCount);
        setBounds(40 * newWindowCount, 40 * newWindowCount, 300, 150);
        setVisible(true);

        closeAll.addActionListener(e -> dispose());
    }
}