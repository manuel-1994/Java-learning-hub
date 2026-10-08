package com.ejemplos.igu.swing.eventos.multiplesEvents;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.ejemplos.igu.swing.eventos.MarcoConEventos;

public class MultipleFuentes {

    public static void main(String[] args) {
        MarcoConEventos miMarco = new MarcoConEventos();
        LaminaFuentes laminaFuentes = new LaminaFuentes();
        miMarco.setTitle("Practica con multiples fuentes de eventos");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        miMarco.add(laminaFuentes);
    }
}

class LaminaFuentes extends JPanel {
    LaminaFuentes() {
        ActionColor actionYellow = new ActionColor("Amarillo", Color.yellow, this);
        ActionColor actionBlue = new ActionColor("Azul", Color.blue, this);
        ActionColor actionRed = new ActionColor("Rojo", Color.red, this);

        JButton buttonYellow = new JButton(actionYellow);
        JButton buttonBlue = new JButton(actionBlue);
        JButton buttonRed = new JButton(actionRed);

        add(buttonYellow);
        add(buttonBlue);
        add(buttonRed);

        atajosDelTeclado("ctrl A", "backgound_yellow", actionYellow);
        atajosDelTeclado("ctrl B", "backgound_blue", actionBlue);
        atajosDelTeclado("ctrl R", "backgound_red", actionRed);
    }

    public void atajosDelTeclado(String comb, Object actionKey, Action action) {
        InputMap entryMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        entryMap.put(KeyStroke.getKeyStroke(comb), actionKey);

        ActionMap actionMap = getActionMap();

        actionMap.put(actionKey, action);
    }
}

class ActionColor extends AbstractAction {
    private JPanel panel;

    public ActionColor(String colorName, Color color, JPanel panel) {
        putValue(Action.NAME, colorName);
        putValue(Action.SHORT_DESCRIPTION, "Pone la lamina de color: " + colorName);
        putValue("background_color", color);

        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Color color = (Color) getValue("background_color");

        panel.setBackground(color);
    }

}