package com.ejemplos.igu.swing.basico;

import javax.swing.*;

public class CreandoMarco {
    public static void main(String[] args) {
        MiMarco miMarco1 = new MiMarco();
        miMarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MiMarco extends JFrame {
    public MiMarco() {
        setTitle("Mi primer marco");
        setSize(400, 300);
        setVisible(true);
    }
}